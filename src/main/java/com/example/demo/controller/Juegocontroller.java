package com.example.demo.controller;

import com.example.demo.dto.Juegodto;
import com.example.demo.entity.Juego;
import com.example.demo.sevice.JuegoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/api")
public class Juegocontroller {

    @Autowired
    private JuegoService juegoserv;
    
   //trae toodos los registros de la base de datos
   @GetMapping("/vertodos")
    
    public ResponseEntity<List<Juego>> list (){
            List<Juego> juegos = juegoserv.list();
            return ResponseEntity.status(HttpStatus.OK).body(juegos);
    
}
       
    //traer un juego por id
        @GetMapping("/ver/{id}")
    public ResponseEntity<Juego> getById(@PathVariable("id")int id){
            if(!juegoserv.existsById(id)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
                
            }
            Juego juego = juegoserv.getById(id).get();
            return ResponseEntity.status(HttpStatus.OK).body(juego);
                
    
                } 
    //borrar juego
    @DeleteMapping("/borrar")
    public ResponseEntity<?> delete (@PathVariable("id")int id){
    
        if(juegoserv.existsById(id)){
        
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        juegoserv.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    
    } 
            
    //crear juego
    @PostMapping("/crear")
    public ResponseEntity<?> create (@RequestBody Juegodto dtojuego){
    
        if(StringUtils.isBlank(dtojuego.getNombre())){
        
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else if (juegoserv.existsByNombre(dtojuego.getNombre())){
        
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
        Juego juego = new Juego(dtojuego.getNombre(),dtojuego.getPlataformaConsola(),dtojuego.getEmpresa(),
                dtojuego.getAnio(),dtojuego.isMundoAbierto());
                
                juegoserv.save(juego);
                return ResponseEntity.status(HttpStatus.CREATED).build();
    } 
    //editar un juego
    @PutMapping("/editar/{id}")
        
        public ResponseEntity <?> update(@PathVariable ("id") int id , @RequestBody  Juegodto juegodto){
        if (juegoserv.existsById(id) ){
        
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            
        }
        else if (StringUtils.isBlank(juegodto.getNombre())){
        
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
        else if (juegoserv.existsByNombre(juegodto.getNombre())&& juegoserv.getByNombre(juegodto.getNombre()).get().getId()!=id){
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
              Juego juego = juegoserv.getById(id).get();
              juego.setNombre(juegodto.getNombre());
              juego.setPlataformaConsola(juegodto.getPlataformaConsola());
              juego.setEmpresa(juegodto.getEmpresa());
              juego.setAnio(juegodto.getAnio());
              juego.setMundoAbierto(juegodto.isMundoAbierto());
              
              juegoserv.save(juego);
              
              return ResponseEntity.status(HttpStatus.OK).build();
        }  
    
             }
