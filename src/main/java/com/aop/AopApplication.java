package com.aop;

import com.aop.dao.AccountDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AopApplication {

    public static void main(String[] args) {
//        SpringApplication.run(AopApplication.class, args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AopApplication.class);

        AccountDao accountDao = ctx.getBean("accountDao",AccountDao.class);

        accountDao.addAccount();
        accountDao.addUser("Mount");
        accountDao.throwingException();

        ctx.close();

    }

}
