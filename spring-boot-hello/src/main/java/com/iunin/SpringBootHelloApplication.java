package com.iunin;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@MapperScan("com.iunin.mapper")
public class SpringBootHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloApplication.class, args);
	}
	/**
	 * fastJson的配置:
	 * 方式一：启动类extends WebMvcConfigurerAdapter，并覆写configureMessageConverters方法
	 * 方式二：注入 Bean：HttpMessageConverts
	 */

	//方式一：
	/*@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		// 1、需要先定义一个 converter 装换消息的对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		// 2、添加fastJson 的配置信息，比如是否要格式化返回的json对象
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(
				SerializerFeature.PrettyFormat
		);
		// 处理中文乱码问题
		List<MediaType> fastMediaType = new ArrayList<>();
		fastMediaType.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(fastMediaType);
		// 3、在 converterer 中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		// 4、将 converter 添加到 converters 中
		converters.add(fastConverter);
	}*/

	// 方式二：注入 Bean：HttpMessageConverts
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverts(){
		// 1、创建 converter 对象
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		// 2、添加 fastJson 的配置信息
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		// 处理中文乱码
		List<MediaType> fastJsonMediaType = new ArrayList<>();
		fastJsonMediaType.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(fastJsonMediaType);
		// 3、在 converter 中添加配置信息
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter converter = fastConverter;
		return new HttpMessageConverters(converter);
	}

}
