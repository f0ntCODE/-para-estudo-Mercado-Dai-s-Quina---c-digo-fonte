package edu.squina.daisquina.dto.categoria;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CategoriaDTO {
    
    @NotBlank(message = "A categoria deve ter um nome")
    private String nomeCategoria;

}
