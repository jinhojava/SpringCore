package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

    @Test
    @DisplayName("스프링없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 호출할때마다 객체를 생성하는지 조회해보기
        MemberService memberService1 = appConfig.memberService();

        //2. 호출할때마다 객체를 생성하는지 조회해보기
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1!==memberService2
        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }


    @Test
    @DisplayName("싱클톤 패턴을 적용한 객체 사용")
    void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService2 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);
        //같은 객체의 인스턴스임

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
        //same ==  참조 동등성
        //equal     내용동일 값동등성(객체의 내용) 객체동일하지않아도 내용동일이면true
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1!==memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);

    }
}
