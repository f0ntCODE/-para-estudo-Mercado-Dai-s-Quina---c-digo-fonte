package edu.squina.daisquina.mapstruct;

import edu.squina.daisquina.dto.categoria.CategoriaDTO;
import edu.squina.daisquina.dto.categoria.MercadoriaDTO;
import edu.squina.daisquina.entidades.mercadoria.Categoria;
import edu.squina.daisquina.entidades.mercadoria.Mercadoria;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-29T19:08:21-0300",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.45.0.v20260101-2150, environment: Java 21.0.9 (Eclipse Adoptium)"
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
        mercadoria.setCategoria( categoriaDTOToCategoria( dto.getCategoria() ) );

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
        CategoriaDTO categoria = null;

        nome = mercadoria.getNome();
        descricao = mercadoria.getDescricao();
        imagem = mercadoria.getImagem();
        preco = mercadoria.getPreco();
        categoria = categoriaToCategoriaDTO( mercadoria.getCategoria() );

        MercadoriaDTO mercadoriaDTO = new MercadoriaDTO( nome, descricao, imagem, preco, categoria );

        mercadoriaDTO.setId( mercadoria.getId() );

        return mercadoriaDTO;
    }

    protected Categoria categoriaDTOToCategoria(CategoriaDTO categoriaDTO) {
        if ( categoriaDTO == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setId( categoriaDTO.getId() );
        categoria.setNomeCategoria( categoriaDTO.getNomeCategoria() );

        return categoria;
    }

    protected CategoriaDTO categoriaToCategoriaDTO(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        String nomeCategoria = null;

        nomeCategoria = categoria.getNomeCategoria();

        CategoriaDTO categoriaDTO = new CategoriaDTO( nomeCategoria );

        categoriaDTO.setId( categoria.getId() );

        return categoriaDTO;
    }
}
