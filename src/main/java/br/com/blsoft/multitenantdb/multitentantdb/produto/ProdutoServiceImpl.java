package br.com.blsoft.multitenantdb.multitentantdb.produto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    private ProdutoRepository produtosRepository;


    public ProdutoServiceImpl(ProdutoRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }


    @Override
    public List<Produto> getProdutos() {
        List<Produto> produtoss = new ArrayList<>();
        this.produtosRepository.findAll().forEach(produtoss::add);
        return produtoss;
    }

    @Override
    public Produto getProdutoById(Long id) {
        return this.produtosRepository.findById(id).get();
    }

    @Override
    public Produto insert(Produto produtos) {
        return this.produtosRepository.save(produtos);
    }

    @Override
    public void update(Long id, Produto produtos) {
        Produto produtosFromDb = this.produtosRepository.findById(id).get();
        System.out.println(produtosFromDb.toString());
        produtosFromDb.setNome(produtos.getNome());
        produtosFromDb.setPreco(produtos.getPreco());
        produtosRepository.save(produtosFromDb);
    }

    @Override
    public void delete(Long id) {
        this.produtosRepository.deleteById(id);
    }
    
}
