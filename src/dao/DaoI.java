package dao;

import java.util.List;

public interface DaoI <E> {
	public boolean cadastrar (E obj);
	public boolean deletar (E obj);
	public List<E> listar  (String nome);
	public boolean alterar (E obj);
}
