package edu.squina.daisquina.servicos.mercadoria;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import edu.squina.daisquina.dto.categoria.CategoriaDTO;
import edu.squina.daisquina.entidades.mercadoria.Categoria;
import edu.squina.daisquina.entidades.mercadoria.Crud;
import edu.squina.daisquina.mapstruct.CategoriaMapper;
import edu.squina.daisquina.repositorios.mercadoria.CategoriaRepo;
import jakarta.transaction.Transactional;

@Service
public class CategoriaService implements Crud<CategoriaDTO>{
    
    private  CategoriaRepo categoriaRepo;
    private  CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepo categoriaRepo, CategoriaMapper categoriaMapper){

        this.categoriaRepo = categoriaRepo;
        this.categoriaMapper = categoriaMapper;
    }

    /**
     * Criar uma nova categoria para o produto
     * @param nomeCategoria O nome da nova categoria a ser registrada
     * @return O objeto categoria criado
     */
    @Override
    @Transactional
    public CategoriaDTO criar(CategoriaDTO dto) {

          Categoria categoria = categoriaMapper.paraEntidade(dto);
        System.out.println("Categoria " + dto.getNomeCategoria() + " adicionada");
        

        return categoriaMapper.paraDTO(categoriaRepo.save(categoria));
    }

    @Override
    @Transactional
    public CategoriaDTO editar(UUID id, CategoriaDTO dto) {
        try{
            Categoria categoria = categoriaRepo.findById(id)
            .orElseThrow();

            if(!dto.getNomeCategoria().equals(categoria.getNomeCategoria())){
                categoria.setNomeCategoria(dto.getNomeCategoria());
                
                System.out.println("Categoria mudada para " + dto.getNomeCategoria());
                
                return categoriaMapper.paraDTO(categoriaRepo.save(categoria));

            }else{
                System.out.println("O nome da categoria não foi mudado: sem alteração");
                return categoriaMapper.paraDTO(categoria);
            }
                   
        }catch(Exception ex){
            System.err.println("PROBLEMA AO EDITAR OS DADOS DA CATEGORIA: " + ex.getMessage());
            
            throw ex;
        }

    }

    @Override
    @Transactional
    public void excluir(UUID id) {

        Categoria categoria = categoriaRepo.findById(id)
        .orElseThrow();

        if(categoria == null){
            System.out.println("CATEGORIA NÃO ENCONTRADA");
            
            return;
        }

        //desassociar categoria de mercadorias existentes


        categoriaRepo.delete(categoria);
    }

    @Override
    @Transactional
    public List<CategoriaDTO> listarTodos() {

        return categoriaRepo.findAll()
        .stream()
        .map(categoriaMapper :: paraDTO)
        .collect(Collectors.toList());

    }

    //auxiliadores
    @Transactional
    public Categoria getCategoriaByNome(String nome){
        Categoria categoria = categoriaRepo.findByNomeCategoria(nome)
        .orElseThrow();

        return categoria;
    }
    
}
