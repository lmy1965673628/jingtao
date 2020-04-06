package com.ly.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EasyUITree {
	/**
	 * 节点Id
	 */
	private Long id;
	/**
	 * 节点名称
	 */
	private String text;
	/**
	 * 节点开关 open/closed
	 */
	private String state;
}
