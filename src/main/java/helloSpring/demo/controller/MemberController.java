package helloSpring.demo.controller;


import helloSpring.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller//스프링 컨테이너에 컨트롤러 빈이 등록이 되고 관리됨
public class MemberController {

    // 따라서 서비스를 매번 new 하기 보다는 컨테이너에서 받아서 쓰도록 해야 함
    // 컨테이너에 딱 하나만 등록되니 그걸 쓰면 됨
    //private final MemberService memberService = new MemberService();
    private  final MemberService memberService;

    @Autowired
    //@Autowired :
    //@Controller로 스프링 컨테이너 뜰때 생성자를 콜
    //스프링이 멤버 서비스와 컨트롤러를 연결시켜 줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }



}
