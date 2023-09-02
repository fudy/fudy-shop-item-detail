package com.fudy.itemdetail.infrastructure.mybatis.convertor;

import com.fudy.itemdetail.domain.ItemFeedbackLike;
import com.fudy.itemdetail.infrastructure.mybatis.data.ItemFeedbackLikeDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemFeedbackLikeConvertor {
    ItemFeedbackLikeDO toItemFeedbackLikeDO(ItemFeedbackLike like);
}
