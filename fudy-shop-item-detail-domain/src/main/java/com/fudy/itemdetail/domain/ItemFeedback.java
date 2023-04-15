package com.fudy.itemdetail.domain;

import lombok.Data;

import java.util.List;

@Data
public class ItemFeedback extends Entity {
    //商品id
    private Long itemId;
    //用户id
    private Long userId;
    //用户名
    private String username;
    //用户头像
    private String avatar;
    //评论
    private String content;
    //商品规格
    private String spec;
    //评价星级
    private int star;
    //商品图片列表
    private List<Image> imageList;
    //点赞数
    private int likeNum;

}
