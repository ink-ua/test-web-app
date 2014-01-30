package ua.pp.constantine.testtask.persistence.api;

public interface CommonDAO<T> {
	T save(T object);

	void delete(T object);

	T findByPrimaryKey(Class<T> clazz, Long id);
}
