package com.silky.pocketbook.controller;

import com.silky.pocketbook.POJO.Kind;
import com.silky.pocketbook.annotation.UserLoginToken;
import com.silky.pocketbook.common.Response;
import com.silky.pocketbook.service.KindeService;
import com.silky.pocketbook.util.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@UserLoginToken
public class KindController {

    @Autowired
    KindeService kindeService;
    @GetMapping("/kind")
    public Response getAll() {
        List<Kind> kindes = kindeService.getAll();
        return Response.success("查询成功", kindes);
    }

    @DeleteMapping("/kind/{id}")
    public Response deleteOne(@PathVariable Integer id) {
        int success = kindeService.deleteOne(id);
        return Controller.result(success, "删除成功", "删除失败");
    }

    @PostMapping("/kind")
    public Response addOne(@RequestBody Kind addKind) {
        int success = kindeService.addOne(addKind);
        return Controller.result(success, "添加成功", "添加失败");
    }
}
