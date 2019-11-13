package com.self.pickup.common.exception;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.self.pickup.common.dto.BaseResult;
import com.self.pickup.common.utils.MapperUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        String message = e.getMessage();
        if (message == null || message.equals("")) {
            message = "内部出错";
        }
        try {
            return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                    new BaseResult.Error("Exception", message))));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "Exception";
    }
}
