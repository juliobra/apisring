package com.example.demo.sevice;

import com.example.demo.entity.Juego;
import com.example.demo.repository.IJuegoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 @Service
 @Transactional
public class JuegoService {
       
     @Autowired
     IJuegoRepository juegorepo;
     
     //create
     
     public void save (Juego juego){
     
          juegorepo.save(juego);
         
     }
     
     
     //read
     public List<Juego> list(){
     
         return juegorepo.findAll();
         
     }
     
     public Optional<Juego> getById (int id){
     
         return juegorepo.findById(id);
     }
     
     public Optional<Juego> getByNombre (String nombre){
     
         return juegorepo.findByNombre(nombre);
     }
     
     public Optional<Juego> getByEmpresa (String empresa){
     
         return juegorepo.findByEmpresa(empresa);
     }
     //update
     
     
     //delete
     
     public void delete (int id){
     
         juegorepo.deleteById(id);
         
     }
     
     public boolean existsById (int id){
     
         return juegorepo.existsById(id);
         
     }
     
     public boolean existsByNombre (String nombre){
     
         return juegorepo.existsByNombre(nombre);
         
     }
     
 }
