package com.study;

import com.study.Operation.UserOperation;
import com.study.domain.User;
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
    public void selectByName02() {

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

    @org.junit.Test
    public void add() {

        String resource = "mybatis-config.xml";
        InputStream inputStream;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlSessionFactory.openSession();

            UserOperation userOperation = sqlSession.getMapper(UserOperation.class);

            User user = new User();
            user.setName("add");
            user.setPass("add");

            userOperation.add(user);

            sqlSession.commit();


        } catch (IOException e) {
            e.printStackTrace();

        }


    }

    @org.junit.Test
    public void delete() {

        String resource = "mybatis-config.xml";
        InputStream inputStream;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlSessionFactory.openSession();

            UserOperation userOperation = sqlSession.getMapper(UserOperation.class);

            userOperation.delete("test");

            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    @org.junit.Test
    public void update() {

        String resource = "mybatis-config.xml";
        InputStream inputStream;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            SqlSession sqlSession = sqlSessionFactory.openSession();

            UserOperation studentOperation = sqlSession.getMapper(UserOperation.class);

            User user = new User();
            user.setName("add");
            user.setPass("addadd");

            studentOperation.update(user);
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();

        }


    }

}
