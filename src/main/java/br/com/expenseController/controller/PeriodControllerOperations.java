package br.com.expenseController.controllers;

import br.com.expenseController.Period;

public interface PeriodControllerOperations {

    boolean insert(Period period);

    boolean update(Period period);

    boolean remove(Period period);

    Period load(int code);

    Period[] loadAll();
}