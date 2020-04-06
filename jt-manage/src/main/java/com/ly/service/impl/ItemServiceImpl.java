package com.ly.service.impl;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.ly.mapper.ItemMapper;
import com.ly.pojo.Item;
import com.ly.service.ItemService;
import com.ly.vo.EasyUITable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
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

    @Override
    public void saveItem(Item item) {
        item.setStatus(1)    //表示正常
                .setCreated(new Date())
                .setUpdated(item.getCreated());
        itemMapper.insert(item);

    }
    @Transactional
    @Override
    public void updateItem(Item item) {

        item.setUpdated(new Date());
        itemMapper.updateById(item);
    }
    /**
     * 批量更新
     */
    @Override
    public void upateStatus(Long[] ids, int status) {
        Item item = new Item();
        item.setStatus(status)
                .setUpdated(new Date());
        //sql: update tb_item set status=2 where id in (1001,1002)
        UpdateWrapper<Item> updateWrapper = new UpdateWrapper<Item>();
        List<Long> idList = Arrays.asList(ids);
        updateWrapper.in("id", idList);
        itemMapper.update(item, updateWrapper);
    }
}
