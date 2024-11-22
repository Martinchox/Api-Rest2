package com.example.inicial1.services;

import com.example.inicial1.entities.Base;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends Base, ID extends Serializable>  {
    public List<E> findAll() throws Exception; //Este metodo trae una lista de todas las entidades que se
    // encuentran en la base de datos
    public Page<E> findAll(Pageable pageable) throws Exception;
    public E findById(ID id) throws Exception; //Este metodo tare una persona o entidad de acuerdo a su id
    public E save(E entity) throws Exception;//Este metodo crea una nueva entidad
    public E update(ID id, E entity) throws Exception;
    public boolean delete(ID id) throws Exception; //elimina un registro de la base de datos

}
