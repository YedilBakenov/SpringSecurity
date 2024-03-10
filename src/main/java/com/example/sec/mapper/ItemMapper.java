package com.example.sec.mapper;


import com.example.sec.dto.ItemDTO;
import com.example.sec.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(source ="mark", target = "grade")
    ItemDTO toDto(Item item);

    @Mapping(source = "grade", target = "mark")
    Item toModel(ItemDTO itemDTO);

    List<ItemDTO> toDtoList(List<Item> itemList);

    List<Item> toModelList(List<ItemDTO> itemDTOS);
}
