package edu.squina.daisquina.servicos.mercadoria;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.squina.daisquina.dto.categoria.MercadoriaDTO;
import edu.squina.daisquina.entidades.mercadoria.Crud;
import edu.squina.daisquina.entidades.mercadoria.Mercadoria;
import edu.squina.daisquina.mapstruct.MercadoriaMapper;
import edu.squina.daisquina.repositorios.mercadoria.MercadoriaRepo;

@Service
public class MercadoriaService implements Crud<MercadoriaDTO>{

    private final MercadoriaRepo mercadoriaRepo;
    private final MercadoriaMapper mercadoriaMapper;

    public MercadoriaService(MercadoriaRepo mercadoriaRepo,
                             MercadoriaMapper mercadoriaMapper
    ){
        this.mercadoriaRepo = mercadoriaRepo;
        this.mercadoriaMapper = mercadoriaMapper;

    }

    @Override
    public MercadoriaDTO criar(MercadoriaDTO dto) {
        Mercadoria mercadoria = mercadoriaMapper.paraEntidade(dto);
        
        System.out.println("Mercadoria " + dto.getNome() + " adicionada com sucesso!");

        return mercadoriaMapper.paraDTO(mercadoriaRepo.save(mercadoria));
        
    }

    @Override
    public MercadoriaDTO editar(UUID id, MercadoriaDTO dto) {
        
    }

    @Override
    public void excluir(UUID id) {
       

    }

    @Override
    public List<MercadoriaDTO> listarTodos() {
        
    }

    

}
