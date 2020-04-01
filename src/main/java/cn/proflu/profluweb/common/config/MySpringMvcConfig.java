package cn.proflu.profluweb.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class MySpringMvcConfig extends WebMvcConfigurerAdapter{

	@Autowired
	private InterceptorConfig interceptorConfig;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptorConfig).addPathPatterns("/**");

	}
}
