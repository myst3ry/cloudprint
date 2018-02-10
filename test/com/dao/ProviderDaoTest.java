package com.dao;

import com.domain.po.Provider;
import com.domain.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by 27608 on 2018/1/14.
 */
public class ProviderDaoTest {
    private SqlSession session;
    private ProviderDao providerDao;
    /*
    每一个@Test的Annotation都会先加载初始化里的内容，这部分是Junit的内容
     */
    @Before
    public void setUp() throws Exception {
        // 初始化
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(ProviderDaoTest.class.getClassLoader(), resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        providerDao = session.getMapper(ProviderDao.class);
    }
    @Test
    public void findById() throws Exception {
        Provider provider  = providerDao.findById(1);
        System.out.println(provider);
    }
    @Test
    public void findByName()throws Exception{
        List<Provider>  provider = providerDao.findByName("李");
        for(Provider i:provider){
            System.out.println(i);
        }
    }

    @Test
    public void findAll()throws Exception {
        List<Provider> provider = providerDao.findAll(1);
        for(Provider i:provider){
            System.out.println(i);
        }
    }
    @Test
    public void insert() throws Exception {
        /*
        要根据数据库中表的属性进行数据插入，而不是根据实体类中的属性
         */
        Provider provider = new Provider();
        //provider.setId(111);//id是自动递增的，不用设置
        provider.setEmail("dadad@qq.com");
        provider.setName("一号分店");
        provider.setAddress("分店地址");
        provider.setPassword("adadas");
        provider.setOpenTime("6:00");
        provider.setCloseTime("20:00");
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        Timestamp updateTime = new Timestamp(System.currentTimeMillis());
        provider.setCreateTime(createTime);
        provider.setUpdateTime(updateTime);

        int result = providerDao.insert(provider);
        session.commit();
        assertTrue(result == 1);
    }

    @Test
    public void update() throws Exception {
        Provider provider = new Provider();
        provider.setId(111);
        provider.setEmail("dadad@qq.com");
        provider.setName("新一号分店");
        provider.setAddress("分店地址");
        provider.setPassword("adadas");
        provider.setOpenTime("6:00");
        provider.setCloseTime("20:00");
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        Timestamp updateTime = new Timestamp(System.currentTimeMillis());
        provider.setCreateTime(createTime);
        provider.setUpdateTime(updateTime);

        int result = providerDao.update(provider);
        session.commit();
        assertTrue(result == 1);
    }


    @Test
    public void deleteById() throws Exception {
        //按ID删除
        int result = providerDao.delete(1);
        session.commit();
        assertTrue(result == 1);
    }

    @Test
    public void deleteByProvider() throws Exception{
        //按User删除
        Provider provider = new Provider();
        provider.setId(1);
        int result =providerDao.delete(provider);
        session.commit();
        assertTrue(result == 1);
    }
    @After
    public void tearDown() throws Exception {
        session.close();
    }
}