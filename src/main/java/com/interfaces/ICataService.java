package com.interfaces;

import com.bean.Catalogue;

import java.util.List;

public interface ICataService {
    /**
     * 获取表中所有的目录数据
     * @return
     */
    List<Catalogue> getAllCata();

    /**
     * 根据id删除表中数据（批量操作）
     * @param id
     * @return
     */
    int deleteCata(Integer id);
}
