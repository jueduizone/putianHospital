package com.jamie.controller;

import com.jamie.model.PuTian;
import com.jamie.service.PuTianServie;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JamieXu on 16/5/11.
 */
@RestController
@RequestMapping("putian")
//@ConfigurationProperties(prefix="production")
public class PutianController {
    @Resource
    PuTianServie putianService;

    /**
     * 根据名称模糊查询
     * @param name
     * @return
     */
    @RequestMapping(value="/hospitals/{name}",method = RequestMethod.GET)
    public String getInfoLikeName(@PathVariable("name") String name){
        Map<String,Object> returnMap = new HashMap<String,Object>();
        List<PuTian> puTian = putianService.getInfoByName(name,"1");
        if(puTian.size()>0){
            returnMap.put("code","200");
            returnMap.put("putian",puTian);
        }else{
            returnMap.put("code","400");
            returnMap.put("message", "抱歉,没有相应的信息!");
        }
        //将对象转换为json字符串返回
        return JSONObject.valueToString(returnMap);
    }

    /**
     * 根据ID查询详细信息
     * @param id
     * @return
     */
    @RequestMapping(value="/hospital/{id}",method = RequestMethod.GET)
    public String getInfoById(@PathVariable("id") int id){
        Map<String,Object> returnMap = new HashMap<String,Object>();
        PuTian puTian = putianService.getInfoById(id, "1");
        if(null != puTian){
            returnMap.put("code","200");
            returnMap.put("putian",puTian);
        }else{
            returnMap.put("code","400");
            returnMap.put("message", "抱歉,没有相应的信息!");
        }
        //将对象转换为json字符串返回
        return JSONObject.valueToString(returnMap);
    }

    /**
     * 新增信息
     * @param puTian
     * @return
     */
    @RequestMapping(value = "/hospital",method = RequestMethod.POST)
    public String addPuTianInfo(PuTian puTian){
        Map<String,Object> returnMap = new HashMap<String,Object>();
        boolean success = putianService.addPuTianInfo(puTian);
        if(success){
            returnMap.put("code","200");
            returnMap.put("message", "恭喜,增加成功,请等待审核!");
        }else{
            returnMap.put("code","400");
            returnMap.put("message", "抱歉,增加失败,请稍后重试!");
        }
        //将对象转换为json字符串返回
        return JSONObject.valueToString(returnMap);
    }
}
