package br.com.expenseController.controller;

import br.com.expenseController.model.Period;

public interface PeriodControllerOperations {

    boolean insert(Period period);

    boolean update(Period period);

    boolean remove(Period period);

    Period load(int code);

    Period[] loadAll();
}