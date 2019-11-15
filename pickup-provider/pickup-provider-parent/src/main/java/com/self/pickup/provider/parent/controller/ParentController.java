package com.self.pickup.provider.parent.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.self.pickup.common.dto.BaseResult;
import com.self.pickup.common.utils.MapperUtils;
import com.self.pickup.provider.parent.domain.Parent;
import com.self.pickup.provider.parent.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "exposure")
public class ParentController {
    @Autowired
    private ParentService parentService;

    /**
     * 获取家长个人信息
     * @param jsonParam
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "getPersonInfo", method = RequestMethod.POST)
    public String getPersonInfo(@RequestBody JSONObject jsonParam){
        String account = jsonParam.getString("account");

        Parent parent = null;
        // 从数据库中取出个人信息
        parent = parentService.getInfoByAccount(account);
        if(parent == null){
            try {
                // 错误信息返回前端
                return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                        new BaseResult.Error("parent", "账号不存在"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                // 数据返回前端
                return MapperUtils.obj2json(BaseResult.ok(parent)); // 返回给前端
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "Exception!";
    }

    /**
     * 添加家长
     * @param jsonParam
     * @return String
     */
    @ResponseBody
    @RequestMapping(value = "addParent", method = RequestMethod.POST)
    public String addParent(@RequestBody JSONObject jsonParam){
        String parentName = jsonParam.getString("parentName");
        boolean parentGender = jsonParam.getBoolean("parentGender");
        String parentPhotoUrl = jsonParam.getString("parentPhotoUrl");
        String address = jsonParam.getString("address");
        Integer relation = jsonParam.getInteger("relation");
        String familyId = jsonParam.getString("familyId");

        Parent parent = new Parent("", parentName, parentGender,
                address, relation, familyId, parentPhotoUrl);

        int success = parentService.add(parent);
        //添加成功
        if(success == 1){
            try {
                return MapperUtils.obj2json(BaseResult.ok());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 出错处理
        else {
            try {
                return MapperUtils.obj2json(BaseResult.notOk(Lists.newArrayList(
                        new BaseResult.Error("parent", "网络错误"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "Exception!";
    }

}
