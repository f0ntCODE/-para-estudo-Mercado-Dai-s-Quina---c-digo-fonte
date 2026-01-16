package edu.squina.daisquina.servicos.mercadoria;

import org.springframework.stereotype.Service;

import edu.squina.daisquina.entidades.mercadoria.Categoria;
import edu.squina.daisquina.repositorios.mercadoria.CategoriaRepo;

@Service
public class MercadoriaService {
    
    private CategoriaRepo categoriaRepo;

    public MercadoriaService(CategoriaRepo categoriaRepo){

        this.categoriaRepo = categoriaRepo;
    }

    /**
     * Criar uma nova categoria para o produto
     * @param nomeCategoria O nome da nova categoria a ser registrada
     * @return O objeto categoria criado
     */
    public Categoria registrarNovaCategoria(String nomeCategoria){
        Categoria categoria = new Categoria();
        categoria.setNomeCategoria(nomeCategoria); 

        return categoriaRepo.save(categoria);

    }
}
