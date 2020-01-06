package com.example.demo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.domain.Member;
import com.example.demo.domain.Role;
import com.example.demo.persistence.MemberRepository;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Commit
public class PasswordEncoderTest {
	
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	public void testInsert() {
		Member member = new Member();
		member.setId("manager2");
		member.setPassword(encoder.encode("manager456"));
		member.setName("매니저2");
		member.setRole(Role.ROLE_MANAGER);
		member.setEnabled(true);
		memberRepo.save(member);
	}
	
}
