package com.sofka.backToDolist.services;

import com.sofka.backToDolist.models.ToDoItemModel;
import com.sofka.backToDolist.repositories.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ToDoItemService {

    @Autowired
    ToDoItemRepository toDoItemRepository;

    public ArrayList<ToDoItemModel> getToDoItems(){
        return (ArrayList<ToDoItemModel>) toDoItemRepository.findAll();
    }

    public ToDoItemModel saveToDoItem(ToDoItemModel toDoItem){
        return toDoItemRepository.save(toDoItem);
    }

    public ToDoItemModel updateToDoItem(ToDoItemModel toDoItem){
        return toDoItemRepository.save(toDoItem);
    }

    public boolean deleteToDoItem(Long id) {
        try{
            toDoItemRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
