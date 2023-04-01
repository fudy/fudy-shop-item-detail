package com.fudy.itemdetail.infrastructure.dubbo;

import com.fudy.itemdetail.domain.Item;
import com.fudy.itemdetail.infrastructure.dubbo.convertor.ItemConvertor;
import com.fudy.shop.item.api.ItemService;
import com.fudy.shop.item.api.dto.ItemDTO;
import com.fudy.shop.item.api.dto.ItemQuery;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fudy.shop.common.Result;

import java.util.Objects;

@Service
public class ItemServiceFacade {
    @DubboReference(check = false,version = "1.0.0")
    private ItemService itemService;
    @Autowired
    private ItemConvertor convertor;

    public Item getItem(Long itemId) throws Exception {
        ItemQuery query = new ItemQuery();
        query.setItemId(itemId);
        try {
            Result<ItemDTO> result = itemService.getItem(query);
            Objects.requireNonNull(result, "result should not be null");
            if (!result.isSuccess()) {
                throw new Exception(result.getErrorCode());
            }
            return convertor.toItem(result.getData());
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
