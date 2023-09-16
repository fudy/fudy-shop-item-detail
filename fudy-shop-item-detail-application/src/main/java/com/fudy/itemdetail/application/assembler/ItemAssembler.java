package com.fudy.itemdetail.application.assembler;

import com.fudy.itemdetail.application.dto.ItemAttributeDTO;
import com.fudy.itemdetail.application.dto.ItemAttributeOptionDTO;
import com.fudy.itemdetail.application.dto.ItemDTO;
import com.fudy.itemdetail.application.dto.ItemSkuDTO;
import com.fudy.itemdetail.domain.Item;
import com.fudy.itemdetail.domain.ItemSku;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface ItemAssembler {

    default ItemDTO toItemDTO(Item item) {
        ItemDTO dto = new ItemDTO();
        dto.setTitle(item.getTitle());
        dto.setImageList(item.getImageList());
        dto.setMainImage(item.getMainImage());
        dto.setSalesVolume(item.getSales()+"");
        dto.setMinPrice(item.getMinPriceStr());
        dto.setMaxPrice(item.getMaxPriceStr());
        dto.setDesc(item.getDesc());
        if (StringUtils.equals(dto.getMinPrice(), dto.getMaxPrice())) {
            dto.setMaxPrice(null);
        }
        dto.setAttributeList(toItemAttributeVOList(item.getAttributeList()));
        dto.setSkuList(toItemSkuVOList(item.getSkuList(), item.getAttributeKeyList()));
        return dto;
    }

    default List<ItemAttributeDTO> toItemAttributeVOList(List<Map<String, List<Object>>> list) {
        if (null == list) {
            return null;
        }
        List<ItemAttributeDTO> result = new ArrayList<>();
        for (Map<String, List<Object>> map : list) {
            ItemAttributeDTO dto = toItemAttributeDTO(map);
            result.add(dto);
        }
        return result;
    }

    default ItemAttributeDTO toItemAttributeDTO(Map<String, List<Object>> map) {
        ItemAttributeDTO dto = new ItemAttributeDTO();
        String attrKey = map.keySet().stream().findFirst().get();
        dto.setName(attrKey);
        List<Object> valueList = map.get(attrKey);
        dto.setOptions(toItemAttributeOptionVOList(attrKey, valueList));
        return dto;
    }

    default List<ItemAttributeOptionDTO> toItemAttributeOptionVOList(String key, List<Object> valueList) {
        if (null == valueList) {
            return null;
        }
        List<ItemAttributeOptionDTO> result = new ArrayList<>();
        for (Object value : valueList) {
            ItemAttributeOptionDTO dto = toItemAttributeOptionVO(key, value);
            result.add(dto);
        }
        return result;
    }

    default ItemAttributeOptionDTO toItemAttributeOptionVO(String key, Object value) {
        ItemAttributeOptionDTO dto = new ItemAttributeOptionDTO();
        dto.setKey(Item.getOptionKey(key,value));
        dto.setValue((String)value);
        return dto;
    }

    default List<ItemSkuDTO> toItemSkuVOList(List<ItemSku> skuList, List<String> attributeKeyList) {
        if (null == skuList) {
            return null;
        }
        List<ItemSkuDTO> result = new ArrayList<>();
        for (ItemSku itemSku : skuList) {
            result.add(toItemSkuDTO(itemSku, attributeKeyList));
        }
        return result;
    }

    default ItemSkuDTO toItemSkuDTO(ItemSku sku, List<String> attributeKeyList) {
        if (null == sku) {
            return null;
        }
        ItemSkuDTO dto = new ItemSkuDTO();
        dto.setImage(sku.getImage());
        dto.setOptionValues(sku.getOptionValues(attributeKeyList));
        dto.setPrice(sku.getStrPrice());
        return dto;
    }

}
