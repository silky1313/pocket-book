package com.silky.pocketbook.mapper;

import com.silky.pocketbook.POJO.Kind;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KindMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kind record);

    int insertSelective(Kind record);

    Kind selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kind record);

    int updateByPrimaryKey(Kind record);

    int addOne(@Param("addKind") Kind addKind);

    List<Kind> getAll();
}