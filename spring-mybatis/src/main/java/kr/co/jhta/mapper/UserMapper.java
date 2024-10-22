package kr.co.jhta.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.jhta.vo.User;

@Mapper
public interface UserMapper {
	
	List<User> searchUsers(@Param("col") String column,
						   @Param("val") Object value);
	
	void insertUser(@Param("user") User user);
	void insertUserRole(@Param("no") int userNo, @Param("rolename") String rolename);
	
	User getUserById(@Param("id") String id);
	User getUserByNo(@Param("no") int no);
	List<User> getUsersByName(@Param("name") String name);
	
	List<User> getAllUsers();
}
