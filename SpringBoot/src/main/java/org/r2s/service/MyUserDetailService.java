package org.r2s.service;

import org.r2s.dao.UserRepository;
import org.r2s.model.User;
import org.r2s.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUserName(username);
		if (user == null)
			throw new UsernameNotFoundException("User 404");
		return new UserPrincipal(user);
	}

}
