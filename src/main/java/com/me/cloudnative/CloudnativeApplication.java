package com.me.cloudnative;

import com.me.cloudnative.domain.NativeMember;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication()
@MappedTypes({NativeMember.class})
@MapperScan("com.me.cloudnative.mapper")
@EnableDiscoveryClient
public class CloudnativeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudnativeApplication.class, args);
	}

}
