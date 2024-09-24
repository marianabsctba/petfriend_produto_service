package infnet.edu.petfriends_produto_service.application;

import infnet.edu.petfriends_produto_service.domain.events.ProdutoCreatedEvent;
import infnet.edu.petfriends_produto_service.domain.model.Produto;
import infnet.edu.petfriends_produto_service.infrastructure.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto criarProduto(String nome, double preco) {
        Produto produto = Produto.builder()
                .nome(nome)
                .preco(preco)
                .build();
        Produto savedProduto = produtoRepository.save(produto);
        eventPublisher.publishEvent(new ProdutoCreatedEvent(savedProduto.getId(), "Produto criado"));
        return savedProduto;
    }
}
