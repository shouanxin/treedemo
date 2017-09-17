package com.dao;

import com.bean.Catalogue;
import com.mapper.CataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "catadao")
public class CataDaoImpl implements ICataDao {

    @Autowired(required = false)
    private CataMapper cataMapper;

    public List<Catalogue> getAllCata() {
        return cataMapper.getAllCata();
    }

    public int deleteCata(List<Integer> ids) {
        return cataMapper.deleteCata(ids);
    }

}
