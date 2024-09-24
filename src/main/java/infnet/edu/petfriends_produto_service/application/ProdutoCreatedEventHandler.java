package infnet.edu.petfriends_produto_service.application;

import infnet.edu.petfriends_produto_service.domain.events.ProdutoCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProdutoCreatedEventHandler {

    @EventListener
    public void handleProdutoCreatedEvent(ProdutoCreatedEvent event) {
        log.info("Evento de produto criado: ID = " + event.getProdutoId() +
                ", Tipo de Evento = " + event.getEventType());
        enviarNotificacao(event.getProdutoId());
        atualizarCache(event.getProdutoId());
    }

    private void enviarNotificacao(Long produtoId) {
        log.info("Notificação enviada para o produto com ID: " + produtoId);
    }

    private void atualizarCache(Long produtoId) {
        log.info("Cache atualizado para o produto com ID: " + produtoId);
    }
}

