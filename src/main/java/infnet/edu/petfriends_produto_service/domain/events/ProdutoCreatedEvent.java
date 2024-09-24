package infnet.edu.petfriends_produto_service.domain.events;

import lombok.Getter;

@Getter
public class ProdutoCreatedEvent {
    private final Long produtoId;
    private final String eventType;

    public ProdutoCreatedEvent(Long produtoId, String eventType) {
        this.produtoId = produtoId;
        this.eventType = eventType;
    }
}
