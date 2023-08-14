package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("vip는 10퍼센트 할인")
    void vip_succ(){
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("vip 아니면 할인 안돼")
    void vip_fail() {
        //given
        Member member = new Member(1L, "memberA", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

}
