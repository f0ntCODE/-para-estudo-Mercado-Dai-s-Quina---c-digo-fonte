package edu.squina.daisquina.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import edu.squina.daisquina.dto.categoria.MercadoriaDTO;
import edu.squina.daisquina.entidades.mercadoria.Mercadoria;

@Mapper(componentModel = "spring")
public interface MercadoriaMapper {

    @Mapping(target = "id", ignore = true)
    Mercadoria paraEntidade(MercadoriaDTO dto);
    
    MercadoriaDTO paraDTO(Mercadoria mercadoria);
}
