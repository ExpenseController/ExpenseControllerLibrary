package br.com.expenseController.persistence;

import br.com.expenseController.model.Tag;

public interface TagPersistenceOperations {

    boolean insert(Tag tag);

    boolean update(Tag tag);

    boolean remove(Tag tag);

    Tag load(int code);

    Tag[] loadAll();
}