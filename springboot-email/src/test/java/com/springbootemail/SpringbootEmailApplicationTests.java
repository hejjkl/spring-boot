package com.springbootemail;

import com.springbootemail.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootEmailApplicationTests {
    @Autowired
    MailService mailService;
    @Test
    void contextLoads() {
        mailService.sendSimpleMail("hejingjing@sinosoft.com.cn","美国暴雪娱乐有限公司","hello");
    }

}
