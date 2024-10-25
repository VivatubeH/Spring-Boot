package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.UserRegisterForm;
import com.example.demo.exception.AlreadyUserEmailException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.vo.User;
import com.example.demo.vo.UserRole;

@Service
@Transactional
public class UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 신규 사용자 정보를 전달받아서 회원가입시키는 서비스다.
	 * @param form 
	 */
	public void addNewUser(UserRegisterForm form) {
		// 이메일 중복 체크
		User savedUser = userMapper.getUserByEmail(form.getEmail());
		if (savedUser != null) {
			throw new AlreadyUserEmailException(form.getEmail());
		}
		
		User user = new User();
		// form에 있는 멤버변수를 user에 복사한다. [ modelMapper 말고 다른 방법 ]
		BeanUtils.copyProperties(form, user);
		// User -> {no=0, email=hong@gmail.com, password=zxcv1234, ....}
		
		// 비밀번호를 암호화한다.
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		// 회원정보를 테이블에 저장시킨다.
		userMapper.insertUser(user);
		// User -> {no=23, email=hong@gmail.com, password=zxcv1234, ....}
		
		addUserRole(user.getNo(), "ROLE_USER"); // 쪼갤거면 트랜잭션이 시작된 곳에서 호출해야함.
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
