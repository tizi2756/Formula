package com.liu.mapper;

import com.liu.mode.Score;
import com.liu.mode.Student;

public interface projectMapper {
    public int insertStudent(Student student);
    public Student nameselect(String username);
    public int insertScore(Score score);
    public int insertScoreId(Student student);
}
