package com.luna.pruebalogro.converter;

import com.luna.pruebalogro.dto.DenunciaDto;
import com.luna.pruebalogro.entity.Denuncia;
import org.springframework.stereotype.Component;

@Component

public class DenunciaConverter extends AbstractConverter<Denuncia, DenunciaDto>{

    @Override
    public DenunciaDto fromEntity(Denuncia entity) {
        if (entity == null) return null;
        return DenunciaDto.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .descripcion(entity.getDescripcion())
                .ubicacion(entity.getUbicacion())
                .estado(entity.getEstado())
                .ciudadano(entity.getCiudadano())
                .telefono_ciudadano(entity.getTelefono_ciudadano())
                .fecha_registro(entity.getFecha_registro())
                .build();
    }

    @Override
    public Denuncia fromDTO(DenunciaDto dto) {
        if (dto == null) return null;
        return Denuncia.builder()
                .id(dto.getId())
                .titulo(dto.getTitulo())
                .descripcion(dto.getDescripcion())
                .ubicacion(dto.getUbicacion())
                .estado(dto.getEstado())
                .ciudadano(dto.getCiudadano())
                .telefono_ciudadano(dto.getTelefono_ciudadano())
                .fecha_registro(dto.getFecha_registro())
                .build();
    }
}
