package com.self.pickup.provider.family.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.self.pickup.common.dto.BaseResult;
import com.self.pickup.common.utils.MapperUtils;
import com.self.pickup.provider.family.service.GetParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "exposure")
public class FamilyController {

    @Autowired
    private GetParentService getParentService;

    /**
     * 根据家庭ID获取家长列表
     * @param jsonParam
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getFamilyParent", method = RequestMethod.POST)
    public String getFamilyParent(@RequestBody JSONObject jsonParam){
        String account = jsonParam.getString("account");



        // 请求未携带familyId
        if(familyId == null){
            // 错误信息返回前端
            try {
                return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                        new BaseResult.Error("family", "本地缓存出错"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 正常处理
        else {
            BaseResult baseResult = getParentService.getFamilyParent(familyId);
            // 返回baseResult.result属于ok状态，家长列表返回前端
            if(baseResult.getResult() == "ok"){
                try {
                    return MapperUtils.obj2json(baseResult);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                // 错误信息返回前端
                try {
                    return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                            baseResult.getErrors())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return "Exception!";
    }
}
