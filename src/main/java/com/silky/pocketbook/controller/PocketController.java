package com.silky.pocketbook.controller;

import cn.hutool.core.date.DateUtil;
import com.silky.pocketbook.POJO.Pocket;
import com.silky.pocketbook.annotation.UserLoginToken;
import com.silky.pocketbook.common.Response;
import com.silky.pocketbook.service.PocketService;
import com.silky.pocketbook.util.Controller;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@UserLoginToken
public class PocketController {
    @Autowired
    PocketService pocketService;

    @UserLoginToken
    @GetMapping("/pocket/getall/{id}")
    public Response selectByUserId(@PathVariable("id") Integer userId){
        List<Pocket> pockets = pocketService.selectByUserId(userId);
        System.out.println(pockets);
        return Response.success("succees get all", pockets);
    }

    @PostMapping("/pocket/add")
    public Response addPocket(@RequestBody Pocket addPocket) {
        int success = pocketService.addPocket(addPocket);
        return Controller.result(success, "添加成功", "添加失败");
    }

    @PostMapping("/pocket/update")
    public Response updatePocket(@RequestBody Pocket updatePocket) {
        int success = pocketService.updatePocket(updatePocket);
        return Controller.result(success, "更新成功", "更新失败");
    }

    @DeleteMapping("/pocket/delete/{id}")
    public Response deletePocket(@PathVariable("id") Integer id){
        int success = pocketService.deletPocket(id);
        return Controller.result(success, "删除成功", "删除失败，请重新再试");
    }
}
