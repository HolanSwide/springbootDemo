package com.holanswide.demo;

import com.holanswide.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    User user;
    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() {
        System.out.println(String.valueOf(user.getUid())+' '+user.getUsername()+' '+user.getPassword());
    }
    @Test
    void showDataSource() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
    }

}
