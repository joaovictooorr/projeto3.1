package br.com.loja.service;

import br.com.loja.dao.IClienteDAO;
import br.com.loja.domain.Cliente;
import br.com.loja.excptions.DAOException;
import br.com.loja.excptions.MaisDeUmRegistroException;
import br.com.loja.excptions.TableException;
import br.com.loja.generic.service.GenericService;

public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    public ClienteService(IClienteDAO clienteDAO) {
        super(clienteDAO);
    }

    @Override
    public Cliente buscarPorCPF(Long cpf) throws DAOException {
        try {
            return this.dao.consultar(cpf);
        } catch (MaisDeUmRegistroException | TableException e) {
            e.printStackTrace();
        }
        return null;
    }
}
