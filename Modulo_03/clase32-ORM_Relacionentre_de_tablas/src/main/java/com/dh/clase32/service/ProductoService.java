package com.dh.clase32.service;

import com.dh.clase32.entities.Producto;
import com.dh.clase32.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;
    @Autowired
    public ProductoService(ProductoRepository productoRepository) {

        this.productoRepository = productoRepository;
    }
    public Producto guardar (Producto producto){

        return productoRepository.save(producto);
    }

    public Optional <Producto> buscar(Long id){
        // opt_1
        // return productoRepository.findById(id).get();

        // opt_2 - usando Optional
        return productoRepository.findById(id);
    }

    public void  borrar(Long id ){
        productoRepository.deleteById(id);
    }
}
