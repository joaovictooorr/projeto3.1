package br.com.loja.generic.service;

import br.com.loja.excptions.DAOException;
import br.com.loja.excptions.TipoChaveNaoEncontradaException;
import br.com.loja.generic.DAO.Persistente;

import java.io.Serializable;
import java.util.Collection;

public interface IGenericService <T extends Persistente, E extends Serializable> {
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    public void excluir(E valor) throws DAOException;
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;
    public T consultar(E valor) throws DAOException;
    public Collection<T> buscarTodos() throws Exception;
}
