package com.example.Project.service;

import com.example.Project.dto.MemberForm;
import com.example.Project.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<MemberForm> findPE(String id, String pwd) {
        return memberRepository.findByPE(id, pwd)
                .stream()
                .map(member -> MemberForm.createMemberForm(member))
                .collect(Collectors.toList());
    }

}
