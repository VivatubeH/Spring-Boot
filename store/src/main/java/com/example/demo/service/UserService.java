package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRegisterForm;
import com.example.demo.exception.AlreadyUsedEmailException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.User;
import com.example.demo.vo.UserRole;

@Service
@Transactional // 자동으로 트랜잭션처리해줌
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 이메일을 전달받아서 존재여부를 체크하는 서비스다.
	 * @param email 이메일
	 * @return 이메일이 존재하면 true를 반환한다.
	 */
	public boolean isExistEmail(String email) {
		User user = userMapper.getUserByEmail(email);
		return user != null;
	}
	/**
	 * 신규 사용자 정보를 전달받아서 회원가입시키는 서비스다.
	 * @param form
	 */
	public void addNewUser(UserRegisterForm form) {
		// 이메일 중복 체크 
		User savedUser = userMapper.getUserByEmail(form.getEmail());
		if(savedUser != null) {
			throw new AlreadyUsedEmailException(form.getEmail());
		}
		
		User user = new User();
		BeanUtils.copyProperties(form, user);
		// 비밀번호를 암호화한다.
		String encodedPaString = passwordEncoder.encode(user.getPassword());
		
		user.setPassword(encodedPaString);
		
		userMapper.insertUser(user);
		
		addUserRole(user.getNo(), "ROLE_USER"); // 쪼갤거면 트랜잭션 시작점에서 호출하기 
												//메소드 안에 다 때려넣기 이미 만들어놓으면 서비스 안에서 호출 
	}
	
	/**
	 * 사용자번호, 권한이름을 전달받아서 권한을 추가하는 서비스다.
	 * @param userNo 사용자번호
	 * @param roleName 권한이름 
	 */
	public void addUserRole(int userNo, String roleName) {
		UserRole userRole = new UserRole(userNo, roleName);
		userMapper.insertUserRole(userRole);
	}
	
}
