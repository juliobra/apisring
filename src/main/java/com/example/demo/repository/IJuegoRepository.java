

package com.example.demo.repository;

import com.example.demo.entity.Juego;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IJuegoRepository extends JpaRepository <Juego , Integer>{
    
    public Optional<Juego> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);
    
    public Optional<Juego> findByEmpresa(String empresa);
}
