package me.gacl.domain;

import mapper.IUser;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by keruyun on 2017/10/30.
 */
public class App2 {
    public static void main(String[] args) {
        //mybatis与spring整合的方式
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        IUser user = ctx.getBean(IUser.class);

        user.getAllUser().forEach(System.out::println);
        user.selectUserByName("c").forEach(System.out::println);

        /*String[] beanNames = ctx.getBeanDefinitionNames();
        int allBeansCount = ctx.getBeanDefinitionCount();

        System.out.println("所有beans的数量是：" + allBeansCount);
        for (String beanName : beanNames) {
            Class<?> beanType = ctx.getType(beanName);
            Package beanPackage = beanType.getPackage();

            Object bean = ctx.getBean(beanName);

            System.out.println("BeanName:" + beanName);
            System.out.println("Bean的类型：" + beanType);
            System.out.println("Bean所在的包：" + beanPackage);

            System.out.println("\r\n");
        }*/
    }
}
