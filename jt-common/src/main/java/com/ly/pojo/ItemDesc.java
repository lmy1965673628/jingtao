package com.ly.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("tb_item_desc")
public class ItemDesc extends BasePojo{
	/**
	 * id信息与商品Id号一致,故不可设置为自增长
	 */
	@TableId
	private Long itemId;
	/**
	 * 详情内容
	 */
	private String itemDesc;
}





