package com.silky.pocketbook.service;

import com.silky.pocketbook.POJO.Kind;
import com.silky.pocketbook.mapper.KindMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KindeService {
    @Autowired
    KindMapper kindMapper;

    public List<Kind> getAll() {
        return kindMapper.getAll();
    }

    public int deleteOne(Integer id) {
        return kindMapper.deleteByPrimaryKey(id);
    }

    public int postOne(Kind addKind) {
        return kindMapper.addOne(addKind);
    }

    public int putOne(Kind addKind) {
        return kindMapper.updateByPrimaryKeySelective(addKind);
    }
}
