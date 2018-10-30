package com.github.MineMybug.security.job.admin.controller.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleServletHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.MineMybug.security.job.admin.controller.interceptor.CookieInterceptor;
import com.github.MineMybug.security.job.admin.controller.interceptor.PermissionInterceptor;
import com.github.MineMybug.security.job.admin.controller.resolver.WebExceptionResolver;

@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);
	
    /**
     * 多个拦截器组成一个拦截器链
     */
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new PermissionInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(new CookieInterceptor()).addPathPatterns("/**");
    }
    
    /**
     * 描述 : 资源访问处理器
     * 可以在jsp中使用/static/**的方式访问/WEB-INF/static/下的内容
     * @param registry
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("addResourceHandlers");
        registry.addResourceHandler("/**/*.html").addResourceLocations("classpath:/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    
    /**
     * 采用MappingJackson2HttpMessageConverter来实现JSON数据的处理
     * "@ResponseBoby"均通过此MappingJackson2HttpMessageConverter来进行json数据转换
     */
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJackson2HttpMessageConverter());
    }
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
    public FilterRegistrationBean characterEncodingFilterRegistration() {
    	FilterRegistrationBean registration = new FilterRegistrationBean();
    	//注入过滤器
    	CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    	characterEncodingFilter.setEncoding("UTF-8");
    	characterEncodingFilter.setForceEncoding(true);
    	registration.setFilter(characterEncodingFilter);
    	//拦截规则
    	registration.addUrlPatterns("/*");
    	//过滤器名称
    	registration.setName("CharacterEncodingFilter");
    	//过滤器顺序
//    	registration.setOrder(1);
    	return registration;
    }
    
    /**
     * 描述 : <注册视图处理器>. <br>
     *<p>
     <使用方法说明>
     </p>
     * @return
     */
    @Bean(name="viewResolver")
    public ViewResolver viewResolver() {
        logger.info("ViewResolver");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    
    /**
     * 描述 : <注册消息资源处理器>. <br>
     *<p>
     <使用方法说明>
     </p>
     * @return
     */
    @Bean
    public MessageSource messageSource() {
        logger.info("MessageSource");
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("config.messages.messages");
        return messageSource;
    }
    
    /**
     * 描述 : <注册servlet适配器>. <br>
     *<p>
     <只需要在自定义的servlet上用@Controller("映射路径")标注即可>
     </p>
     * @return
     */
    @Bean
    public HandlerAdapter servletHandlerAdapter(){
        logger.info("HandlerAdapter");
        return new SimpleServletHandlerAdapter();
    }
    
    /**
     * 描述 : <异常处理器>. <br>
     *<p>
     <系统运行时遇到指定的异常将会跳转到指定的页面>
     </p>
     * @return
     */
    @Bean(name="exceptionResolver")
    public WebExceptionResolver simpleMappingExceptionResolver(){
        logger.info("WebExceptionResolver");
        WebExceptionResolver exceptionResolver = new WebExceptionResolver();
        return exceptionResolver;
    }
    
//    /**
//     * 描述 : <文件上传处理器>. <br>
//     *<p>
//     <使用方法说明>
//     </p>
//     * @return
//     */
//    @Bean(name="multipartResolver")
//    public CommonsMultipartResolver commonsMultipartResolver(){
//        logger.info("CommonsMultipartResolver");
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setDefaultEncoding("utf-8");
//        commonsMultipartResolver.setMaxInMemorySize(40960);
//        commonsMultipartResolver.setMaxUploadSize(50485760000L);
//        return commonsMultipartResolver;
//    }


    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        converter.setSupportedMediaTypes(supportedMediaTypes);
        converter.setObjectMapper(objectMapper());
        return converter;
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        return objectMapper;
    }

}