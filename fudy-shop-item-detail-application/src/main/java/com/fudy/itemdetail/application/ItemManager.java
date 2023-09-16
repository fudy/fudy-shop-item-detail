package com.fudy.itemdetail.application;

import com.fudy.itemdetail.application.assembler.ItemAssembler;
import com.fudy.itemdetail.application.dto.ItemDTO;
import com.fudy.itemdetail.domain.Item;
import com.fudy.itemdetail.domain.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ItemManager {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemAssembler assembler;

    public ItemDTO getItem(Long id) throws Exception {
        Item item = itemService.getItem(id);
        Objects.requireNonNull(item, "can't find the item");
        item.calcMinAndMaxPrice();
        return assembler.toItemDTO(item);
    }

}
