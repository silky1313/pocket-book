package com.silky.pocketbook.service;

import cn.hutool.core.date.DateUtil;
import com.silky.pocketbook.POJO.Pocket;
import com.silky.pocketbook.mapper.PocketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PocketService {
    @Autowired
    PocketMapper pocketMapper;

    public List<Pocket> selectByUserId(Integer userId){
        return pocketMapper.selectByUserId(userId);
    }

    public int addPocket(Pocket pocket) {
        //应该允许用户自已设置时间
        if(pocket.getRecordDay() == null) {
            String currentTime = DateUtil.now();
            pocket.setRecordDay(DateUtil.parse(currentTime));
        }
        return pocketMapper.addPocket(pocket);
    }

    public int deletPocket(Integer id) {
        return pocketMapper.deleteByPrimaryKey(id);
    }

    public int updatePocket(Pocket updatePocket) {
        return pocketMapper.updateByPrimaryKeySelective(updatePocket);
    }
}
