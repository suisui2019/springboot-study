package com.study.day01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Auther: lifq
 * @Description:
 */
public class Main01 {

    public static void main (String []args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        ListService listService = applicationContext.getBean(ListService.class);

        System.out.println(listService.showListCmd());


    }



}
