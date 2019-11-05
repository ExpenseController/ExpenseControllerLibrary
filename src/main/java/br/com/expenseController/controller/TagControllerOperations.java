package br.com.expenseController.controllers;

import br.com.expenseController.Tag;

public interface TagControllerOperations {

    boolean insert(br.com.expenseController.Tag tag);

    boolean update(br.com.expenseController.Tag tag);

    boolean remove(br.com.expenseController.Tag tag);

    Tag load(int code);
}