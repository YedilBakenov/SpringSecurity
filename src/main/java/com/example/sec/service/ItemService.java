package com.example.sec.service;

import com.example.sec.dto.ItemDTO;
import com.example.sec.mapper.ItemMapper;
import com.example.sec.model.Item;
import com.example.sec.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public List<ItemDTO> getItems() {
       return itemMapper.toDtoList(itemRepository.findAll());
    }

    public ItemDTO createItem(ItemDTO item) {
        String mark = calculateMark(item.getPoint());
        item.setGrade(mark);
        itemRepository.save(itemMapper.toModel(item));
        return item;
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

    public ItemDTO updateItem(ItemDTO item) {
        if (item == null) {
            return null;
        }

        ItemDTO item1 = getItemById(item.getId());

        String mark = calculateMark(item.getPoint());
        item1.setGrade(mark);
        item1.setName(item.getName());

        Item item2 = itemMapper.toModel(item1);
        itemRepository.save(item2);

        return item1;
    }

    public ItemDTO getItemById(int id) {
        return itemMapper.toDto(itemRepository.findById(id).orElseThrow());
    }

    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }
}
