package com.qiuwww.demo.springbootdemo.common.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

// 辅助类 MiscUtil，Result
// 直接返回bindingResult过于复杂，使用MiscUtil.getValidateError简化校验结果
public class MiscUtil {
  static public Result getValidateError(BindingResult bindingResult) {

    if (bindingResult.hasErrors() == false)
      return null;

    Map<String, String> fieldErrors = new HashMap<String, String>();

    for (FieldError error : bindingResult.getFieldErrors()) {
      fieldErrors.put(error.getField(), error.getCode() + "|" + error.getDefaultMessage());
    }

    Result ret = new Result(422, "输入错误"); // rfc4918 - 11.2. 422: Unprocessable Entity
    ret.putData("fieldErrors", fieldErrors);

    return ret;
  }
}
