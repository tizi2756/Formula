package com.liu.mode;

public class Formula {
    private String subject;
    private int answer;
    private String judge;
    private int result;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Formula(String subject, int answer, String judge, int result){
        this.subject=subject;
        this.answer=answer;
        this.judge=judge;
        this.result=result;
    }
    public Formula(){}

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
