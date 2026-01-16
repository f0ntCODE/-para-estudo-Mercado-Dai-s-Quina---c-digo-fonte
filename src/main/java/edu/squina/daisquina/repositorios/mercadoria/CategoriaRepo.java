package edu.squina.daisquina.repositorios.mercadoria;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.squina.daisquina.entidades.mercadoria.Categoria;

public interface CategoriaRepo extends JpaRepository<Categoria, UUID>{

    Optional<Categoria> findByNomeCategoria(String nomeCategoria);

}
