package com.halo.blog;

import com.halo.blog.enums.PropertyEnum;
import com.halo.blog.service.OptionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

@Slf4j
@SpringBootApplication
public class Application {

	@Resource
	private OptionsService optionsService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		String serverPort = context.getEnvironment().getProperty("server.port");
		//输入访问链接
		log.info("Clay started at http://localhost:" + serverPort);

	}


}
