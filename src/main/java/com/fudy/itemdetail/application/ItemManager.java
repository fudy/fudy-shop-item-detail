package com.fudy.itemdetail.application;

import com.fudy.itemdetail.application.assembler.ItemAssembler;
import com.fudy.itemdetail.domain.Item;
import com.fudy.itemdetail.infrastructure.dubbo.ItemServiceFacade;
import com.fudy.itemdetail.interfaces.web.vo.ItemVO;
import com.fudy.shop.item.api.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ItemManager {
    @Autowired
    private ItemServiceFacade facade;
    @Autowired
    private ItemAssembler assembler;

    public ItemVO getItem(Long id) throws Exception {
        Item item = facade.getItem(id);
        Objects.requireNonNull(item, "can't find the item");
        item.calcMinAndMaxPrice();
        return assembler.toItemVO(item);
    }

}
