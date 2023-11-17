package com.silky.pocketbook.controller;

import cn.hutool.core.date.DateUtil;
import com.silky.pocketbook.POJO.Pocket;
import com.silky.pocketbook.common.Response;
import com.silky.pocketbook.service.PocketService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PocketController {
    @Autowired
    PocketService pocketService;

    @GetMapping("/pocket/getall/{id}")
    public Response selectByUserId(@PathVariable("id") Integer userId){
        List<Pocket> pockets = pocketService.selectByUserId(userId);
        System.out.println(pockets);
        return Response.success("succees get all", pockets);
    }

    @PostMapping("/pocket/add")
    public Response addPocket(@RequestBody Pocket addPocket) {
        int success = pocketService.addPocket(addPocket);
        if(success == 1) {
            return Response.success("添加成功");
        }
        else {
            return Response.fatal("添加失败，请重新再试");
        }
    }

    @DeleteMapping("/pocket/delete/{id}")
    public Response deletePocket(@PathVariable("id") Integer id){
        int success = pocketService.deletPocket(id);
        if(success == 1) {
            return Response.success("删除成功");
        }
        else {
            return Response.fatal("删除失败，请重新再试");
        }
    }
}
