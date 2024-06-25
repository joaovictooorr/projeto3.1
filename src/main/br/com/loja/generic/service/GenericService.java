package br.com.loja.generic.service;

import br.com.loja.excptions.DAOException;
import br.com.loja.excptions.MaisDeUmRegistroException;
import br.com.loja.excptions.TableException;
import br.com.loja.excptions.TipoChaveNaoEncontradaException;
import br.com.loja.generic.DAO.IGenericDAO;
import br.com.loja.generic.DAO.Persistente;

import java.io.Serializable;
import java.util.Collection;

public abstract class GenericService<T extends Persistente, E extends Serializable> implements IGenericService<T, E> {
    protected IGenericDAO<T,E> dao;

    public GenericService(IGenericDAO<T,E> dao) {
        this.dao = dao;
    }

    @Override
    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(E valor) throws DAOException {
        this.dao.excluir(valor);
    }

    @Override
    public void alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
        this.dao.alterar(entity);
    }

    @Override
    public T consultar(E valor) throws DAOException {
        try {
            return this.dao.consultar(valor);
        } catch (MaisDeUmRegistroException | TableException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Collection<T> buscarTodos() throws Exception {
        return this.dao.buscarTodos();
    }
}
