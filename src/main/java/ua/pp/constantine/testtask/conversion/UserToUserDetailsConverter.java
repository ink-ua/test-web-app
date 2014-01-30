package ua.pp.constantine.testtask.conversion;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import ua.pp.constantine.testtask.persistence.model.User;
import ua.pp.constantine.testtask.security.UserDetailsImpl;

@Service
public class UserToUserDetailsConverter implements Converter<User, UserDetails> {

	@Override
	public UserDetails convert(User user) {
		return new UserDetailsImpl(user.getUsername(), user.getPasswordHash());
	}

}
