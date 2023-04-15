package com.fudy.itemdetail.infrastructure.mybatis.convertor;

import com.fudy.itemdetail.domain.Image;
import com.fudy.itemdetail.domain.ItemFeedback;
import com.fudy.itemdetail.infrastructure.mybatis.data.ItemFeedbackDO;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemFeedbackConvertor {

    ItemFeedback toItemFeedback(ItemFeedbackDO itemFeedbackDO);

    List<ItemFeedback> toItemFeedbackList(List<ItemFeedbackDO> itemFeedbackDOList);

    default List<Image> toImageList(String imageList) {
        if (null == imageList) {
            return null;
        }
        List<Image> list = new ArrayList<>();
        String[] urls = imageList.split(",");
        for (String url : urls) {
            list.add(new Image(url));
        }
        return list;
    }
}
