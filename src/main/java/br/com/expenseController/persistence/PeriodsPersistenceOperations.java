package br.com.expenseController.persistence;

import br.com.expenseController.model.Period;
import java.util.List;

public interface PeriodsPersistenceOperations {

    boolean insert(Period period);

    boolean update(Period period);

    boolean remove(Period period);

    Period load(int code);

    List<Period> loadAll();
}