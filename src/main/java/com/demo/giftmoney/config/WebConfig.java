package com.demo.giftmoney.config;

import com.demo.giftmoney.exceptionHandler.AsyncExceptionHandler;
import com.demo.giftmoney.interceptor.ManagementSessionInterceptor;
import com.demo.giftmoney.registrar.MyErrorPageRegistrar;
import com.sug.core.platform.web.filter.PlatformFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.concurrent.Executor;


@Configuration
@MapperScan(value = "com.demo.giftmoney.mapper")
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
public class WebConfig implements WebMvcConfigurer,AsyncConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/static/");
    }

    /*@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }*/

    @Bean
    public ErrorPageRegistrar errorPageRegistrar(){
        return new MyErrorPageRegistrar();
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean () {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new PlatformFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        return registrationBean;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Do any additional configuration here
        return builder.build();
    }

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("AsyncExecutor-");
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(managementSessionInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/resources/**","/test/**","/404","/500");

    }

    @Bean
    public ManagementSessionInterceptor managementSessionInterceptor(){
        return new ManagementSessionInterceptor();
    }

}
