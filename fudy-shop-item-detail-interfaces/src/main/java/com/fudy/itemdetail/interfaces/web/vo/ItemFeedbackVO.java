package com.fudy.itemdetail.interfaces.web.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ItemFeedbackVO implements Serializable {
    private static final long serialVersionUID = 4760676455039594801L;
    //创建时间
    private Date createdTime;
    //用户头像
    private String avatar;
    //用户名
    private String username;
    //评论
    private String content;
    //商品规格
    private String spec;
    //评价星级
    private int star;
    //点赞数
    private int likeNum;
    //商品图片列表
    private List<String> imageList;
}
