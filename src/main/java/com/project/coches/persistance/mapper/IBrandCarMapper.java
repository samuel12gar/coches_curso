package com.project.coches.persistance.mapper;

import com.project.coches.domain.pojo.BrandCarPojo;
import com.project.coches.persistance.entity.BrandCarEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Mapper que transforma a objetos de MarcaCoche a pojos o entidades
 */
@Mapper(componentModel = "spring")
public interface IBrandCarMapper {

    /**
     * Convierte una entidad a un pojo de marca coche
     * @param marcaCocheEntity Entidad a convertir
     * @return Pojo convertido
     */
    @Mapping(source = "id", target ="id")
    @Mapping(source = "descripcion", target ="descripcion")
    BrandCarPojo toMarcaCochePojo(BrandCarEntity marcaCocheEntity);

    /**
     * Convierte un pojo a una entidad de marca coche
     * @param marcaCochePojo Pojo a convertir
     * @return Entity convertido
     */
    @InheritInverseConfiguration
    BrandCarEntity toMarcaCocheEntity(BrandCarPojo marcaCochePojo);

    /**
     * Retorna una lista de marcas coche transformada a pojo de una lista de entidades
     * @param marcaCocheEntityList Entidad a transformar
     * @return Lista transformada
     */
    List<BrandCarPojo> toMarcasCochePojo(List<BrandCarEntity> marcaCocheEntityList);
}
