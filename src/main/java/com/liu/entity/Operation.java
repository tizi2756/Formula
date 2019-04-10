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
        int ifsame = 0;
        int answer = 0;
        char[] q;
        q=question.toCharArray();
        int k=0;
        //System.out.println(q);
        Stack<Character> s=new Stack<Character>();
        Stack<Integer> n=new Stack<Integer>();
        for(int i=0;i<q.length;i++){
            char temp=q[i];
            if(q[i]=='0'&&!(Character.isDigit(q[i-1]))){//&&!(Character.isDigit(q[i+1]))
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

                        int t=calculateSimple(String.valueOf(s.pop()), n.pop(), n.pop());
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

                            int t=calculateSimple(String.valueOf(s.pop()), n.pop(), n.pop());
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
            int t=calculateSimple(String.valueOf(s.pop()), n.pop(), n.pop());
            //System.out.println(t+"==");
            n.push(t);
        }//压入
        //s.push('0');
        //System.out.println(s.pop());
        return n.pop();
//        Stack var1 = new Stack();
//        Stack var2 = new Stack();
//        int var3 = (int)(Math.random() * 2.0D) + 2;
//        int var4 = var0.length();
//        int var5 = 0;
//        int var6 = 0;
//
//        for(int var7 = -1; var7 < var4 - 1; ++var7) {
//            if (var0.charAt(var7 + 1) == '+' || var0.charAt(var7 + 1) == '-' || var0.charAt(var7 + 1) == '*' || var0.charAt(var7 + 1) == 247 || var0.charAt(var7 + 1) == '(' || var0.charAt(var7 + 1) == ')' || var7 == var4 - 2) {
//                if (var7 == -1) {
//                    var2.push(var0.charAt(0));
//                } else {
//                    if (var7 == var4 - 2) {
//                        var1.push(var0.substring(var5));
//                        break;
//                    }
//
//                    if (var5 <= var7) {
//                        var1.push(var0.substring(var5, var7 + 1));
//                    }
//
//                    if (!var2.empty() && var0.charAt(var7 + 1) != '(') {
//                        if ((Character)var2.peek() != '+' && (Character)var2.peek() != '-' || var0.charAt(var7 + 1) != '*' && var0.charAt(var7 + 1) != 247) {
//                            if ((Character)var2.peek() == '(') {
//                                var2.push(var0.charAt(var7 + 1));
//                            } else if (var0.charAt(var7 + 1) == ')') {
//                                var1.push(String.valueOf(var2.pop()));
//                                if (!var2.empty()) {
//                                    var2.pop();
//                                }
//                            } else {
//                                if ((Character)var2.peek() == var0.charAt(var7 + 1)) {
//                                    ++var6;
//                                }
//
//                                var1.push(String.valueOf(var2.pop()));
//                                var2.push(var0.charAt(var7 + 1));
//                            }
//                        } else {
//                            var2.push(var0.charAt(var7 + 1));
//                        }
//                    } else {
//                        var2.push(var0.charAt(var7 + 1));
//                    }
//                }
//
//                var5 = var7 + 2;
//            }
//        }
//
//        if (var6 == var3 + 2) {
//            ifsame = 1;
//        }
//
//        while(!var2.empty()) {
//            var1.push(String.valueOf(var2.pop()));
//        }
//
//        String[] var12 = new String[20];
//
//        int var8;
//        for(var8 = 0; !var1.empty(); ++var8) {
//            var12[var8] = (String)var1.pop();
//        }
//
//        --var8;
//
//        for(; var8 >= 0; --var8) {
//            if (!var12[var8].equals("+") && !var12[var8].equals("-") && !var12[var8].equals("*") && !var12[var8].equals("÷")) {
//                var1.push(var12[var8]);
//            } else {
//                int var9 = 0;
//                int var10 = 0;
//                if (!var1.empty()) {
//                    var10 = Integer.parseInt((String)var1.pop());
//                }
//
//                if (!var1.empty()) {
//                    var9 = Integer.parseInt((String)var1.pop());
//                }
//
//                int var11 = calculateSimple(var12[var8], var9, var10);
//                var1.push(String.valueOf(var11));
//            }
//        }
//
//        if (Integer.parseInt((String)var1.peek()) < 0) {
//            answer = 1;
//        }
//
//        if (ifsame != 1 && answer != 1) {
//            return Integer.parseInt((String)var1.pop());
//        } else {
//            return Integer.parseInt((String)var1.pop());
//        }
    }

    private static int calculateSimple(String operator, int a, int b) {

        int  result = 0;
        switch (operator)
        {
            case "+":
                result = a + b;
                break;
            case "-":
                result = b - a;
                break;
            case "*":
                result = a * b;
                break;
            case "÷":
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

    public static String makequestion(int value1, int value2, int limit, int flag1, int flag2){
        int number[]=new int[100];
        int n=0;
        String poperator[]=new String[100];
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
                        number[j]=number[j+1]*Operation.make(2,4);
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
        return question1;
    }
}
