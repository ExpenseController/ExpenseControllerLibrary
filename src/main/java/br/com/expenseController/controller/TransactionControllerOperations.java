package br.com.expenseController.controllers;

import br.com.expenseController.Period;
import br.com.expenseController.Transaction;

public interface TransactionControllerOperations {

    boolean insert(Transaction transaction);

    boolean update(Transaction transaction);

    boolean remove(Transaction transaction);

    Transaction load(int code);

    Transaction[] loadAll();

    Transaction[] loadPeriod(Period Period);
}