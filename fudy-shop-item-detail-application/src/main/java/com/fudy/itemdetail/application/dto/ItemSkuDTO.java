package com.fudy.itemdetail.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ItemSkuDTO implements Serializable {
    private static final long serialVersionUID = -967908029965999482L;
    private List<String> optionValues;
    private String price;
    private String image;
}
