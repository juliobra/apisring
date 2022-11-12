package com.example.demo.dto;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Juegodto implements Serializable {
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String plataformaConsola;
    
    @NotBlank
    private String empresa;
    
    @NotBlank
    private int anio;
    
    @NotBlank
    private boolean mundoAbierto;

}
