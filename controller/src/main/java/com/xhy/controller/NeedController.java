package com.xhy.controller;

import com.github.pagehelper.PageInfo;
import com.xhy.domain.Need;
import com.xhy.domain.Role;
import com.xhy.domain.User;
import com.xhy.service.NeedService;
import com.xhy.service.UserServise;
import com.xhy.vo.NeedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/webneed")
public class NeedController {

    @Autowired
    NeedService needService;

    @Autowired
    UserServise userServise;

//    @RequiresPermissions("needer:listNeed")
    @RequestMapping(value = "/findAllNeed",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> findAllNeed( NeedVO needVO)
    {
        Map<String,Object> map = new HashMap<String,Object>();
        int count=0;
        NeedVO needVO1 = new NeedVO();
        needVO1.setLimit(0);
        needVO1.setPage(0);
        needVO1.setSearchName(needVO.getSearchName());
        needVO1.setSelectName(needVO.getSelectName());
        List<Need> needList1 = needService.findAllNeed(needVO1);
        for(Need j : needList1){
            count+=1;
        }
        map.put("count",count);
        List<Need> needList2 = needService.findAllNeed(needVO);
        PageInfo pageInfo2 = new PageInfo(needList2);
        int pageNum = pageInfo2.getPageNum();
        map.put("list",needList2);
        map.put("page",pageNum);
        return map;
    }

//    @RequiresPermissions("needer:updateNeed")
    @RequestMapping(value = "/updateNeed",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> updateNeed(@RequestBody Need need){
        Map<String,Object> map = new HashMap<String,Object>();
        if (need != null) {
            Integer integer = needService.updateNeed(need);
            if (integer != null) {
                map.put("code", "101");
                return map;
            } else {
                map.put("code", "102");
                return map;
            }
        } else {
            map.put("code", "103");
            return map;
        }
    }

//    @RequestMapping(value = "/findNeedById",method = RequestMethod.GET)
//    public @ResponseBody Map<String,Object> findNeedById(int needid){
//        Map<String,Object> map = new HashMap<String,Object>();
//        Need need1 = needService.findByNeedid(needid);
//        PageInfo pageInfo1 = new PageInfo(need1);
//        int count = pageInfo1.getSize();
//        map.put("count",count);
//       Need need2 = needService.findByNeedid(needid);
//        PageInfo pageInfo2 = new PageInfo(need2);
//        int pageNum = pageInfo2.getPageNum();
//        map.put("list",need2);
//        map.put("page",pageNum);
//        return map;
//    }

//    @RequiresPermissions("needer:addNeed")
    @RequestMapping(value = "/addNeed",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> addNeed(@RequestBody Need need){
        Map<String,Object> map = new HashMap<String,Object>();
        if (need != null) {
            Integer integer = needService.addNeed(need);
            if (integer != null) {
                map.put("code", "101");
                return map;
            } else {
                map.put("code", "102");
                return map;
            }
        } else {
            map.put("code", "102");
            return map;
        }
    }

//    @RequiresPermissions("needer:deleteNeed")
    @RequestMapping(value = "/deleteNeed",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> deleteNeed(int needid){
        Map<String,Object> map = new HashMap<String,Object>();
            Integer integer = needService.deleteNeed(needid);
            if (integer != null) {
                map.put("code", "101");
                return map;
            } else {
                map.put("code", "102");
                return map;
            }
    }



}
