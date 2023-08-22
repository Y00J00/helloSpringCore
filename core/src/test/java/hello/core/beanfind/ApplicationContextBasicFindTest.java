package hello.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findByName() {
       MemberService memberService = ac.getBean("memberService", MemberService.class);
       System.out.println("memberService " + memberService); //  hello.core.member.MemberServiceImpl@5026735c
       System.out.println("memberService.getclass" + memberService.getClass()); // hello.core.member.MemberServiceImpl
    }

    @Test
    @DisplayName("빈 타입으로 조회")
    void findByType() {
       MemberService memberService = ac.getBean(MemberService.class);
       System.out.println("memberService " + memberService); //  hello.core.member.MemberServiceImpl@5026735c
       System.out.println("memberService.getclass" + memberService.getClass()); // hello.core.member.MemberServiceImpl
    }


    @Test
    @DisplayName("구체 타입으로 조회")
    void findByImpl() {
       MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
       System.out.println("memberService " + memberService); //  hello.core.member.MemberServiceImpl@5026735c
       System.out.println("memberService.getclass" + memberService.getClass()); // hello.core.member.MemberServiceImpl
    }
}
