package com.ueumd.tech.service.study.impl;

import com.ueumd.tech.service.study.IHelloService;
import org.springframework.stereotype.Repository;

/**
 * Component 也可以
 * Repository
 */
@Repository
public class HelloServiceImpl implements IHelloService {
    @Override
    public void save() {
        System.out.println("Hello");
    }
}
