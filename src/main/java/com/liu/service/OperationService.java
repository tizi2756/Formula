package com.liu.service;

import com.liu.entity.Operation;
import com.liu.mode.Formula;
import com.liu.serviceI.OperationServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OperationService implements OperationServiceI {
    @Transactional
    @Override
    public List<Formula> formulas(int value1, int value2, int num, int limit, int flag1, int flag2){
        List<Formula> formulaList=null;
        Formula formula=null;
        int number[]=new int[100];
        int n=0;
        String poperator[]=new String[100];
        for (int i=0;i<num;i++){
            number[0]=Operation.make(value1,value2);
            int count=0;
            int m=Operation.make(1,limit);
            System.out.println(m);
            for (int j=1;j<=m;j++){
                count++;
                if (flag1==1){
                    n=Operation.make(0,3);
                }
                else if (flag1==0){
                    n=Math.random()>0.5?1:0;
                }
                switch (n){
                    case 0:
                        poperator[j]="+";
                        number[j+1]=Operation.make(2,100);
                        break;
                    case 1:
                        poperator[j]="-";
                        number[j+1]=Operation.make(2,100);
                        if(number[j]<number[j+1]){
                            int temp=number[j];
                            number[j]=number[j+1];
                            number[j+1]=temp;
                        }
                        break;
                    case 2:
                        if (poperator[j-1]=="*"||poperator[j-1]=="/"){
                            poperator[j]="+";
                            number[j+1]=Operation.make(2,100);
                        }
                        else {
                            poperator[j]="*";
                            number[j+1]=Operation.make(2,100);
                        }
                        break;
                    case 3:
                        if(poperator[j-1]=="*"||poperator[j-1]=="÷"){
                            poperator[j]="+";
                            number[j+1]=Operation.make(2,10);
                        }else{
                            poperator[j]="÷";
                            number[j+1]=Operation.make(2,10);
                            number[j]=number[j+1]*Operation.make(2,10);
                        }
                        break;
                }
            }
            String question=""+number[0];
            poperator[1]="+";
            for(int k=1;k<count;k++){
                int rd=Math.random()>0.5?1:0;
                if (flag2==0){
                    rd=0;
                }
                question+=poperator[k]+number[k+1];
                if (rd==1){
                    question='('+question+')';
                }
            }
            question+="=";
            int answer=Operation.solve(question);
//            if(answer>=0){
//                question = question + " = "+answer;
//            }else{
//                break;
//            }
            formula.setSubject(question);
            formula.setAnswer(answer);
            formulaList.add(1,formula);
            formula=null;

        }
        return formulaList;
    }
}

