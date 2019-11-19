package br.com.expenseController.persistence;

import br.com.expenseController.model.Period;
import java.util.List;

public interface PeriodsPersistenceOperations {

    boolean save(List<Period> periods);

    Period load(int code);

    List<Period> loadAll();
}