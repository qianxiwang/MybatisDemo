package com.study;

import com.study.Operation.UserOperation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class AppTest {
    @Test
    public void queryAll() {

        String resource = "mybatis-config.xml";
        InputStream inputStream;
        SqlSession sqlSession = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = sqlSessionFactory.openSession();

            List<Map> list = sqlSession.selectList("User.queryAll");

            for (Map map : list) {
                System.out.println(map);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


    }

    @org.junit.Test
    public void selectByName01() {
        String resource = "mybatis-config.xml";
        InputStream inputStream;
        SqlSession sqlSession = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = sqlSessionFactory.openSession();

            Map map = sqlSession.selectOne("User.selectByName", "pk");

            System.out.println(map);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @org.junit.Test
    public void selectById02() {

        String resource = "mybatis-config.xml";
        InputStream inputStream;
        SqlSession sqlSession = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = sqlSessionFactory.openSession();

            UserOperation userOperation = sqlSession.getMapper(UserOperation.class);
            Map map = userOperation.selectByName("qianxi");

            System.out.println(map);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

}
