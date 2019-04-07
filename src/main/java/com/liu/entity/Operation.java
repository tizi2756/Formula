package com.liu.entity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Stack;


public class Operation {
    public static int make(int min,int max){
        return new Random().nextInt(max-min)+min;
    }
    private  static  int first(char s){
        switch (s){
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '÷':
                return 2;
            default:
                return -1;
        }
    }

    public static int solve(String question){

        char[] q;
        q=question.toCharArray();
        int k=0;
        //System.out.println(q);
        Stack<Character> s=new Stack<Character>();
        Stack<Integer> n=new Stack<Integer>();
        for(int i=0;i<q.length;i++){
            char temp=q[i];
            if(q[i]=='0'&&!(Character.isDigit(q[i-1]))&&!(Character.isDigit(q[i+1]))){
                k = k*10 + Integer.parseInt(String.valueOf(0));
                n.push(k);
            }
            if(Character.isDigit(q[i])||q[i]=='0'){//数字进栈
                k = k*10 + Integer.parseInt(String.valueOf(q[i]));
                if(i==q.length-1){
                    n.push(k);
                    //System.out.println(k+"pp");
                    k=0;
                }
            }else{
                if(k!=0){
                    n.push(k);

                    //System.out.println(k+"oo");
                    k=0;
                }
                if(temp=='('){
                    s.push(temp);
                }else if((temp == ')')){
                    while(s.peek()!='('){//左括号前出栈

                        int t=calculateSimple(s.pop(), n.pop(), n.pop());
                        n.push(t);
                    }
                    s.pop();
                }else if(temp == '+' || temp == '-' || temp == '*' || temp == 247 || temp == '(' || temp == ')' ){
                    if(s.isEmpty()){
                        s.push(temp);
                        //System.out.println(s.peek()+"++");
                    }else{
                        if(first(temp)<= first((s.peek()))){//优先级不大于栈顶 ，出栈后压入

                            //System.out.println(s.peek());

                            int t=calculateSimple(s.pop(), n.pop(), n.pop());
                            //System.out.println(t+"kk");

                            //System.out.println(s.peek()+"dd");
                            n.push(t);
                        }

                        s.push(temp);
                        //System.out.println(s.peek()+"--");

                    }

                }
            }
        }
        if(k!=0){
            n.push(k);
        }
        while(!s.empty()&&n.size()>=2){
            int t=calculateSimple(s.pop(), n.pop(), n.pop());
            //System.out.println(t+"==");
            n.push(t);
        }//压入
        //s.push('0');
        //System.out.println(s.pop());
        return n.pop();
    }

    private static int calculateSimple(char operator, int a, int b) {

        int  result = 0;
        switch (operator)
        {
            case '+':
                result = a + b;
                break;
            case '-':
                result = b - a;
                break;
            case '*':
                result = a * b;
                break;
            case '÷':
                if(a==0) break;
                else{
                    result = b / a;
                    break;
                }
        }
        return result;
    }

    public static void printfile(String[]QuestionSum,int Qnumber)throws IOException {
        FileOutputStream fs = new FileOutputStream(new File("./results.txt"));
        PrintStream p = new PrintStream(fs);
        p.println("2017011838");
        for(int i=0;i<Qnumber;i++){
            p.println(QuestionSum[i]);
            System.out.println(QuestionSum[i]);
        }
        p.close();

    }
}
