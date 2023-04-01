package com.fudy.itemdetail.application.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ItemAttributeVO implements Serializable {
    private static final long serialVersionUID = -7434075471263039996L;

    private String name;
    private List<ItemAttributeOptionVO> options;

}
