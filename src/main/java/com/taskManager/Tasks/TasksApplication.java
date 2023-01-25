package com.taskManager.Tasks;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EntityScan("com.taskManager.Tasks.Models")
//@ComponentScan("com.taskManager.Tasks.*")
//@EnableJpaRepositories("com.taskManager.Tasks.*")
public class TasksApplication {


	public static void main(String[] args) {
		SpringApplication.run(TasksApplication.class, args);
	}

}


