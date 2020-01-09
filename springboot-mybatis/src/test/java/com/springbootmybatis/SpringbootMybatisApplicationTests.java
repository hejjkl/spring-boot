package com.springbootmybatis;

import com.springbootmybatis.dao.UserinfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringbootMybatisApplicationTests {

    @Autowired
    UserinfoMapper userinfoMapper;
    @Test
    void contextLoads() {
        log.info("根据证件类型查询结果：{}",userinfoMapper.getUserinfoByIdno("110101199010100100").get(0).toString());
        log.info("根据姓名查询结果:{}",userinfoMapper.getUserinfoByName("我叫Anna"));

    }

}
