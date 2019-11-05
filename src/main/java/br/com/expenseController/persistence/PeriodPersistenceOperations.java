package br.com.expenseController.persistence;

import br.com.expenseController.model.Period;

public interface PeriodPersistenceOperations {

    boolean insert(Period period);

    boolean update(Period period);

    boolean remove(Period period);

    Period load(int code);

    Period[] loadAll();
}