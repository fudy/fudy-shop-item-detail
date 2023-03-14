package com.fudy.itemdetail.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ItemSku {
    private Map<String, Object> spec;
    private BigDecimal price;
    private String image;

    public String getStrPrice() {
        return null == price ? null : price.toString();
    }

    public List<String> getOptionValues(List<String> attributeKeyList) {
        if (null == attributeKeyList) {
            return null;
        }
        List<String> result = new ArrayList<>();
        for (String key : attributeKeyList) {
            result.add(Item.getOptionKey(key ,spec.get(key)));
        }
        return result;
    }

}
