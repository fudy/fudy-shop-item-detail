package com.fudy.itemdetail.application.assembler;

import com.fudy.itemdetail.domain.Item;
import com.fudy.itemdetail.domain.ItemSku;
import com.fudy.itemdetail.application.vo.ItemAttributeOptionVO;
import com.fudy.itemdetail.application.vo.ItemAttributeVO;
import com.fudy.itemdetail.application.vo.ItemSkuVO;
import com.fudy.itemdetail.application.vo.ItemVO;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface ItemAssembler {

    default ItemVO toItemVO(Item item) {
        ItemVO vo = new ItemVO();
        vo.setTitle(item.getTitle());
        vo.setImageList(item.getImageList());
        vo.setMainImage(item.getMainImage());
        vo.setSalesVolume(item.getSales()+"");
        vo.setMinPrice(item.getMinPriceStr());
        vo.setMaxPrice(item.getMaxPriceStr());
        vo.setDesc(item.getDesc());
        if (StringUtils.equals(vo.getMinPrice(), vo.getMaxPrice())) {
            vo.setMaxPrice(null);
        }
        vo.setAttributeList(toItemAttributeVOList(item.getAttributeList()));
        vo.setSkuList(toItemSkuVOList(item.getSkuList(), item.getAttributeKeyList()));
        return vo;
    }

    default List<ItemAttributeVO> toItemAttributeVOList(List<Map<String, List<Object>>> list) {
        if (null == list) {
            return null;
        }
        List<ItemAttributeVO> result = new ArrayList<>();
        for (Map<String, List<Object>> map : list) {
            ItemAttributeVO vo = toItemAttributeVO(map);
            result.add(vo);
        }
        return result;
    }

    default ItemAttributeVO toItemAttributeVO(Map<String, List<Object>> map) {
        ItemAttributeVO vo = new ItemAttributeVO();
        String attrKey = map.keySet().stream().findFirst().get();
        vo.setName(attrKey);
        List<Object> valueList = map.get(attrKey);
        vo.setOptions(toItemAttributeOptionVOList(attrKey, valueList));
        return vo;
    }

    default List<ItemAttributeOptionVO> toItemAttributeOptionVOList(String key, List<Object> valueList) {
        if (null == valueList) {
            return null;
        }
        List<ItemAttributeOptionVO> result = new ArrayList<>();
        for (Object value : valueList) {
            ItemAttributeOptionVO vo = toItemAttributeOptionVO(key, value);
            result.add(vo);
        }
        return result;
    }

    default ItemAttributeOptionVO toItemAttributeOptionVO(String key, Object value) {
        ItemAttributeOptionVO vo = new ItemAttributeOptionVO();
        vo.setKey(Item.getOptionKey(key,value));
        vo.setValue((String)value);
        return vo;
    }

    default List<ItemSkuVO> toItemSkuVOList(List<ItemSku> skuList, List<String> attributeKeyList) {
        if (null == skuList) {
            return null;
        }
        List<ItemSkuVO> result = new ArrayList<>();
        for (ItemSku itemSku : skuList) {
            result.add(toItemSkuVO(itemSku, attributeKeyList));
        }
        return result;
    }

    default ItemSkuVO toItemSkuVO(ItemSku sku, List<String> attributeKeyList) {
        if (null == sku) {
            return null;
        }
        ItemSkuVO vo = new ItemSkuVO();
        vo.setImage(sku.getImage());
        vo.setOptionValues(sku.getOptionValues(attributeKeyList));
        vo.setPrice(sku.getStrPrice());
        return vo;
    }

}
