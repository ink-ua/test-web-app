package ua.pp.constantine.testtask.persistence.api;

import ua.pp.constantine.testtask.persistence.model.User;

public interface UserManager {
	void save(User user);

	User findByUsername(String username);
}
