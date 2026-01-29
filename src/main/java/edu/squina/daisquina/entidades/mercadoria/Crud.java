package edu.squina.daisquina.entidades.mercadoria;

import java.util.List;
import java.util.UUID;

public interface Crud<T> {

    public T criar(T dto);

    public T editar(UUID id, T dto);

    public void excluir(UUID id);

    public List<T> listarTodos();

}
