package com.PedidosGestion.PedidosGestion.service.factory;


public final class ProductoFactorySingleton {

    private static ProductoFactorySingleton instance;

    private ProductoFactorySingleton() {

    }

    public IProductoFactory crearProducto(String tipo) {
        switch (tipo) {
            case "Electronico":
                return new ElectronicoFactory();
            case "Ropa":
                return new RopaFactory();
            default:
                throw new IllegalArgumentException("Tipo de producto no soportado.");
        }
    }

    public static ProductoFactorySingleton getInstance() {
        if (instance == null) {
            instance = new ProductoFactorySingleton();
        }
        return instance;
    }
}
