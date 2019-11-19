package br.com.expenseController.persistence;

import br.com.expenseController.model.Tag;
import java.util.List;

public interface TagPersistenceOperations {

    boolean save(List<Tag> tags);

    Tag load(int code);

    List<Tag> loadAll();
}