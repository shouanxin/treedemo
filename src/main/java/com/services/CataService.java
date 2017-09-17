package com.services;

import com.TreeUtils;
import com.bean.Catalogue;
import com.dao.ICataDao;
import com.interfaces.ICataService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("cataService")
public class CataService implements ICataService{
    protected  static Logger logger = Logger.getLogger(CataService.class);
    @Autowired
    ICataDao catadao;

    public List<Catalogue> getAllCata() {
        List<Catalogue> rs = catadao.getAllCata();
        return rs;
    }

    public int deleteCata(Integer id) {
        List<Integer> dels = new ArrayList<Integer>();
        //保存拼装数据，格式为：key=id,value=pid
        Map<Integer,Integer> resMap = new HashMap<Integer, Integer>();
        try {
            List<Catalogue> rs = catadao.getAllCata();

            Catalogue catalogue = null;
            for (int i = 0, len = rs.size(); i < len; i++) {
                if (rs.get(i) != null) {
                    catalogue = rs.get(i);
                    resMap.put(catalogue.getId(), catalogue.getPid());
                }
            }

            TreeUtils.deleteNode(resMap, dels, id);

            logger.info(dels);

            return catadao.deleteCata(dels);
        }catch (Exception e){
            logger.error("删除数据异常：" + e);
        }
        return  -1;
    }
}
