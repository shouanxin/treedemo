package com.dao;

import com.bean.Catalogue;

import java.util.List;

public interface ICataDao {
    /**
     * 获取表中所有的目录数据
     * @return
     */
    List<Catalogue> getAllCata();

    /**
     * 根据id删除表中数据（批量操作）
     * @param ids
     * @return
     */
    int deleteCata(List<Integer> ids);
}
