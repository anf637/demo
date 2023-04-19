package helloSpring.demo;

import helloSpring.demo.repository.MebmerRepository;
import helloSpring.demo.repository.MemoryMemberRepository;
import helloSpring.demo.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MebmerRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
