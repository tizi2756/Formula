package com.liu.mode;

public class Score {
    int id;
    int score;
    int number;
    public Score(int id,int score,int number){
        this.id=id;
        this.score=score;
        this.number=number;
    }
    public Score(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
