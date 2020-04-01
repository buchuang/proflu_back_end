package cn.proflu.profluweb;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan(basePackages = "cn.proflu.profluweb.dao.*")
@EnableSwagger2
public class ProfluwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfluwebApplication.class, args);
	}
}
