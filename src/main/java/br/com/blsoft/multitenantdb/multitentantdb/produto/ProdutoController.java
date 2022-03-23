package br.com.blsoft.multitenantdb.multitentantdb.produto;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProdutos() {
        List<Produto> produto = produtoService.getProdutos();
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @GetMapping({"/{produtoId}"})
    public ResponseEntity<Produto> getProduto(@PathVariable Long produtoId) {
        return new ResponseEntity<>(produtoService.getProdutoById(produtoId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Produto> saveProduto(@RequestBody Produto pProduto) {
        Produto produto = produtoService.insert(pProduto);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @PutMapping({"/{produtoId}"})
    public ResponseEntity<Produto> updateProduto(@PathVariable("produtoId") Long produtoId, @RequestBody Produto produto) {
        produtoService.update(produtoId, produto);
        return new ResponseEntity<>(produtoService.getProdutoById(produtoId), HttpStatus.OK);
    }

    @DeleteMapping({"/{produtoId}"})
    public ResponseEntity<Produto> deleteProduto(@PathVariable("produtoId") Long produtoId) {
        produtoService.delete(produtoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
