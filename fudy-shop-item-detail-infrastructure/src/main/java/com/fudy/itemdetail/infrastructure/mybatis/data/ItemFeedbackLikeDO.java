package com.fudy.itemdetail.infrastructure.mybatis.data;

import lombok.Data;

@Data
public class ItemFeedbackLikeDO extends CommonDO {
    //商品id
    private Long itemId;
    //用户id
    private Long userId;
    //商品评价id
    private Long itemFeedbackId;
}
