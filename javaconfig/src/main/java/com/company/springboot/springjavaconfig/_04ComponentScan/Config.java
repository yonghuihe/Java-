package com.company.springboot.springjavaconfig._04ComponentScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration标签 把一个类标记为spring的配置对象
 * ComponentScan 会扫描被标注的类（当前包及其子包）
 * @author yonghui
 *
 */
@Configuration
@ComponentScan
public class Config {

}
