package com.dh.clase32.controller;

import com.dh.clase32.entities.Producto;
import com.dh.clase32.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;
    @Autowired
    public ProductoController(ProductoService productoService) {

        this.productoService = productoService;
    }
    @PostMapping
    public ResponseEntity<Producto> registrarProducto(@RequestBody Producto producto){
        return ResponseEntity.ok(productoService.guardar(producto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id){
        if(productoService.buscar(id).isPresent()){
            productoService.borrar(id);
            return ResponseEntity.ok("Se borro el producto");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro el producto con id: "+id);
        }
    }
    @GetMapping("{/id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable Long id){
        Optional<Producto> productoBuscado=productoService.buscar(id);
        if(productoBuscado.isPresent()){
            return ResponseEntity.ok(productoBuscado.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
