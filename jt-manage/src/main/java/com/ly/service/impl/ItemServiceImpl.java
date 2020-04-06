package com.ly.service.impl;


import com.ly.mapper.ItemMapper;
import com.ly.pojo.Item;
import com.ly.service.ItemService;
import com.ly.vo.EasyUITable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;

    @Override
    public EasyUITable findItemByPage(Integer page, Integer rows) {

        int total = itemMapper.selectCount(null);    //获取商品信息记录总数

        /**
         * 将最近添加的数据最先展现 按照updated排序
         */
        int start = (page - 1) * rows;
        List<Item> itemList = itemMapper.findItemByPage(start, rows);
        return new EasyUITable(total, itemList);
    }
}
