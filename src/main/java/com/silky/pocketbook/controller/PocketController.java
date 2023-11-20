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

    @GetMapping("/pocket/{id}")
    public Response selectByUserId(@PathVariable("id") Integer userId){
        List<Pocket> pockets = pocketService.selectByUserId(userId);
        return Controller.find(pockets);
    }

    @PostMapping("/pocket")
    public Response addPocket(@RequestBody Pocket addPocket) {
        int success = pocketService.addPocket(addPocket);
        return Controller.post(success);
    }

    @PutMapping("/pocket")
    public Response updatePocket(@RequestBody Pocket updatePocket) {
        int success = pocketService.updatePocket(updatePocket);
        return Controller.put(success);
    }

    @DeleteMapping("/pocket/{id}")
    public Response deletePocket(@PathVariable("id") Integer id){
        int success = pocketService.deletPocket(id);
        return Controller.delete(success);
    }
}
