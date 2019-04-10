package com.liu.serviceI;

import com.liu.mode.Formula;
import com.liu.mode.Score;
import com.liu.mode.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OperationServiceI  {
//    List<Formula> formulas(int value1, int value2, int num, int limit, int flag1, int flag2);

    List<Formula> formulas(int value1, int value2, int num, int limit, int flag1, int flag2, String Question[]);

    @Transactional
    int insertStudent(Student student);

    boolean login(String username, String password);

    int insertScore(Score score);
}
