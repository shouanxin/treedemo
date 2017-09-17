package com.services;

import com.bean.Catalogue;
import com.dao.ICataDao;
import com.interfaces.ICataService;
import com.mapper.CataMapper;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestCataService {
    protected  static Logger logger = Logger.getLogger(TestCataService.class);
    ApplicationContext context;

    @Autowired
    CataMapper cataMapper;

    @Autowired
    ICataDao catadao;

    @Autowired
    ICataService cataService;

    @Before
    public void init(){
       context = new ClassPathXmlApplicationContext("application.xml");
       cataMapper = context.getBean(CataMapper.class);
       catadao = context.getBean(ICataDao.class);
       cataService = context.getBean(ICataService.class);
    }

    /**
     * 测试：获取数据库所有信息
     */
    @Test
    public void testGetAllCata(){
        List<Catalogue> rs = cataService.getAllCata();
        logger.info(rs.size());

    }

    /**
     * 测试删除目录
     * 数据库目录结构如下（#号后代表id）
     *
     * |--mysql架构与历史 #1
            |--mysql逻辑架构 #4
                |--连接管理与安全性 #7
                |--优化与执行 #8
            |--并发控制 #5
            |--事务 #6
     * |--mysql基准测试 #2
            |--为什么要进行基准测试 #9
            |--基准测试的策略 #10
                |--测试何种指标 #11
     * |--mysql服务器性能剖析 #3
            |--性能优化简介 #12
                |--通过性能剖析进行优化 #13
            |--对应用程序进行性能剖析 #14
            |--剖析mysql查询 #15

     *
     * 测试结果：
     *  id = 4 时，结果为：[4, 7, 8]
     *  id = 5 时，结果为：[5]
     *  id = 2 时，结果为：[2, 9, 10, 11]
     */
    @Test
    public void testDelNode(){
        int delId = 2;
        int count = cataService.deleteCata(delId);
       logger.info(count);
    }
}
