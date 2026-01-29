package edu.squina.daisquina.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.squina.daisquina.dto.categoria.CategoriaDTO;
import edu.squina.daisquina.entidades.mercadoria.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mapping(target = "id", ignore = true)
    Categoria paraEntidade(CategoriaDTO dto);

    CategoriaDTO paraDTO(Categoria categoria);

    

}
