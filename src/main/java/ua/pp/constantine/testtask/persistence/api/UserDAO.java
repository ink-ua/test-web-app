package ua.pp.constantine.testtask.persistence.api;

import ua.pp.constantine.testtask.persistence.model.User;

public interface UserDAO extends CommonDAO<User> {
	User findByUsername(String username);
}
