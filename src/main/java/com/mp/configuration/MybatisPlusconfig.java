package com.mp.configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MybatisPlusconfig
 * @Description DOTO
 * @Author Administrator
 * @Date 2019/7/26 17:03
 * @Version 1.0
 */
@Configuration
public class MybatisPlusconfig {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
