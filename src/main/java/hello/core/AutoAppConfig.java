package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",//잘안씀근데ㅇ //스캔할 범위 지정(괄호해서 여러 범위 가능)//Default는 설정 정보 패키지//


        //다 뒤져서 스프링빈으로 자동등록하는데 뺄 것을 정해주자 //AppConfig예제 안전하게 유지하기위해
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)       //includerFilters 컴포넌트 스캔 대상을 추가로 지정한다.excludeFilters 제외할대상


public class AutoAppConfig {
}
