package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

/*
 * 정액 할인 정책
 */
public class FixDiscountPolicy implements DiscountPolicy{
    
    private int discountFixAmount = 1000; // 무조건 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() ==  Grade.VIP) { // enum은 == 사용
            return discountFixAmount;
        } else {
            return 0;
        }
    }
    
}
