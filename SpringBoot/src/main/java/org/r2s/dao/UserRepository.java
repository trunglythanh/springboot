package org.r2s.dao;

import org.r2s.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("select user from User user where user.username = :urname")
	User findByUserName(@Param("urname") String username);

	

}
