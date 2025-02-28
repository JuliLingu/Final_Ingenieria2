package com.example.demo.models.service;

import java.util.List;

import com.example.demo.models.entity.Clientes;

public interface IClienteService {
	public void save(Clientes cliente);
	public Clientes findById(long id);
	public List<Clientes> findAll();
	void deleteById(long id);
}
