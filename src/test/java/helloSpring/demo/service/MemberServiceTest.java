package helloSpring.demo.service;

import helloSpring.demo.MemoryMemberRepositoryTest;
import helloSpring.demo.domain.Member;
import helloSpring.demo.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;//= new MemberService();
    MemoryMemberRepository memoryMemberRepository;// = new MemoryMemberRepository();



    @BeforeEach
    public void beforeEach() {
        memberService = new MemberService(new MemoryMemberRepository());
    }

    @AfterEach
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void 회원가입() {

        //given 이 상황이 주어졌을 때
        Member member = new Member();
        member.setName("하잉");

        //when 실행을 히면
        Long join = memberService.join(member);

        //then 이게 나와야해
        Member findMember = memberService.findOne(join).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }


    //중복 회원 검증을 해야 함
    @Test
    public void 중복_회원_예외처리(){
        //given
        Member member1 = new Member();
        member1.setName("스프링");

        Member member2 = new Member();
        member2.setName("스프링");

        //when
        memberService.join(member1);
        //방법1
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(illegalStateException.getMessage()).isEqualTo("이미 존재");
        //방법2
//        try{
//            memberService.join(member2); //여기서 예외발생 해야 함
//            fail("예외가 발생");
//        }catch (IllegalStateException e) {
//            //정상적으로 예외 발생
//            assertThat(e.getMessage()).isEqualTo("이미 존재 11");
//        }
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}