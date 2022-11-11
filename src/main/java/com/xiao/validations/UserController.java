package com.xiao.validations;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @PostMapping("/add")
    public String save(@Valid @RequestBody ProductRequest product) {
        return "ok";
    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable int id) throws Exception{
        if(id == 5) {
            return "find";
        }
        throw  new UserNotFindException("用户没有找到！");
    }
}
