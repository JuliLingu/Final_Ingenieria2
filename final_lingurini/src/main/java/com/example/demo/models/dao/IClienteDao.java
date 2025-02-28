package com.example.demo.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Clientes;

public interface IClienteDao extends CrudRepository<Clientes,Long> {

}
