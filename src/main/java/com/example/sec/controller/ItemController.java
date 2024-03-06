package com.example.sec.controller;

import com.example.sec.dto.ItemDTO;
import com.example.sec.model.Item;
import com.example.sec.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping(value = "/all-items")
    public List<ItemDTO> getItems(){
       return itemService.getItems();
    }

    @PostMapping(value ="/add-item" )
    public ItemDTO addItem(@RequestBody ItemDTO item){
        return itemService.createItem(item);
    }

    @PutMapping(value = "/update-item")
    public ItemDTO editItem(@RequestBody ItemDTO item){
        return itemService.updateItem(item);
    }

    @GetMapping(value = "/{id}")
    public ItemDTO getItem(@PathVariable int id){
        return itemService.getItemById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteItem(@PathVariable int id){
        itemService.deleteItem(id);
    }
}
