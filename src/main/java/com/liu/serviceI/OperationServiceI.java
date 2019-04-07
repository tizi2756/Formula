package com.liu.serviceI;

import com.liu.mode.Formula;

import java.util.List;

public interface OperationServiceI  {
    List<Formula> formulas(int value1, int value2, int num, int limit, int flag1, int flag2);
}
