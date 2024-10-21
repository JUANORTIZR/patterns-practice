package com.PedidosGestion.PedidosGestion.repository;

// PedidoRepository.java
import com.PedidosGestion.PedidosGestion.models.Pedido;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PedidoRepository {

    private List<Pedido> pedidos = new ArrayList<>();
    private long currentId = 1;

    public Pedido save(Pedido pedido) {
        if (pedido.getId() == null) {
            pedido.setId(currentId++);
        } else {
            deleteById(pedido.getId());
        }
        pedidos.add(pedido);
        return pedido;
    }


    public List<Pedido> findAll() {
        return new ArrayList<>(pedidos);
    }


    public Optional<Pedido> findById(Long id) {
        return pedidos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }


    public void deleteById(Long id) {
        pedidos.removeIf(p -> p.getId().equals(id));
    }


    public void deleteAll() {
        pedidos.clear();
    }
}
