package br.com.loja.service;

import br.com.loja.dao.IProdutoDAO;
import br.com.loja.domain.Produto;
import br.com.loja.generic.service.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {
    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }
}
