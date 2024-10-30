package com.luna.pruebalogro.service.impl;

import java.util.List;

import com.luna.pruebalogro.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luna.pruebalogro.entity.Denuncia;
import com.luna.pruebalogro.exception.GeneralException;
import com.luna.pruebalogro.exception.NoDataFoundException;
import com.luna.pruebalogro.exception.ValidateException;
import com.luna.pruebalogro.service.DenunciaService;
import com.luna.pruebalogro.validator.DenunciaValidator;

@Service("denunciaservice")
public class DenunciaServiceImpl implements DenunciaService {
    @Autowired
    private DenunciaRepository repository;


    @Override
    @Transactional(readOnly = true)
    public List<Denuncia> findAll(Pageable page) {
        try {
            List<Denuncia> registros=repository.findAll(page).toList();
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        }
        catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Denuncia> finByNombre(String titulo, Pageable page) {
        try {
            List<Denuncia> registros=repository.findByTituloContaining(titulo,page);
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        }
        catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Denuncia findById(int id) {
        try {
            Denuncia registro=repository.findById(id).
                    orElseThrow(()->new NoDataFoundException("No existe un registro con ese ID"));
            return registro;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        }
        catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional
    public Denuncia save(Denuncia evento) {
        try {

            DenunciaValidator.save(evento);
            //Nuevo registro
            if (evento.getId()==0) {
                Denuncia nuevo=repository.save(evento);
                return nuevo;
            }
            //editar registro
            Denuncia registro=repository.findById(evento.getId()).orElseThrow(()->new NoDataFoundException("No existe un registro con ese ID"));
            registro.setTitulo(evento.getTitulo());
            registro.setDescripcion(evento.getDescripcion());
            registro.setUbicacion(evento.getUbicacion());
            registro.setEstado(evento.getEstado());
            registro.setCiudadano(evento.getCiudadano());
            registro.setTelefono_ciudadano(evento.getTelefono_ciudadano());
            registro.setFecha_registro(evento.getFecha_registro());
            repository.save(registro);
            return registro;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        }
        catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }

    @Override
    @Transactional
    public void delete(int id) {
        try {
            Denuncia registro=repository.findById(id).orElseThrow(()->new NoDataFoundException("No existe un registro con ese ID"));
            repository.delete(registro);
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        }
        catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }

    }

    @Override
    @Transactional(readOnly = true)
    public List<Denuncia> findAll() {
        try {
            List<Denuncia> registros=repository.findAll();
            return registros;
        } catch (ValidateException | NoDataFoundException e) {
            throw e;
        }
        catch (GeneralException e) {
            throw new GeneralException("Error del servidor");
        }
    }
}
