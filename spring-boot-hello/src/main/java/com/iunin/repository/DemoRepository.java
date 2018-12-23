package com.iunin.repository;

import com.iunin.dao.Demo;
import org.springframework.data.repository.CrudRepository;

/**
 * @author: yonghui
 * @Description: Repository是接口，不是类
 * @Date: Created in 20:31 2018/1/30
 */
public interface DemoRepository extends CrudRepository<Demo,Integer> {
}
