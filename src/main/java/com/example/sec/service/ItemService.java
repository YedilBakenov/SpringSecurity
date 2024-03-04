package com.example.sec.service;

import com.example.sec.model.Item;
import com.example.sec.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item createItem(Item item) {
        String mark = calculateMark(item.getPoint());
        item.setMark(mark);
        return itemRepository.save(item);
    }

    private String calculateMark(Integer point) {
        if (point == null) {
            return null;
        }

        switch (point) {
            case 1:
            case 2:
                return "BAD";
            case 3:
                return "NOT_BAD";
            case 4:
                return "GOOD";
            case 5:
                return "GREAT";
            default:
                return null;
        }
    }

    public Item updateItem(Item item) {
        if (item == null) {
            return null;
        }

        Item item1 = getItemById(item.getId());

        String mark = calculateMark(item.getPoint());
        item1.setMark(mark);
        item1.setName(item.getName());

        return itemRepository.save(item1);
    }

    public Item getItemById(int id) {

        return itemRepository.findById(id).orElse(null);
    }

    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }
}
