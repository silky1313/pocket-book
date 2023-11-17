package com.silky.pocketbook.mapper;

import com.silky.pocketbook.POJO.Pocket;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PocketMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pocket record);

    int insertSelective(Pocket record);

    Pocket selectByPrimaryKey(Integer id);

    List<Pocket> selectByUserId(@Param("userId") Integer userId);
    int updateByPrimaryKeySelective(Pocket record);

    int updateByPrimaryKey(Pocket record);

    int addPocket(@Param("pocket") Pocket pocket);
}