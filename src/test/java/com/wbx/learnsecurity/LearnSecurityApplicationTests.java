package com.wbx.learnsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class LearnSecurityApplicationTests {

    @Test
//    生成数据库的加密密码，要注意建数据库时字段表名一个字不能差
    //表users 字段：username，password，enabled此处的bb为username
    //表authorities 字段：username，authority（权限）
    void contextLoads() {
        System.out.println(new BCryptPasswordEncoder().encode("bb"));
    }

}
