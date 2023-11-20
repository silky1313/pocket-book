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
        return Controller.find(kindes);
    }

    @DeleteMapping("/kind/{id}")
    public Response deleteOne(@PathVariable Integer id) {
        int success = kindeService.deleteOne(id);
        return Controller.delete(success);
    }

    @PostMapping("/kind")
    public Response postOne(@RequestBody Kind addKind) {
        int success = kindeService.postOne(addKind);
        return Controller.post(success);
    }

    @PutMapping("/kind")
    public Response putOne(@RequestBody Kind addKind) {
        int success = kindeService.putOne(addKind);
        return Controller.post(success);
    }
}
