package net.learnbook.repository;

import java.util.List;
public interface Repository<E> {
	
	//Precisamos implementar mais metodos basicos de procua.

	public boolean save(E entity);
	
	public boolean update(E entity);
	
	public List<E> list(String className);
	
	public E findById(Integer id);
}
