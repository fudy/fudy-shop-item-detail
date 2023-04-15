package com.fudy.itemdetail.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Entity {
    private Long id;
    private Date createdTime;
    private Date modifiedTime;
}
