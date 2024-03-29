package com.xhy.controller;

import com.github.pagehelper.PageInfo;
import com.xhy.domain.Permission;
import com.xhy.domain.Role;
import com.xhy.service.PermissionService;
import com.xhy.vo.PermissionVO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Perm")
public class PermissionController {

    @Autowired
    PermissionService permissionService;


    @RequiresPermissions("admin:listPerm")
    @GetMapping("/listPerm")
    public @ResponseBody
    Map<String,Object> ListPerm(PermissionVO permissionVO){
        Map<String, Object> map = new HashMap<String, Object>();
        List<Permission> list = permissionService.findAllPermission(permissionVO);
        PageInfo pageInfo = new PageInfo(list);
        int pageNum = pageInfo.getPageNum();
        long total = pageInfo.getTotal();
        map.put("page", pageNum);
        map.put("list", list);
        map.put("count", total);
        return map;
    }

    @RequiresPermissions("admin:addPerm")
    @PostMapping("/addPerm")
    public @ResponseBody Map<String,Object> addPerm(@RequestBody Permission permission){
        Map<String,Object> map = new HashMap<>();
        Integer add = permissionService.addPermission(permission);
        if(add!=0){
            map.put("code","101");
        }else {
            map.put("code","102");
        }
        return map;
    }

    @RequiresPermissions("admin:updatePerm")
    @PostMapping("/updatePerm")
    public @ResponseBody Map<String,Object> updatePerm(@RequestBody Permission permission){
        Map<String,Object> map = new HashMap<>();
        Integer update = permissionService.updatePermission(permission);
        if(update!=0){
            map.put("code","101");
        }else {
            map.put("code","102");
        }
        return map;
    }

    @RequiresPermissions("admin:deletePerm")
    @GetMapping("/deletePerm")
    public @ResponseBody Map<String,Object> deletePerm(int id){
        Map<String,Object> map = new HashMap<>();
        Integer delete = permissionService.deletePermission(id);
        if(delete!=0){
            map.put("code","101");
        }else {
            map.put("code","102");
        }
        return map;
    }


    /**
     * 修改项目权限
     * */

    @RequiresPermissions("admin:updatePermissionStatus")
    @PostMapping("/updatePermissionStatus")
    @ResponseBody
    public  Map<String,Object> updatePermissionStatus(@RequestBody Permission permission){
     Map<String,Object> map = new HashMap<>();
        Integer status = permissionService.updatePermissionStatus(permission);
        if(status!=0){
            map.put("code","101");
        }else {
            map.put("code","102");
        }
        return map;
    }

}
