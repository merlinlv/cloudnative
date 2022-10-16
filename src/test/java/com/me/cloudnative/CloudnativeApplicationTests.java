package com.me.cloudnative;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;

//@SpringBootTest()
@RunWith(SpringRunner.class)
@AutoConfigureMybatis
@MapperScan("com.me.cloudnative.mapper")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CloudnativeApplicationTests {

	@Test
	void contextLoads() {
	}

}
