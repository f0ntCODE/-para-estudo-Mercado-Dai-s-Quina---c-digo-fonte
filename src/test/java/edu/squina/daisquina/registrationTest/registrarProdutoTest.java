package edu.squina.daisquina.registrationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import edu.squina.daisquina.dto.categoria.CategoriaDTO;
import edu.squina.daisquina.entidades.mercadoria.Categoria;
import edu.squina.daisquina.servicos.mercadoria.CategoriaService;

@SpringBootTest
@ActiveProfiles("test")
public class registrarProdutoTest {

    @Autowired
    private CategoriaService categoriaService;
    
    @Test
    void test(){
        System.out.println("Sou um teste de implementação");
    }

    @Test
    @DisplayName("CATEGORIA DEVE SER REGISTRADA COM SUCESSO")
    public void registrarCategoria(){
        
        CategoriaDTO categoria = new CategoriaDTO("Cozinha");

        Categoria retorno = categoriaService.criar(categoria);

        assertEquals(retorno.getNomeCategoria(), categoria.getNomeCategoria());
    }

    @Test
    @DisplayName("EDIÇÃO DA CATEGORIA DEVE DAR CERTO")
    public void editarNomeCategoria(){
        CategoriaDTO categoria = new CategoriaDTO("Sala");

        Categoria retorno = categoriaService.criar(categoria);

        categoria.setNomeCategoria("cozinha");

        retorno = categoriaService.editar(retorno.getId(), categoria);

        assertEquals(retorno.getNomeCategoria(), "cozinha");

    }


}
