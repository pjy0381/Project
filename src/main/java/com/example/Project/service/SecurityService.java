package com.example.Project.service;

import com.example.Project.entity.Member;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Service
public class SecurityService {
    private static final String sKey = "asddsasafjhfjkshafkfhjafkhafjkhffhaskasfhjkahk";

    public String createToken(Member member, long expTime) throws JsonProcessingException {
        if(expTime<=0){
            throw new RuntimeException("만료시간이 0보다 커야함");
        }

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] secretKeyByte = DatatypeConverter.parseBase64Binary(sKey);
        Key signKey = new SecretKeySpec(secretKeyByte, signatureAlgorithm.getJcaName());
        ObjectMapper mapper = new ObjectMapper();

        return Jwts.builder()
                .setSubject(mapper.writeValueAsString(member))
                .signWith(signKey, signatureAlgorithm)
                .setExpiration(new Date(System.currentTimeMillis() + expTime))
                .compact();
    }

    public String getSubject(String token){
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(DatatypeConverter.parseBase64Binary(sKey))
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
