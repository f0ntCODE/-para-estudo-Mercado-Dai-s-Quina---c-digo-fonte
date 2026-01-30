package edu.squina.daisquina.servicos.mercadoria;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import edu.squina.daisquina.dto.categoria.MercadoriaDTO;
import edu.squina.daisquina.entidades.mercadoria.Categoria;
import edu.squina.daisquina.entidades.mercadoria.Crud;
import edu.squina.daisquina.entidades.mercadoria.Mercadoria;
import edu.squina.daisquina.mapstruct.MercadoriaMapper;
import edu.squina.daisquina.repositorios.mercadoria.CategoriaRepo;
import edu.squina.daisquina.repositorios.mercadoria.MercadoriaRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class MercadoriaService implements Crud<MercadoriaDTO>{

    private final MercadoriaRepo mercadoriaRepo;
    private final MercadoriaMapper mercadoriaMapper;
    private final CategoriaRepo categoriaRepo;

    public MercadoriaService(MercadoriaRepo mercadoriaRepo,
                             MercadoriaMapper mercadoriaMapper,
                             CategoriaRepo categoriaRepo
    ){
        this.mercadoriaRepo = mercadoriaRepo;
        this.mercadoriaMapper = mercadoriaMapper;
        this.categoriaRepo = categoriaRepo;

    }

    @Override
    public MercadoriaDTO criar(MercadoriaDTO dto) {
        Mercadoria mercadoria = mercadoriaMapper.paraEntidade(dto);
        
        System.out.println("Mercadoria " + dto.getNome() + " adicionada com sucesso!");

        return mercadoriaMapper.paraDTO(mercadoriaRepo.save(mercadoria));
        
    }

    @Override
    @Transactional
    public MercadoriaDTO editar(UUID id, MercadoriaDTO dto) {
        try{
            Mercadoria mercadoria = mercadoriaRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("A mercadoria em questão não foi encontrada"));


            if(!dto.getNome().equals(mercadoria.getNome())){
                mercadoria.setNome(dto.getNome());
            
            }
            
            if(!dto.getPreco().equals(mercadoria.getPreco())){
                mercadoria.setPreco(dto.getPreco());
            
            }
            
            if(!dto.getDescricao().equals(mercadoria.getDescricao())){
                mercadoria.setDescricao(dto.getDescricao());
            
            }
            
            if(!dto.getCategoriaId().equals(null)){
                Categoria categoria = categoriaRepo.findById(dto.getCategoriaId())
                .orElseThrow(() -> new EntityNotFoundException("Categoria inválida"));

                mercadoria.setCategoria(categoria);

            }
            
            if(!dto.getImagem().equals(mercadoria.getImagem())){
                mercadoria.setImagem(dto.getImagem());
            }

            return mercadoriaMapper.paraDTO(mercadoria);

        }catch(Exception ex){
            System.err.println("Ocorreu um problema ao editar os dados da mercadoria: ");
            throw ex;

        }

    }

    @Override
    public void excluir(UUID id) {

       

    }

    @Override
    public List<MercadoriaDTO> listarTodos() {
        
        return mercadoriaRepo.findAll()
        .stream()
        .map(mercadoriaMapper :: paraDTO)
        .collect(Collectors.toList());
        
    }

    

}
