package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.IClienteDao;
import com.example.demo.models.entity.Clientes;

@Service
public class ClienteServiceImp implements IClienteService{

	@Autowired IClienteDao iClienteDao;
	
	@Override
	public void save(Clientes cliente) {
		// TODO Auto-generated method stub
		iClienteDao.save(cliente);
	}

	@Override
	public Clientes findById(long id) {
		// TODO Auto-generated method stub
		return iClienteDao.findById(id).orElse(null);
	}

	@Override
	public List<Clientes> findAll() {
		// TODO Auto-generated method stub
		return (List<Clientes>)iClienteDao.findAll();
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		iClienteDao.deleteById(id);
	}

}
