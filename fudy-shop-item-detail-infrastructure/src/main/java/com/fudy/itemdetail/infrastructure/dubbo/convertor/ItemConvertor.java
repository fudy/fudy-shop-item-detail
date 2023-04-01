package com.fudy.itemdetail.infrastructure.dubbo.convertor;

import com.fudy.itemdetail.domain.Item;
import com.fudy.itemdetail.domain.ItemSku;
import com.fudy.shop.item.api.dto.ItemDTO;
import com.fudy.shop.item.api.dto.ItemSkuDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemConvertor {
    Item toItem(ItemDTO dto);

    ItemSku toItemSku(ItemSkuDTO dto);
}
