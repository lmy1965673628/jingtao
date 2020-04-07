package com.ly.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ly.pojo.ItemDesc;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ItemDescMapper extends BaseMapper<ItemDesc> {
    void deleteItems(Long[] ids);
}
