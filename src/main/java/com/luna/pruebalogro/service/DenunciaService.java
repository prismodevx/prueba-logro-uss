package com.luna.pruebalogro.service;

import com.luna.pruebalogro.entity.Denuncia;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface DenunciaService{
    public List<Denuncia> findAll(Pageable page);
    public List<Denuncia> findAll();
    public List<Denuncia> finByNombre(String titulo,Pageable page);
    public Denuncia findById(int id);
    public Denuncia save(Denuncia denuncia);
    public void delete(int id);
}