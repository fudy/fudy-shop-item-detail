package com.fudy.itemdetail.application.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ItemAttributeDTO implements Serializable {
    private static final long serialVersionUID = -7434075471263039996L;

    private String name;
    private List<ItemAttributeOptionDTO> options;

}
