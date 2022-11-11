package com.xiao.validations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotBlank(message = "邮箱地址不能为空")
    private String email;
}
