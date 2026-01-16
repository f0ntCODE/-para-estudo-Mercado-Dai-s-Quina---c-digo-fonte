package edu.squina.daisquina.repositorios.mercadoria;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.squina.daisquina.entidades.mercadoria.Mercadoria;

public interface MercadoriaRepo extends JpaRepository<Mercadoria, UUID> {

}
