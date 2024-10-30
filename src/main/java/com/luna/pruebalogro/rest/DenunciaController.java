package com.luna.pruebalogro.rest;

import java.util.List;

import com.luna.pruebalogro.dto.DenunciaDto;
import com.luna.pruebalogro.util.WrapperResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import com.luna.pruebalogro.entity.Denuncia;
import com.luna.pruebalogro.service.DenunciaService;
import com.luna.pruebalogro.converter.DenunciaConverter;

@RestController
@RequestMapping("/v1/denuncias")
public class DenunciaController {
    @Autowired
    private DenunciaService service;

    @Autowired
    private DenunciaConverter converter;

    @GetMapping
    public ResponseEntity<List<DenunciaDto>> findAll(
            @RequestParam(value = "offset", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(value = "limit", required = false, defaultValue = "5") int pageSize
    ) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        List<DenunciaDto> denuncias = converter.fromEntity(service.findAll());
//        return ResponseEntity.ok(categorias);
        return new WrapperResponse(true, "success", denuncias).createResponse(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DenunciaDto> create (@RequestBody DenunciaDto denuncia) {
        Denuncia entity = converter.fromDTO(denuncia);
        DenunciaDto dto = converter.fromEntity(service.save(entity));
//        return ResponseEntity.ok(dto);
        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DenunciaDto> update (@PathVariable("id") int id, @RequestBody DenunciaDto denuncia) {
        Denuncia entity = converter.fromDTO(denuncia);
        DenunciaDto dto = converter.fromEntity(service.save(entity));
//        return ResponseEntity.ok(dto);
        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete (@PathVariable("id") int id) {
        service.delete(id);
//        return ResponseEntity.ok(null);
        return new WrapperResponse(true, "success", null).createResponse(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DenunciaDto> findById (@PathVariable("id") int id) {
        DenunciaDto dto = converter.fromEntity(service.findById(id));

//        return ResponseEntity.ok(dto);
        return new WrapperResponse(true, "success", dto).createResponse(HttpStatus.OK);
    }
}
