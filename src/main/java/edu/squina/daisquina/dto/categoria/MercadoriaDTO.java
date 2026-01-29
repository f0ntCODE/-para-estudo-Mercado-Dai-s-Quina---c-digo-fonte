package edu.squina.daisquina.dto.categoria;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MercadoriaDTO {

    @NotNull
    private UUID id;

    @NotBlank(message = "A mercadoria deve ter um nome")
    private String nome;
    
    @NotBlank(message = "A mercadoria deve ter uma descrição")
    private String descricao;
    
    private String imagem;

    @NotNull(message = "A mercadoria deve ter um preço envolvido")
    @Min(1)
    private BigDecimal preco;

    @NotBlank(message = "A mercadoria deve ter uma categoria associada")
    private CategoriaDTO categoria;

    public MercadoriaDTO(String nome,
            String descricao, String imagem,
            BigDecimal preco,
            CategoriaDTO categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.preco = preco;
        this.categoria = categoria;
    }

    


}
