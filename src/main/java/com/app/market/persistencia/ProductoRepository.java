package com.app.market.persistencia;

import com.app.market.persistencia.crud.ProductoCrudRepository;
import com.app.market.persistencia.entities.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrdeByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<List<Producto>> getProductoByPrecioVentaLessThanPriceAndByCategory (int precioVenta, int idCategoria) {
        return productoCrudRepository.findByPrecioVentaLessThanAndIdCategoriaOrderByNombreAsc(precioVenta, idCategoria);
    }
}
