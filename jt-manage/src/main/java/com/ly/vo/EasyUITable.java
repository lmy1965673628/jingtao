package com.ly.vo;
/**
 * 为了EasyUI数据回显 封装VO对象.
 * @author tarena
 *
 */

import com.ly.pojo.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EasyUITable {
	/**
	 * 商品记录总数
	 */
	private Integer total;
	/**
	 * 利用分页算法查询当前页数据
	 */
	private List<Item> rows;
	
}
