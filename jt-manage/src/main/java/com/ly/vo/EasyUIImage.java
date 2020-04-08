package com.ly.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class EasyUIImage {
	/**
	 * 1表示文件上传失败
	 */
	private Integer error=0;
	/**
	 * 图片访问地址
	 */
	private String  url;
}
