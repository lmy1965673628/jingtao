package com.ly.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
@JsonIgnoreProperties(ignoreUnknown=true)
@TableName("tb_cart")
@Data
@Accessors(chain = true)
public class Cart extends BasePojo{
    /**
     * 购物车ID
     */
    private Long id;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 商品Id
     */
    private Long itemId;
    /**
     * 商品标题
     */
    private String itemTitle;
    /**
     * 商品图片
     */
    private String itemImage;
    /**
     * 商品价格
     */
    private Long itemPrice;
    /**
     * 商品数量
     */
    private Integer num;
}

