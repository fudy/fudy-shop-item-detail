package com.fudy.itemdetail.infrastructure.mybatis.data;

import lombok.Data;

@Data
public class ItemFeedbackDO extends CommonDO {
    //商品id
    private Long itemId;
    //用户id
    private Long userId;
    //评论
    private String content;
    //商品规格
    private String spec;
    //评价星级
    private int star;
    //商品图片列表
    private String imageList;
    //点赞数
    private int likeNum;
    //用户名
    private String username;
    //用户头像
    private String avatar;

}
