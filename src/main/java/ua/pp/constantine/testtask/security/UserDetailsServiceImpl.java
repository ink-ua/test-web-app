package ua.pp.constantine.testtask.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.pp.constantine.testtask.persistence.api.UserDAO;
import ua.pp.constantine.testtask.persistence.model.User;

@Service("userService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private Converter<User, UserDetails> userConverter;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return userConverter.convert(user);
	}

}
