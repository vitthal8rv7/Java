package com.learn.java.swagger2.config;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

@Configuration
@Component
public class SwaggerConfig {

//	 @Bean
//	    public Docket api() {
//	        return new Docket(DocumentationType.SWAGGER_2)
//	                .select()
//	                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//	                .paths(PathSelectors.any())
//	                .build().apiInfo(getApiInfo());
//	    }
//	    
	 
		@Bean
		Docket api() {
			return new Docket(DocumentationType.SWAGGER_2)
					.useDefaultResponseMessages(false)
					.globalResponses(HttpMethod.GET, list()) // common and apply to all APIs.
					.select()
					.apis(RequestHandlerSelectors.any()) 
					.paths(PathSelectors.any())
					.build();
		}

	 private List<Response> list(){
			List<Response> list = new ArrayList<Response>();			
			list.add(new ResponseBuilder().code("500").description("500 message").build());
			list.add(new ResponseBuilder().code("403").description("Forbidden!!!!!").build());
			return list;
	 }
	 
	    private ApiInfo getApiInfo() {
	        return new ApiInfo(
	                "Java Learning",
	                "Swagger Demo",
	                "v1",
	                "TERMS OF SERVICE URL",
	                new Contact("Vitthal Aradwad","URL","vitthalaradwad@gmail.com"),
	                "LICENSE",
	                "http://localhost:8080/swagger-ui/index.html",
	                Collections.emptyList()
	        );
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
//	    Exception: Problem
//	    Caused by: java.lang.NullPointerException: Cannot invoke "org.springframework.web.servlet.mvc.condition.PatternsRequestCondition.getPatterns()" because "this.condition" is null
//		at springfox.documentation.spring.web.WebMvcPatternsRequestConditionWrapper.getPatterns(WebMvcPatternsRequestConditionWrapper.java:56) ~[springfox-spring-webmvc-3.0.0.jar:3.0.0]
	    //Solution1: @EnableWebMvc
	    //Solution2: below bean
	    @Bean
	    public static BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
	        return new BeanPostProcessor() {

	            @Override
	            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
	                if (bean instanceof WebMvcRequestHandlerProvider ) {
	                    customizeSpringfoxHandlerMappings(getHandlerMappings(bean));
	                }
	                return bean;
	            }

	            private <T extends RequestMappingInfoHandlerMapping> void customizeSpringfoxHandlerMappings(List<T> mappings) {
	                List<T> copy = mappings.stream()
	                    .filter(mapping -> mapping.getPatternParser() == null)
	                    .collect(Collectors.toList());
	                mappings.clear();
	                mappings.addAll(copy);
	            }

	            @SuppressWarnings("unchecked")
	            private List<RequestMappingInfoHandlerMapping> getHandlerMappings(Object bean) {
	                try {
	                    Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
	                    field.setAccessible(true);
	                    return (List<RequestMappingInfoHandlerMapping>) field.get(bean);
	                } catch (IllegalArgumentException | IllegalAccessException e) {
	                    throw new IllegalStateException(e);
	                }
	            }
	        };
	    }    
	}	
//	@Bean
//	Docket api() {
//		List<Response> list = new ArrayList<Response>();
//		list.add(new ResponseBuilder().code("500").description("500 message").build());
//		list.add(new ResponseBuilder().code("403").description("Forbidden!!!!!").build());
//		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).globalResponses(HttpMethod.GET, list)
//.select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).build();
//	}
//
//	@Bean
//	ApiInfo apiInfo() {
//		
//		
//		return new ApiInfo("My REST API", "Some Custom Description Of API", "API LIST", "Terms Of Service",
//				new Contact("John Doe", "www.example.com", "myeaddress@company.com"), "License of API",
//				"API license URL", Collections.emptyList());
//	}
//}

//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Spring Boot REST API")
//                .description("Spring Boot REST API for Demo Application")
//                .version("1.0.0")
//                .termsOfServiceUrl("https://example.com/terms")
//                .contact(new Contact("Your Name", "www.example.com", "your-email@example.com"))
//                .license("Apache License Version 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
//                .build();
//    }
//}