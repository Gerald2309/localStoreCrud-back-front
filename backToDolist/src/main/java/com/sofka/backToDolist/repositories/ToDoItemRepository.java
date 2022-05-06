package com.sofka.backToDolist.repositories;

import com.sofka.backToDolist.models.ToDoItemModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoItemRepository extends CrudRepository<ToDoItemModel, Long>  {
}
