package com.example.Project.repository;

import com.example.Project.dto.MemberForm;
import com.example.Project.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MemberRepository extends JpaRepository<Member,String> {
    @Query(value = "select * from member where phone = :id or email = :id and pwd = :pwd", nativeQuery = true)
    List<Member> findByPE(String id, String pwd);
}
