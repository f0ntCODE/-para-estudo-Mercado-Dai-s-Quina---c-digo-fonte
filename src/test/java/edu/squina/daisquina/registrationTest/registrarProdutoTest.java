package edu.squina.daisquina.registrationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import edu.squina.daisquina.entidades.mercadoria.Categoria;
import edu.squina.daisquina.servicos.mercadoria.MercadoriaService;

@SpringBootTest
@ActiveProfiles("test")
public class registrarProdutoTest {

    @Autowired
    private MercadoriaService mercadoriaService;

    @Test
    void test(){
        System.out.println("Sou um teste de implementação");
    }

    @Test
    @DisplayName("CATEGORIA DEVE SER REGISTRADA COM SUCESSO")
    public void RegistarMercadoria(){
        
        String nomeCategoria = "Cozinha";
        
        Categoria categoria = mercadoriaService.registrarNovaCategoria(nomeCategoria);

        assertEquals(nomeCategoria, categoria.getNomeCategoria());
    }


}
