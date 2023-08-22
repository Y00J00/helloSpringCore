package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        // MemberService memberService = new MemberServiceImpl();
        // OrderService orderService = new OrderServiceImpl();

        // AppConfig appConfig = new AppConfig();
        // OrderService orderService = appConfig.orderService();
        // MemberService memberService = appConfig.memberService();

        // 스프링 컨테이너 생성
        // ApplicationContext 는 인터페이스
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); 
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Long memberId = 1L;

        Member member  = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.creatOrder(memberId, "item1", 120000);
        System.out.println(order);

    }

   

    
}
