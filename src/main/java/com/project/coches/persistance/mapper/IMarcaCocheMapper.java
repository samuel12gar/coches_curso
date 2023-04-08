package com.project.coches.persistance.mapper;

import com.project.coches.domain.pojo.MarcaCochePojo;
import com.project.coches.persistance.entity.MarcaCocheEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma a objetos de MarcaCoche a pojos o entidades
 */
@Mapper(componentModel = "spring")
public interface IMarcaCocheMapper {

    /**
     * Convierte una entidad a un pojo de marca coche
     * @param marcaCocheEntity Entidad a convertir
     * @return Pojo convertido
     */
    @Mapping(source = "id", target ="id")
    MarcaCochePojo toMarcaCochePojo(MarcaCocheEntity marcaCocheEntity);

    /**
     * Convierte un pojo a una entidad de marca coche
     * @param marcaCochePojo Pojo a convertir
     * @return Entity convertido
     */
    @InheritInverseConfiguration
    MarcaCocheEntity toMarcaCocheEntity(MarcaCochePojo marcaCochePojo);

    /**
     * Retorna una lista de marcas coche transformada a pojo de una lista de entidades
     * @param marcaCocheEntityList Entidad a transformar
     * @return Lista transformada
     */
    List<MarcaCochePojo> toMarcasCochePojo(List<MarcaCocheEntity> marcaCocheEntityList);
}
