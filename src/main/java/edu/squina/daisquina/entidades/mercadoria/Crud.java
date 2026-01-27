package edu.squina.daisquina.entidades.mercadoria;

import java.util.List;
import java.util.UUID;

public interface Crud<T, DTO> {

    public T criar(DTO dto);

    public T editar(UUID id, DTO dto);

    public void excluir(UUID id);

    public List<T> listarTodos();

}
