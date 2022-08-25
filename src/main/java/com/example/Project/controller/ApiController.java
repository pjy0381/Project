package com.example.Project.controller;

import com.example.Project.dto.MemberForm;
import com.example.Project.entity.Member;
import com.example.Project.repository.MemberRepository;
import com.example.Project.service.MemberService;
import com.example.Project.service.SecurityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/security")
@Slf4j
public class ApiController {
    @Autowired
    private SecurityService securityService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/token/create")
    public String createToken(@RequestParam(value = "id")String id, @RequestParam(value = "pwd") String pwd) throws JsonProcessingException {
        List<MemberForm> forms =  memberService.findPE(id, pwd);
        Member nm = forms.get(0).toEntity();
        log.info(nm.toString());
        if(nm.getEmail().equals(null)){
            throw new IllegalArgumentException("입력된 아이디 정보가 없습니다.");
        }
        if(!nm.getPwd().equals(pwd)){
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
        String token = securityService.createToken(nm, (10*1000*60));
        return token;
    }
    @PostMapping("/subject/get")
    public String getSubject(@RequestParam(value = "token") String token){
        String subject = securityService.getSubject(token);
        return subject;
    }

    @PostMapping("/pwd/update")
    public String pwdUpdate(@RequestBody Member dto){
        memberRepository.save(dto);
        return "success";
    }
}
