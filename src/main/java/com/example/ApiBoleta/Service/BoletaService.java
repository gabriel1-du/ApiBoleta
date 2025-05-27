package com.example.ApiBoleta.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ApiBoleta.Model.Boleta;
import com.example.ApiBoleta.Repository.BoletaRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class BoletaService {

    //Inyecciion del repositorio
    @Autowired
    private BoletaRepository boletaRepository;


    //Obtener todas las boletas de la base de datos
    public List<Boleta> getall(){
        return boletaRepository.findAll();
    }

    
    //Buscar por id la boleta
    public Boleta getById(Integer boletaId) {
        Optional<Boleta> boleta = boletaRepository.findById(boletaId); // Busca por ID
        return boleta.orElse(null); // Si no la encuentra, retorna null
    }

    //Crear una boleta
    public Boleta add(Boleta boleta) {
        return boletaRepository.save(boleta);
    }


    //ACTUALIZAR una BOLETA existente
    public Boleta update(Integer boletaId, Boleta boleta) {
        if (boletaRepository.existsById(boletaId)) {
            boleta.setId(boletaId); // Aseguramos que se use el mismo ID
            return boletaRepository.save(boleta); // Guarda los cambios
        }
        return null; // No se encontró pedido
    }//opcional : Averiguar como dejar un mensaje escrito 

    
    //Eliminar una tabla
    public Boleta delete(Integer boletaId){
        Optional<Boleta> boleta = boletaRepository.findById(boletaId);
        if (boleta.isPresent()) {
            boletaRepository.deleteById(boletaId); // Elimina la PEDIDO
            return boleta.get(); // Retorna PEDIDO eliminada
        }
        return null; // No existe El pedido
    }//opcional : Averiguar

}

    
