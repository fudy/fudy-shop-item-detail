package com.fudy.itemdetail.infrastructure.mybatis.mapper;

import com.fudy.itemdetail.infrastructure.mybatis.data.ItemFeedbackDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemFeedbackMapper {
    String NO_ID_COLUMNS = "created_time,modified_time,item_id,user_id,comment,spec,star,image_list,like_num,username,avatar";
    String COLUMNS = "id," + NO_ID_COLUMNS;

    @Select("select " + COLUMNS + " from item_feedback where item_id = #{itemId}")
    List<ItemFeedbackDO> selectList(@Param("itemId") Long itemId);
}
