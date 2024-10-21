package com.PedidosGestion.PedidosGestion.prototype;

import com.PedidosGestion.PedidosGestion.models.Pedido;

import java.util.HashMap;
import java.util.Map;

public class RegistryPrototype {
    private static Map<Long, Copiable> registry = new HashMap<>();

    public static void AddPrototype(Pedido pedido) { registry.put(pedido.getId(), pedido);}

    public static Pedido GetPrototype(long id) { return (Pedido) registry.get(id).deepClone();}
}
