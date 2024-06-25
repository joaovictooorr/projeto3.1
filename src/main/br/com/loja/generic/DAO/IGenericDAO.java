package br.com.loja.generic.DAO;

import br.com.loja.excptions.DAOException;
import br.com.loja.excptions.MaisDeUmRegistroException;
import br.com.loja.excptions.TableException;
import br.com.loja.excptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericDAO <T extends Persistente, E extends Serializable> {
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    public void excluir(E valor) throws DAOException;
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    public T consultar(E valor) throws MaisDeUmRegistroException, TableException, DAOException;
    public Collection<T> buscarTodos() throws DAOException, Exception;
}
