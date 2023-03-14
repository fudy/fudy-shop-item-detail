package com.fudy.itemdetail.interfaces.web.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemAttributeOptionVO implements Serializable {
    private static final long serialVersionUID = -6907453526686574553L;
    private String key;
    private String value;
}
