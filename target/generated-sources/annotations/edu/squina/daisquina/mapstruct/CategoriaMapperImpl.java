package edu.squina.daisquina.mapstruct;

import edu.squina.daisquina.dto.categoria.CategoriaDTO;
import edu.squina.daisquina.entidades.mercadoria.Categoria;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-27T17:07:50-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260101-2150, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public Categoria paraEntidade(CategoriaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setNomeCategoria( dto.getNomeCategoria() );

        return categoria;
    }

    @Override
    public CategoriaDTO paraDTO(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        String nomeCategoria = null;

        nomeCategoria = categoria.getNomeCategoria();

        CategoriaDTO categoriaDTO = new CategoriaDTO( nomeCategoria );

        return categoriaDTO;
    }
}
