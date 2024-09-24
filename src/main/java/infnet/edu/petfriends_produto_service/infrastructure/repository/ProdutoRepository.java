package infnet.edu.petfriends_produto_service.infrastructure.repository;

import infnet.edu.petfriends_produto_service.domain.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
