package com.example.demo.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dao.ITurnosDao;
import com.example.demo.models.entity.Turnos;
@Service
public class TurnosServiceImp implements ITurnosService{

	@Autowired
	ITurnosDao iTurnosDao;

	@Override
	public void save(Turnos turnos) {
		// TODO Auto-generated method stub
		iTurnosDao.save(turnos);
	}

	@Override
	public Turnos findById(long id) {
		// TODO Auto-generated method stub
		return iTurnosDao.findById(id).orElse(null);
	}

	@Override
	public List<Turnos> findAll() {
		// TODO Auto-generated method stub
		return (List<Turnos>)iTurnosDao.findAll();
	}

	@Override
	public List<Turnos> findByClienteId(Long clienteId) {
		// TODO Auto-generated method stub
		return iTurnosDao.findByClienteId(clienteId);
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		iTurnosDao.deleteById(id);
	}


}
