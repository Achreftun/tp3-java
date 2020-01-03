package org.eclipse.dao;

import java.util.List;

// permet de remplacer tous les DAO si on a plusieurs classes

public interface Dao<T> {
	T save(T obj);
	void remove(T obj);
	T update(T obj);
	T findById(int id);
	List<T> getAll();
}
