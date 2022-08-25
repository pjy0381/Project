package com.example.Project.dto;

import com.example.Project.entity.Member;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class MemberForm {
    private String frontSSN;
    private String backSSN;
    private String email;
    private String pwd;
    private String phone;
    private int age;

    public static MemberForm createMemberForm(Member member) {
        return new MemberForm(
                member.getFrontSSN(),
                member.getBackSSN(),
                member.getEmail(),
                member.getPwd(),
                member.getPhone(),
                member.getAge()
        );
    }



    public Member toEntity(){
        return  new Member(frontSSN,backSSN,email,pwd,phone,age);
    }
}
