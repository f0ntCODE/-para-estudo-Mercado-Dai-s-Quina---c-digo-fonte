package edu.squina.daisquina.controladores.admin.registros;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.squina.daisquina.dto.categoria.CategoriaDTO;
import edu.squina.daisquina.entidades.mercadoria.Categoria;
import edu.squina.daisquina.servicos.mercadoria.CategoriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/criar")
    public ResponseEntity<Categoria> criar(@Valid @RequestBody CategoriaDTO categoriaDTO){

        return ResponseEntity.ok(categoriaService.criar(categoriaDTO));
    }

    @PatchMapping("/editar/{id}")
    public ResponseEntity<Categoria> editar(@PathVariable UUID id, 
        @Valid @RequestBody CategoriaDTO categoriaDTO){

        return ResponseEntity.ok(categoriaService.editar(id, categoriaDTO));
    }

}
