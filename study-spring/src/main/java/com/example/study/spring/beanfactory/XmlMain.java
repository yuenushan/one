package com.example.study.spring.beanfactory;

import com.example.study.spring.bean.controller.ControllerA;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class XmlMain {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaXml(beanRegistry);
        ControllerA controllerA = (ControllerA) container.getBean("controllerA");
        controllerA.hello("ioc");
    }

    private static BeanFactory bindViaXml(DefaultListableBeanFactory beanRegistry) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanRegistry);
        reader.loadBeanDefinitions("classpath:beanfactory.xml");
        return beanRegistry;
    }

}
