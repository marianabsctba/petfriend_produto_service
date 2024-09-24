package infnet.edu.petfriends_produto_service.interfaces;

import infnet.edu.petfriends_produto_service.application.ProdutoService;
import infnet.edu.petfriends_produto_service.domain.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestParam String nome, @RequestParam double preco) {
        Produto produto = produtoService.criarProduto(nome, preco);
        return ResponseEntity.ok(produto);
    }
}
