package com.fudy.itemdetail.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ItemDTO implements Serializable {
    private static final long serialVersionUID = -5333111734797807187L;
    private String title;
    private String salesVolume;
    private String mainImage;
    private List<String> imageList;
    private String minPrice;
    private String maxPrice;
    private List<ItemAttributeDTO> attributeList;
    private List<ItemSkuDTO> skuList;
    private String desc;

}
