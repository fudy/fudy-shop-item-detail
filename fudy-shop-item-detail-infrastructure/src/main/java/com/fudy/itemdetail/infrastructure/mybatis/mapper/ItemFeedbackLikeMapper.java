package com.fudy.itemdetail.infrastructure.mybatis.mapper;

import com.fudy.itemdetail.infrastructure.mybatis.data.ItemFeedbackLikeDO;
import org.apache.ibatis.annotations.*;

public interface ItemFeedbackLikeMapper {
    String NO_ID_COLUMNS = "created_time,modified_time,item_id,user_id,item_feedback_id";
    String COLUMNS = "id," + NO_ID_COLUMNS;

    @Insert("insert into item_feedback_like("+NO_ID_COLUMNS+") " +
            "values(now(), now(), #{itemId}, #{userId}, #{itemFeedbackId})")
    @Options(useGeneratedKeys=true, keyProperty = "id")
    void insert(ItemFeedbackLikeDO likeDO);

    @Select("select count(1) from item_feedback_like where item_feedback_id = #{feedbackId} and user_id=#{userId}")
    int count(@Param("feedbackId") Long feedbackId, @Param("userId") Long userId);

    @Delete("delete from item_feedback_like where item_feedback_id = #{feedbackId} and user_id=#{userId}")
    void delete(@Param("feedbackId") Long feedbackId, @Param("userId") Long userId);
}
