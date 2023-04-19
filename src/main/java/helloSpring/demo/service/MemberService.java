package helloSpring.demo.service;

import helloSpring.demo.domain.Member;
import helloSpring.demo.repository.MebmerRepository;
import helloSpring.demo.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public class MemberService {
    //클래스명에 블럭 -> 커맨드 쉬트드 t
    //test class 만들기

    //MemberServiceTest에서 사용하는 리퍼지토리와 MemberService에서 사용하는 리퍼지토리의 인스턴스가 다른 인스턴스
    //하나의 인스턴스로 테스트 하고자 함
    private final MebmerRepository mebmerRepository;


    public MemberService(MebmerRepository mebmerRepository) {
        this.mebmerRepository = mebmerRepository;
    }
        //같은 이름이 있는 중복된 회원은 안됨
        public Long join(Member member) {

            //커맨드 + 옵션 + v
            //-> 리턴 타입 + 변수 명 만들어줌

            //컨트롤 + t
            //함수로 뽑아줌

            validateDuplicateMember(member);
            mebmerRepository.save(member);
            return member.getId();
        }

    private void validateDuplicateMember(Member member) {
        mebmerRepository.findByName(member.getName()).ifPresent(m->{
            throw new IllegalStateException("이미 존재");
        });
    }

    public List<Member> findMembers() {
            return mebmerRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
            return mebmerRepository.findById(memberId);
    }

}
