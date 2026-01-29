package edu.squina.daisquina.registrationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import edu.squina.daisquina.dto.categoria.CategoriaDTO;
import edu.squina.daisquina.dto.categoria.MercadoriaDTO;
import edu.squina.daisquina.servicos.mercadoria.CategoriaService;
import edu.squina.daisquina.servicos.mercadoria.MercadoriaService;

@SpringBootTest
@ActiveProfiles("test")
public class registrarProdutoTest {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private MercadoriaService mercadoriaService;
    
    @Test
    void test(){
        System.out.println("Sou um teste de implementação");
    }

    @Test
    @DisplayName("CATEGORIA DEVE SER REGISTRADA COM SUCESSO")
    public void registrarCategoria(){

        CategoriaDTO categoria = persisirCategoria();

        CategoriaDTO retorno = categoriaService.criar(categoria);

        assertEquals(retorno.getNomeCategoria(), categoria.getNomeCategoria());
    }

    @Test
    @DisplayName("NOME DA CATEGORIA DEVE SER ALTERADA")
    public void editarNomeCategoria(){
        CategoriaDTO categoria = persisirCategoria();

        CategoriaDTO criada = categoriaService.criar(categoria);

        CategoriaDTO dtoAtualizado = new CategoriaDTO("Sala");

        CategoriaDTO retorno = categoriaService.editar(criada.getId(), dtoAtualizado);

        assertEquals(retorno.getNomeCategoria(), "Sala");

    }

    @Test
    @DisplayName("A MERCADORIA DEVE SER CRIADA")
    public void criarMercadoria(){
        CategoriaDTO categoria = persisirCategoria();
        CategoriaDTO categoriaCriada = categoriaService.criar(categoria);

        String descricao = "Fogão 4 bocas à gás!";
        BigDecimal preco = BigDecimal.valueOf(850.45);

        MercadoriaDTO mercadoria = new MercadoriaDTO("Fogão", descricao, null, preco, categoriaCriada);

        MercadoriaDTO retorno = mercadoriaService.criar(mercadoria);

        assertNotNull(retorno.getId());

    }

    //helper
    private CategoriaDTO persisirCategoria(){
        CategoriaDTO categoriaDTO = new CategoriaDTO("Cozinha");

        return categoriaDTO;
    }


}
