package hello.core;
//공연기획자

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration          //이 어노테이션이 없으면 싱글턴깨짐->전부 다른객체취급
public class AppConfig {
    //@Bean memberService호출 -> new MemoryMemberRepository()생성된다
    //@Bean orderService호출 -> new MemoryMemberRepository()생성된다
    //싱글톤이 깨질까? No

    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    //call AppConfig.memberRepository  //ConfigurationSingletonTest하면 이렇게 나오겠지?

    //call AppConfig.memberService           //하지만실제.
    //call AppConfig.memberRepository      -->세번 호출되야하는데 한 번만호출-싱글톤보장
    //call AppConfig.orderService


    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();}

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }


}
