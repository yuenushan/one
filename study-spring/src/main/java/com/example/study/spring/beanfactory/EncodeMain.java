package com.example.study.spring.beanfactory;

import com.example.study.spring.bean.controller.ControllerA;
import com.example.study.spring.bean.service.impl.ServiceAImpl;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class EncodeMain {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaCode(beanRegistry);
        ControllerA controllerA = (ControllerA) container.getBean("controllerA");
        controllerA.hello("ioc");
    }

    private static BeanFactory bindViaCode(DefaultListableBeanFactory beanRegistry) {
        AbstractBeanDefinition controllerADefinition = new RootBeanDefinition(ControllerA.class);
        AbstractBeanDefinition serviceADefinition = new RootBeanDefinition(ServiceAImpl.class);
        beanRegistry.registerBeanDefinition("controllerA", controllerADefinition);
        beanRegistry.registerBeanDefinition("serviceAImpl", serviceADefinition);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("serviceA", serviceADefinition));
        controllerADefinition.setPropertyValues(propertyValues);
        return beanRegistry;
    }
}
