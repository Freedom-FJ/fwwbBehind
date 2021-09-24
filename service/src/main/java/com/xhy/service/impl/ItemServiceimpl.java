package com.xhy.service.impl;

import com.github.pagehelper.PageHelper;
import com.xhy.Mapper.ItemMapper;
import com.xhy.domain.Item;
import com.xhy.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceimpl implements ItemService {

    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<Item> findAllItem(int startNum,int pageSize,String itemtype) {

        PageHelper.startPage(startNum,pageSize);
        return itemMapper.findAll(itemtype);
    }

    @Override
    public Integer addItem(Item item) {
      return   itemMapper.addItem(item);
    }

    @Override
    public Integer updateItem(Item item) {
        return itemMapper.updataItem(item);
    }

    @Override
    public Integer deleteItem(String itemid) {
        return  itemMapper.deleteItem(itemid);
    }

    @Override
    public Item findItemById(int startNum,int pageSize,String itemid) {
        PageHelper.startPage(startNum,pageSize);
        return itemMapper.findbyid(itemid);
    }
}
