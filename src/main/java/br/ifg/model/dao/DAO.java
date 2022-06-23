package br.ifg.model.dao;

import java.util.List;

public interface DAO<T> {	
	public void insert(T obj);
	public void update(T obj);
	public void deleteById(long id);
	public T findById(long id);
	public List<T> findAll();	
}

