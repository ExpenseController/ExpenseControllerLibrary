package br.com.expenseController.controller;

import br.com.expenseController.model.Tag;

public interface TagControllerOperations {

    boolean insert(Tag tag);

    boolean update(Tag tag);

    boolean remove(Tag tag);

    Tag load(int code);
}