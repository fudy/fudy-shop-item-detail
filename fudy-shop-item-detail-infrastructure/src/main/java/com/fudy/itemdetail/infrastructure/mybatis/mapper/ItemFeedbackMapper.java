package com.fudy.itemdetail.infrastructure.mybatis.mapper;

import com.fudy.itemdetail.infrastructure.mybatis.data.ItemFeedbackDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemFeedbackMapper {
    String NO_ID_COLUMNS = "created_time,modified_time,item_id,user_id,content,spec,star,image_list,like_num,username,avatar";
    String COLUMNS = "id," + NO_ID_COLUMNS;

    @Select("select " + COLUMNS + " from item_feedback where item_id = #{itemId} limit #{offset},#{pageSize}")
    List<ItemFeedbackDO> selectList(@Param("itemId") Long itemId, @Param("offset") int offset, @Param("pageSize") int  pageSize);

    @Select("select count(1) from item_feedback where item_id = #{itemId}")
    int count(Long itemId);
}
