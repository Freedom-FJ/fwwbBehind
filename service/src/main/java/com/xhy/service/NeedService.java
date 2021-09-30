package com.xhy.service;

import com.xhy.domain.Need;
import com.xhy.vo.NeedVO;

import java.util.List;

public interface NeedService {

//    查看所有需求计划
    List<Need> findAllNeed(NeedVO needVO);

//  添加新的需求计划
    Integer addNeed(Need need);

//  修改选中的需求计划
    Integer updateNeed(Need need);

//  删除需求计划
    Integer deleteNeed(int needid);

//  根据ID查询
    Need  findByNeedid(int needid);

//    查找个人代办任务

    Need queryActNeed(Integer page,Integer limit,String username);

    Integer updateStatus(Need need);

}
