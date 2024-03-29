package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //A사용자 10000원주문
        int userAPrice = statefulService1.order("userA", 10000);
        //B사용자 10000원주문
        int userBPrice = statefulService2.order("userB", 20000);
        //사용자A가 주문금액을 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice); // 20000이 나옴;;;

    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return  new StatefulService();
        }
    }
}