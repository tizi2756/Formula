package com.liu.service;

import com.liu.entity.Operation;
import com.liu.mapper.projectMapper;
import com.liu.mode.Formula;
import com.liu.mode.Score;
import com.liu.mode.Student;
import com.liu.serviceI.OperationServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OperationService implements OperationServiceI {
    private AtomicLong generator =  new AtomicLong();
    @Autowired
    private projectMapper projectMapper;


    @Override
    public List<Formula> formulas(int value1, int value2, int num, int limit, int flag1, int flag2, String Question[]){
        List<Formula> formulaList=new ArrayList<Formula>();
        int number[]=new int[100];
        int n=0;
        String question=null;
        String poperator[]=new String[100];
        for (int i=0;i<num;i++){
            Formula formula=new Formula();
            number[0]=Operation.make(value1,value2);
            int count=0;
            int m=Operation.make(2,limit+2);
//            System.out.println(m);
            for (int j=1;j<=m;j++){
                count++;
                if (flag1==1){
                    n=(int) (Math.random()*(4));
                }
                else if (flag1==0){
                    n=Math.random()>0.5?1:0;
                }
                switch (n){
                    case 0:
                        poperator[j]="+";
                        number[j+1]=Operation.make(value1,value2);
                        break;
                    case 1:
                        poperator[j]="-";
                        number[j+1]=Operation.make(value1,value2);
                        if(number[j]<number[j+1]){
                            int temp=number[j];
                            number[j]=number[j+1];
                            number[j+1]=temp;
                        }
                        break;
                    case 2:
                        if (poperator[j-1]=="*"||poperator[j-1]=="/"){
                            poperator[j]="+";
                            number[j+1]=Operation.make(value1,value2);
                        }
                        else {
                            poperator[j]="*";
                            number[j+1]=Operation.make(value1,value2);
                        }
                        break;
                    case 3:
                        if(poperator[j-1]=="*"||poperator[j-1]=="÷"){
                            poperator[j]="+";
                            number[j+1]=Operation.make(value1,value2);
                        }else{
                            poperator[j]="÷";
                            number[j+1]=Operation.make(value1,value2);
                            number[j]=number[j+1]*Operation.make(2,10);
                            if (number[j]>value2){
                                number[j]=number[j+1]*Operation.make(2,4);
                            }
                        }
                        break;
                }
            }
            String question1=""+number[0];
            poperator[1]="+";
            for(int k=1;k<count;k++){
                int rd=Math.random()>0.5?1:0;
                if (flag2==0){
                    rd=0;
                }
                question1+=poperator[k]+number[k+1];
                if (rd==1){
                    if (k<count-1)
                    question1="("+question1+")";
                }
            }
            System.out.println("---"+question1);
            int answer=Operation.solve(question1);
            if(answer>=0){
                question = question1 + "=";
            }else{
                String temp=Operation.makequestion(value1,value2,limit,flag1,flag2);
                question=temp+"=";
                answer=Operation.solve(temp);
            }
            System.out.println("-------"+answer);
            formula.setSubject(question);
            formula.setAnswer(answer);
            formulaList.add(i,formula);
//            formula=null;
            Question[i]=question;
        }
        return formulaList;
    }

    @Transactional
    @Override
    public int insertStudent(Student student){
        if(student.getUsername().equals("")){
            throw new RuntimeException("name is null");
        }
        return projectMapper.insertStudent(student);
    }
    @Override
    public boolean login(String username, String password){
        System.out.println("11111");
        Student student=projectMapper.nameselect(username);
//        System.out.println("2222");
        System.out.println(student);
        if (student!=null){
            if (student.getUsername().equals(username) && student.getPassword().equals(password)){
                System.out.println("3333");
                return  true;
            }
        }
        return false;
    }

    @Override
    public int insertScore(Score score){
        return projectMapper.insertScore(score);
    }
}

