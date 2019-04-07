package com.liu.mode;

public class Formula {
    private String subject;
    private int answer;
    public Formula(String subject,int answer){
        this.subject=subject;
        this.answer=answer;
    }
    public Formula(){}

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
