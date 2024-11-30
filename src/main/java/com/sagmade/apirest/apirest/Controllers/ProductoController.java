package com.sagmade.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sagmade.apirest.apirest.Entities.Products;
import com.sagmade.apirest.apirest.Repositories.ProductoRepository;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    @GetMapping
    public List<Products> getAllProducts(){
        return productoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Products getProductById(@PathVariable("id") Long Id){
        return productoRepository.findById(Id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto: " + Id));
    }

    @PostMapping
    public Products createProducts(@RequestBody Products product){
        return productoRepository.save(product);
    }

    @PutMapping("/{id}")
    public Products updateProduct(@PathVariable("id") Long Id, @RequestBody Products product){
        Products producto = productoRepository.findById(Id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto: " + Id));

        producto.setNombre(product.getNombre());
        producto.setPrecio(product.getPrecio());

        return productoRepository.save(producto);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long Id){
        Products producto = productoRepository.findById(Id)
        .orElseThrow(() -> new RuntimeException("No se encontro el producto: " + Id));

        productoRepository.delete(producto);
        return "El producto con el id " + Id + " ha sido eliminado satisfactoriamente";
    }
}
