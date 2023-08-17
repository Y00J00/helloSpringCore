package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    // 인터페이스에만 의존하도록 변경
    private final DiscountPolicy discountPolicy; 
    private final MemberRepository memberRepository;
    
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    

    @Override
    public Order creatOrder(Long memberId, String itemName, int itemprice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemprice);

        return new Order(memberId, itemName, itemprice, discountPrice);
    }

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }



    
}
