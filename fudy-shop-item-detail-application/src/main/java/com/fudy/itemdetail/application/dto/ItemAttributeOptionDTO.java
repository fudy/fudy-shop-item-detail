package com.fudy.itemdetail.application.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemAttributeOptionDTO implements Serializable {
    private static final long serialVersionUID = -6907453526686574553L;
    private String key;
    private String value;
}
