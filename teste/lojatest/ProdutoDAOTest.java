package lojatest;

import br.com.loja.dao.IProdutoDAO;
import br.com.loja.dao.ProdutoDAO;
import br.com.loja.domain.Produto;
import br.com.loja.excptions.DAOException;
import br.com.loja.excptions.MaisDeUmRegistroException;
import br.com.loja.excptions.TableException;
import br.com.loja.excptions.TipoChaveNaoEncontradaException;
import org.junit.After;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;

import static org.junit.Assert.*;

public class ProdutoDAOTest {
    private IProdutoDAO produtoDao;

    public ProdutoDAOTest() {
        produtoDao = new ProdutoDAO();
    }

    @After
    public void end() throws Exception {
        Collection<Produto> list = produtoDao.buscarTodos();
        list.forEach(prod -> {
            try {
                produtoDao.excluir(prod.getCodigo());
            } catch (DAOException e) {
                e.printStackTrace();
            }
        });
    }



    @Test
    public void pesquisar() throws MaisDeUmRegistroException, TableException, DAOException, TipoChaveNaoEncontradaException {
        Produto produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
        produto.setLocal("brasilia");
        produtoDao.cadastrar(produto);
        assertNotNull(produto);

        Produto produtoConsultado = this.produtoDao.consultar(produto.getCodigo());
        assertNotNull(produtoConsultado);

        produtoDao.excluir(produto.getCodigo());
    }

    @Test
    public void salvar() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
        Produto produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
        produto.setLocal("brasilia");
        Boolean retorno = produtoDao.cadastrar(produto);
        assertTrue(retorno);

        Produto produtoConsultado = produtoDao.consultar(produto.getCodigo());
        assertNotNull(produtoConsultado);

        produtoDao.excluir(produto.getCodigo());

    }

    @Test
    public void excluir() throws DAOException, TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException {
        Produto produto = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
        produto.setLocal("brasilia");
        Boolean retorno = produtoDao.cadastrar(produto);
        assertTrue(retorno);

        Produto produtoConsultado = produtoDao.consultar(produto.getCodigo());
        assertNotNull(produtoConsultado);

        produtoDao.excluir(produto.getCodigo());
    }

    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {    Produto produto = new Produto();
        Produto produto1 = new Produto();
        produto.setCodigo("A1");
        produto.setDescricao("Produto 1");
        produto.setNome("Produto 1");
        produto.setValor(BigDecimal.TEN);
        produto.setLocal("brasilia");
        Boolean retorno = produtoDao.cadastrar(produto);
        assertTrue(retorno);


        Produto produtoConsultado = produtoDao.consultar(produto.getCodigo());
        assertNotNull(produtoConsultado);


        produtoConsultado.setNome("Produto 1 - Alterado");
        produtoConsultado.setDescricao("Descrição Alterada");
        produtoConsultado.setValor(BigDecimal.valueOf(20));
        produtoConsultado.setLocal("Rio de Janeiro");
        produtoDao.alterar(produtoConsultado);


        Produto produtoAlterado = produtoDao.consultar(produtoConsultado.getCodigo());
        assertEquals("Produto 1 - Alterado", produtoAlterado.getNome());
        assertEquals("Descrição Alterada", produtoAlterado.getDescricao());
        assertEquals(0, produtoAlterado.getValor().compareTo(BigDecimal.valueOf(20)));
        assertEquals("Rio de Janeiro", produtoAlterado.getLocal());

        produtoDao.excluir(produtoAlterado.getCodigo());
        Produto produtoExcluido = produtoDao.consultar(produtoConsultado.getCodigo());
        assertNull(produtoExcluido);

    }

    @Test
    public void buscarTodos() throws Exception {
        Produto produto1 = new Produto();
        produto1.setCodigo("A1");
        produto1.setDescricao("Produto 1");
        produto1.setNome("Produto 1");
        produto1.setValor(BigDecimal.TEN);
        produto1.setLocal("brasilia");
        Boolean retorno1 = produtoDao.cadastrar(produto1);
        assertTrue(retorno1);

        Produto produto2 = new Produto();
        produto2.setCodigo("A2");
        produto2.setDescricao("Produto 2");
        produto2.setNome("Produto 2");
        produto2.setValor(BigDecimal.TEN);
        produto2.setLocal("pernambuco");
        Boolean retorno2 = produtoDao.cadastrar(produto2);
        assertTrue(retorno2);

        Collection<Produto> list = produtoDao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());


        for (Produto prod : list) {
            produtoDao.excluir(prod.getCodigo());
        }

        list = produtoDao.buscarTodos();
        assertNotNull(list);
        assertEquals(0, list.size());

    }
}
