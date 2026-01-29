package edu.squina.daisquina.dto.categoria;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoriaDTO {

    @NotNull
    private UUID id;
    
    @NotBlank(message = "A categoria deve ter um nome")
    private String nomeCategoria;

    public CategoriaDTO(String nomeCategoria){
        this.nomeCategoria = nomeCategoria;

    }

}
