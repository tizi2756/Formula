package com.liu.controller;

import com.liu.entity.Operation;
import com.liu.mapper.projectMapper;
import com.liu.mode.Formula;
import com.liu.mode.Score;
import com.liu.mode.Student;
import com.liu.serviceI.OperationServiceI;
import org.apache.commons.logging.Log;
import org.apache.ibatis.annotations.Param;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("")
public class cController {
    private static final Log logger = LogFactory.getLog(cController.class);
    @Autowired
    private OperationServiceI operationServiceI;
    @Autowired
    private projectMapper projectMapper;

    /**
     * @param value1s
     * @param value2s
     * @param amounts
     * @param limits
     * @param flag1s
     * @param flag2s*/
    @RequestMapping(value = "/operationAll")
    public String All(Model model, HttpSession session, String value1s, String value2s, String amounts, String limits, String flag1s, String flag2s){
        String[] var=new String[1000];
        int flag1;
        int flag2;
        int value1= Integer.parseInt(value1s);
//        System.out.println(value1);
        int value2=Integer.parseInt(value2s);
        if (value1>value2){
            int temp=value1;
            value1=value2;
            value2=temp;
        }
//        System.out.println(value2);
        int num=Integer.parseInt(amounts);
//        System.out.println(num);
        int limit=Integer.parseInt(limits);
//        System.out.println(limit);
        if (flag1s==null||flag1s.equals("")||flag1s.equals("null")){
            flag1=0;
        }
        else
            flag1=Integer.parseInt(flag1s);
//        System.out.println(flag1);
        if (flag2s==null||flag2s.equals("")||flag2s.equals("null")){
            flag2=0;
        }
        else
            flag2=Integer.parseInt(flag2s);
//        System.out.println(flag2);
        long start=System.currentTimeMillis();
        List<Formula> formulas=operationServiceI.formulas(value1,value2,num,limit,flag1,flag2,var);
        try {
            Operation.printfile(var, num);
        } catch (Exception var4) {
            System.out.println("wrong");
        }
        session.setAttribute("for",formulas);
        session.setAttribute("num",num);
        session.setAttribute("start",start);
        model.addAttribute("c",formulas);
        return "exercise";
    }

    @RequestMapping(value = "/Result")
    public String Result(HttpServletRequest request,HttpSession session,Model model){
        int m=0;
        int score=0;
        long end=System.currentTimeMillis();
        long start= (long) session.getAttribute("start");
        long time=(end-start)/1000;
        long Seconds=time%60;
        long Minutes=(time/60)%60;
        double num= (Integer) session.getAttribute("num") * 1.0;
        int id= (int) session.getAttribute("id");
        String[] result=request.getParameterValues("result");
        Score score1=new Score();
        List<Formula> formulas=(List)session.getAttribute("for");
        for (int i=0;i<num;i++){
            if (Integer.parseInt(result[i])==formulas.get(i).getAnswer()){
                formulas.get(i).setJudge("正确！");
                formulas.get(i).setResult(Integer.parseInt(result[i]));
                m++;
            }
            else {
                formulas.get(i).setJudge("错误！");
                formulas.get(i).setResult(Integer.parseInt(result[i]));
            }
        }
        score= (int) ((m/num)*100);
        request.setAttribute("score",score);
        request.setAttribute("se",Seconds);
        request.setAttribute("mi",Minutes);
        session.setAttribute("for",formulas);
        model.addAttribute("a",formulas);
        score1.setId(id);
        score1.setScore(score);
        score1.setNumber((int) num);
        operationServiceI.insertScore(score1);
        return "answerPage";
    }

    /**
     * @param username
     * @param password
     * @param phone
     */
    @RequestMapping(value = "/studentAdd")
    public String StudentAdd(String username,String password,String phone,HttpServletRequest request){
        Student student=new Student();
        try{
            student.setUsername(username);
            student.setPassword(password);
            student.setPhone(phone);
            if (operationServiceI.insertStudent(student)>0){
                request.setAttribute("message", "添加成功");
                Student student2=projectMapper.nameselect(username);
                projectMapper.insertScoreId(student2);
                System.out.println("22222");
            }
            else {
                request.setAttribute("message", "添加失败");
                System.out.println("3333");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Addsuccess";
    }
    /**
     * @param username
     * @param password
     */
    @RequestMapping(value = "/Login")
    public String Login(String username,String password,HttpSession session){
        System.out.println(username);
        boolean bl=operationServiceI.login(username,password);
        if (bl) {
            Student student=projectMapper.nameselect(username);
            session.setAttribute("id",student.getId());
            return "userchoice";
        } else {
            return "Loginfalse";
        }
    }
}
