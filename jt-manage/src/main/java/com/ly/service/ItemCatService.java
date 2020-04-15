package com.ly.service;

import com.ly.vo.EasyUITree;

import java.util.List;

public interface ItemCatService {

	String findItemCatNameById(Long itemCatId);
	List<EasyUITree> findEasyUITreeList(Long parentId);

    List<EasyUITree> findEasyUITreeCache(Long parentId);
}
