package com.example.demo.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Turnos;

public interface ITurnosDao extends CrudRepository<Turnos, Long> {
	List<Turnos> findByClienteId(Long clienteId);
}
