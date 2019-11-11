package br.com.expenseController.persistence;

import br.com.expenseController.model.Transaction;
import java.util.List;

public interface TransactionPersistenceOperations {

    boolean insert(Transaction transaction);

    boolean update(Transaction transaction);

    boolean remove(Transaction transaction);

    Transaction load(int code);

    List<Transaction> loadAll();
}