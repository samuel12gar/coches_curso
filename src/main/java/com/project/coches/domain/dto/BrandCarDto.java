package com.project.coches.domain.dto;

/**
 * Pojo de marca coche
 */
//@Getter @Setter
public class BrandCarDto {

    /**
     * id de la marca coche
     */
    private Integer id;
    /**
     * descripcion de la marca coche
     */
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
