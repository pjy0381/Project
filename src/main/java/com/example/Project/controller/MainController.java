package com.example.Project.controller;

import com.example.Project.dto.MemberForm;
import com.example.Project.entity.Member;
import com.example.Project.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class MainController {
    @Autowired
    private MemberRepository memberRepository;


    @GetMapping("/register")
    public String regPage(){
        return "register/index";
    }
    @GetMapping("/index")
    public String mainPage(){
        return "/index";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "/login/loginPage";
    }

    @GetMapping("/redirect")
    public String msgPage(){
        return "/redirect";
    }

    @PostMapping("/create")
    public  String createMember(MemberForm form, Model model){
        Member member = form.toEntity();
        String email = member.getEmail();
        String msg = "회원가입 완료";
        String url = "/index";
        if(memberRepository.existsById(email) == true){
            msg = "중복된 아이디가 존재합니다";
            url = "/register";
            model.addAttribute("msg",msg);
            model.addAttribute("url",url);
            return "/redirect";
        }
        model.addAttribute("msg",msg);
        model.addAttribute("url",url);
        memberRepository.save(member);
        return "/redirect";
    }




}
