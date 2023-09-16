package com.fudy.itemdetail.application.assembler;

import com.fudy.itemdetail.application.dto.ItemFeedbackDTO;
import com.fudy.itemdetail.domain.Image;
import com.fudy.itemdetail.domain.ItemFeedback;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemFeedbackAssembler {
    ItemFeedbackDTO toItemFeedbackDTO(ItemFeedback itemFeedback);
    List<ItemFeedbackDTO> toItemFeedbackDTOList(List<ItemFeedback> itemFeedbackList);

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
