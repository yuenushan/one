package com.example.study.spring.beanfactory;

import com.example.study.spring.bean.controller.ControllerA;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class XmlMain {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanRegistry = new DefaultListableBeanFactory();
        BeanFactory container = bindViaXml(beanRegistry);
        PropertyPlaceholderConfigurer propertyPostProcessor = new PropertyPlaceholderConfigurer();
        propertyPostProcessor.setLocation(new ClassPathResource("beanfactory.properties"));
        propertyPostProcessor.postProcessBeanFactory(beanRegistry);

        ControllerA controllerA = (ControllerA) container.getBean("controllerA");
        controllerA.hello("ioc");
        System.out.println(controllerA.whoami());
    }

    private static BeanFactory bindViaXml(DefaultListableBeanFactory beanRegistry) {
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanRegistry);
        reader.loadBeanDefinitions("classpath:beanfactory.xml");
        return beanRegistry;
    }

}
