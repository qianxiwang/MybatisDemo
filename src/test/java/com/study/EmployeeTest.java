package com.study;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class EmployeeTest {


    @Test
    public void findEmployees01() {

        String resource = "mybatis-config.xml";
        InputStream inputStream;
        SqlSession sqlSession = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = sqlSessionFactory.openSession();

            List<Map> list = sqlSession.selectList("EmployeeOperation.findEmployees");

            for (Map map : list) {
                System.out.println(map);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }


    @Test
    public void selectEmployee() {

        String resource = "mybatis-config.xml";
        InputStream inputStream;
        SqlSession sqlSession = null;

        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = sqlSessionFactory.openSession();

            List<Map> list = sqlSession.selectList("EmployeeOperation.selectEmployee");

            System.out.println(list);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
}
