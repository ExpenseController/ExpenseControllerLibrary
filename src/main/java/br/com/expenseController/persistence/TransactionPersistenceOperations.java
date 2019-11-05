package br.com.expenseController.persistence;

import br.com.expenseController.model.Period;
import br.com.expenseController.model.Transaction;

public interface TransactionPersistenceOperations {

    boolean insert(Transaction transaction);

    boolean update(Transaction transaction);

    boolean remove(Transaction transaction);

    Transaction load(int code);

    Transaction[] loadAll();

    Transaction[] loadPeriod(Period Period);
}