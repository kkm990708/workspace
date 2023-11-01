package edu.kh.project.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@PropertySource("classpath:/config.properties")
public class FileConfig implements WebMvcConfigurer{
	
	@Value("${my.images.connectpath}")
	private String connectPath; // 외부 폴더로 연결될 웹 요청 주소

	@Value("${my.images.resourcepath}")
	private String resourcepath; // 외부 폴더 경로
	
	// 요청 주소가 /images로 시작할때 외부 폴더로 연결하는 메서드
	// (WebMvcConfigurer 상속 -> addResourceHandlers() 오버라이딩)
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler(connectPath)
		.addResourceLocations(resourcepath);
		
		/* 웹 요청 주소에 따른 추가적인 폴더 구분이 필요한 경우*/
		// -> 그냥 위에 구문 따라서 추가
		
		// 만약에 /pdf/**  요청이 오면
		// file:///C:/workspace/project-resource/images/ 폴더로 연결
		registry.addResourceHandler("/pdf/**")
				.addResourceLocations("file:///C:/workspace/project-resource/images/pdf");
		
	}
	
	
}
