package com.example.ApiBoleta.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ApiBoleta.Model.Boleta;
import com.example.ApiBoleta.Service.BoletaService;

@Controller
@RequestMapping("/api/Boleta")
@RestController
public class BoletaController {

    //Inyeccion de BoletaRepository
    private BoletaService boletaService;

    //Para obtener todas las boletas
    @GetMapping("/")
    public ResponseEntity<List<Boleta>> getAll(){
        return ResponseEntity.ok(boletaService.getall());
    }


    //Buscar por id de boleta
    @GetMapping("/{boletaId}")
       public ResponseEntity<?> getById(@PathVariable Integer boletaId) {
        Boleta boleta = boletaService.getById(boletaId);
        if (boleta != null) {
            return ResponseEntity.ok(boleta);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Boleta no encontrada");
        }
    }


    //Crear un pedido
    @PostMapping
    public ResponseEntity<?> add(@RequestBody Boleta boleta) {
        Boleta nuevo = boletaService.add(boleta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    //Actualizar una boleta ya existente
    @PutMapping("/{boletaId}")
    public ResponseEntity<?> update(@PathVariable Integer boletaId, @RequestBody Boleta boleta) {
        Boleta actualizado = boletaService.update(boletaId, boleta);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Boleta no encontrado para actualizar");
        }
    }

    //Eliminar una boleta
    @DeleteMapping("/{boletaId}")
    public ResponseEntity<?> delete(@PathVariable Integer boletaId) {
        Boleta eliminado = boletaService.delete(boletaId);
        if (eliminado != null) {
            return ResponseEntity.ok(eliminado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Boleta no encontrada para eliminar");
        }
    }




}
