package edu.squina.daisquina.mapstruct;

import edu.squina.daisquina.dto.categoria.MercadoriaDTO;
import edu.squina.daisquina.entidades.mercadoria.Mercadoria;
import java.math.BigDecimal;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-30T16:04:56-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260128-0750, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class MercadoriaMapperImpl implements MercadoriaMapper {

    @Override
    public Mercadoria paraEntidade(MercadoriaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Mercadoria mercadoria = new Mercadoria();

        mercadoria.setNome( dto.getNome() );
        mercadoria.setDescricao( dto.getDescricao() );
        mercadoria.setImagem( dto.getImagem() );
        mercadoria.setPreco( dto.getPreco() );

        return mercadoria;
    }

    @Override
    public MercadoriaDTO paraDTO(Mercadoria mercadoria) {
        if ( mercadoria == null ) {
            return null;
        }

        String nome = null;
        String descricao = null;
        String imagem = null;
        BigDecimal preco = null;

        nome = mercadoria.getNome();
        descricao = mercadoria.getDescricao();
        imagem = mercadoria.getImagem();
        preco = mercadoria.getPreco();

        UUID categoriaId = null;

        MercadoriaDTO mercadoriaDTO = new MercadoriaDTO( nome, descricao, imagem, preco, categoriaId );

        mercadoriaDTO.setId( mercadoria.getId() );

        return mercadoriaDTO;
    }
}
