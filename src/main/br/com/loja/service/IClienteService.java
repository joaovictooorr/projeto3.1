package br.com.loja.service;

import br.com.loja.domain.Cliente;
import br.com.loja.excptions.DAOException;
import br.com.loja.generic.service.IGenericService;

public interface IClienteService extends IGenericService<Cliente, Long> {
    Cliente buscarPorCPF(Long cpf) throws DAOException;
}
