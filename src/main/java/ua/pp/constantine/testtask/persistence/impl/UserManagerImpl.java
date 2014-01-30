package ua.pp.constantine.testtask.persistence.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.pp.constantine.testtask.persistence.api.UserDAO;
import ua.pp.constantine.testtask.persistence.api.UserManager;
import ua.pp.constantine.testtask.persistence.model.User;

@Service
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserDAO userDao;

	@Override
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
