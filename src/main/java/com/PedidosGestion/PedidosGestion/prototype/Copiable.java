package com.PedidosGestion.PedidosGestion.prototype;


public interface Copiable<T> {
    T copiar();
    T deepClone();
}
