package com.example.demo.models.service;

import java.util.List;


import com.example.demo.models.entity.Turnos;

public interface ITurnosService {
	public void save(Turnos turnos);
	public Turnos findById(long id);
	public List<Turnos> findAll();
	List<Turnos> findByClienteId(Long clienteId);
	void deleteById(long id);
}
