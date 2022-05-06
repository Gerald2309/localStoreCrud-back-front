package com.sofka.backToDolist.controllers;

import com.sofka.backToDolist.models.ToDoItemModel;
import com.sofka.backToDolist.services.ToDoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/todoitem")
public class ToDoItemController {

    @Autowired
    ToDoItemService toDoItemService;

    @GetMapping()
    public ArrayList<ToDoItemModel> getToDoItems() {
        return toDoItemService.getToDoItems();
    }

    @PostMapping()
    public ToDoItemModel saveToDoItem(@RequestBody ToDoItemModel toDoItem) {
        return this.toDoItemService.saveToDoItem(toDoItem);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteToDoItem(@PathVariable("id") Long id) {
        boolean ok = this.toDoItemService.deleteToDoItem(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        } else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }

    @PutMapping(path = "/actualizar")
    public ToDoItemModel updateToDoItem(@RequestBody ToDoItemModel usuario) {
        return this.toDoItemService.updateToDoItem(usuario);
    }
}


