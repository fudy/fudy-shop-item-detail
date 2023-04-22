package com.fudy.itemdetail.application.assembler;

import com.fudy.itemdetail.domain.Image;
import com.fudy.itemdetail.domain.ItemFeedback;
import com.fudy.itemdetail.interfaces.web.vo.ItemFeedbackVO;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemFeedbackAssembler {
    ItemFeedbackVO toItemFeedbackVO(ItemFeedback itemFeedback);
    List<ItemFeedbackVO> toItemFeedbackVOList(List<ItemFeedback> itemFeedbackList);

    default List<String> toImageListStr(List<Image> imageList) {
        if (null == imageList) {
            return null;
        }
        List<String> list = new ArrayList<>();
        for (Image image : imageList) {
            list.add(image.getUrl());
        }
        return list;
    }

}
