package br.com.blsoft.multitenantdb.multitentantdb.produto;

import java.util.List;

public interface ProdutoService {
    List<Produto> getProdutos();
    Produto getProdutoById(Long id);
    Produto insert(Produto produto);
    void update(Long id, Produto produto);
    void delete(Long id);
}
