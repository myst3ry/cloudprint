package com.dao;

import com.domain.po.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

import com.domain.po.SystemContext;
import com.domain.po.Pager;
/**
 * Created by 27608 on 2018/1/14.
 */
public class UserDaoTest {
    private SqlSession session;
    private UserDao userDao;
    /*
    每一个@Test的Annotation都会先加载初始化里的内容，这部分是Junit的内容
     */
    @Before
    public void setUp() throws Exception {
        // 初始化
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(UserDaoTest.class.getClassLoader(), resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        userDao = session.getMapper(UserDao.class);
    }
    @Test
    public void findById() throws Exception {
        User user = userDao.findById(1);
        System.out.println(user);
    }

    @Test
    public void findByName()throws Exception{
        List<User>  user = userDao.findByName("灵");
        for(User i:user){
            System.out.println(i);
        }
    }
    @Test
    public void findAll()throws Exception {
        List<User> allUser = userDao.findAll(1);
        for(User i:allUser){
            System.out.println(i);
        }
    }

    @Test
    public void find()throws Exception{
        SystemContext.setPageSize(2);
        SystemContext.setPageOffset(0);
        int pageSize = SystemContext.getPageSize();
        int pageOffset = SystemContext.getPageOffset();

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("email","qq");//按email进行模糊查找条件,如果不传值，则对应find中的动态SQL，去掉该条件进行查询
        params.put("tel","00000");//按tel进行模糊查找条件，注意这些查找条件只要传值，就是生效的
        params.put("sort","email");//排序依据,如果不传值，则对应find中的动态SQL，进行无排序查询
        params.put("dir","asc");//升降序，如果不传值，则对应find中的动态SQL，按ASC排序（前提是sort有值）
        params.put("pageOffset",pageOffset);
        params.put("pageSize",pageSize);

        List<User> datas = userDao.find(params);//得到满足条件的User集合
        Pager<User> pages = new Pager<User>();
        pages.setDatas(datas);//将User集合存入Pager.datas中
        pages.setPageOffset(pageOffset);
        pages.setPageSize(pageSize);

        int totalRecord = userDao.find_count(params);
        pages.setTotalRecord(totalRecord);

        System.out.println("总条数"+ pages.getTotalRecord());//从Pager中取出了分页信息之TotalRecord
        for(User u:pages.getDatas())
            System.out.println(u);//从Pager中取出了User信息
    }

    @Test
    public void insert() throws Exception {
        /*
        要根据数据库中表的属性进行数据插入，而不是根据实体类中的属性
         */
        User user = new User();
        //user.setId(111);//id是自动递增的，不用设置
        user.setEmail("dadad@qq.com");
        user.setName("老王");
        user.setPassword("adadas");
        user.setPrintCount(10);
        user.setTel("111122");
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        Timestamp updateTime = new Timestamp(System.currentTimeMillis());
        user.setCreateTime(createTime);
        user.setUpdateTime(updateTime);
        //
        /*
            插入外键的写法
         */
        Provider provider = new Provider();
        provider.setId(1);//商家只有一个所以ID = 1
        user.setProvider(provider);
        int result = userDao.insert(user);
        session.commit();//只有commit后数据库才会进行更改
        assertTrue(result == 1);
    }

    @Test
    public void update() throws Exception {
        User user = new User();
        user.setId(3);//将id设置为刚才测试insert时新增的id（在数据库中查看）
        user.setEmail("dadad@qq.com");
        user.setName("新老王");
        user.setPassword("adadas");
        user.setPrintCount(10);
        user.setTel("111122");
        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        Timestamp updateTime = new Timestamp(System.currentTimeMillis());
        user.setCreateTime(createTime);
        user.setUpdateTime(updateTime);
        //
        /*
            插入外键的写法
         */
        Provider provider = new Provider();
        provider.setId(1);//商家只有一个所以ID = 1
        user.setProvider(provider);
        int result = userDao.update(user);
        session.commit();//只有commit后数据库才会进行更改
        assertTrue(result == 1);
    }


    @Test
    public void deleteById() throws Exception {
        //按ID删除
        int result = userDao.delete(3);//将id设置为刚才测试insert时新增的id（在数据库中查看）
        session.commit();
        assertTrue(result == 1);
    }

    @Test
    public void deleteByUser() throws Exception{
        //按User删除
        User user = new User();
        user.setId(4);
        int result =userDao.delete(user);
        session.commit();
        assertTrue(result == 1);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }
}