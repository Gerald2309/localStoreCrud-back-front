package com.sofka.backToDolist.services;

import com.sofka.backToDolist.models.ToDoItemModel;
import com.sofka.backToDolist.repositories.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ToDoItemService {

    @Autowired
    ToDoItemRepository toDoItemRepository;

    public ArrayList<ToDoItemModel> obtenerToDoItems(){
        return (ArrayList<ToDoItemModel>) toDoItemRepository.findAll();
    }

    public ToDoItemModel guardarToDoItem(ToDoItemModel toDoItem){
        return toDoItemRepository.save(toDoItem);
    }

    public ToDoItemModel actualizarToDoItem(ToDoItemModel toDoItem){
        return toDoItemRepository.save(toDoItem);
    }

    public boolean eliminarToDoItem(Long id) {
        try{
            toDoItemRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
