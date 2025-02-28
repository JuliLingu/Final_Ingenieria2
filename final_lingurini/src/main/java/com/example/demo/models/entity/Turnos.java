package com.example.demo.models.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "turnos")
public class Turnos implements Serializable{
		private static final long serialVersionUID = 1L;
		
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name="cliente_id")
	    private Long clienteId;
	    
	    private String vehiculo;
	    private String patente;
	    
		@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm" )
	    @NotNull
	    private LocalDateTime   fecha;
	     
	    
	    private String estado; // "Pendiente", "Confirmado", "Cancelado"

	    // Getters y Setters
	    //Se creaban con source y generate getters/setters
	    

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public Long getClienteId() {
			return clienteId;
		}


		public void setClienteId(Long clienteId) {
			this.clienteId = clienteId;
		}


		public String getVehiculo() {
			return vehiculo;
		}


		public void setVehiculo(String vehiculo) {
			this.vehiculo = vehiculo;
		}


		public String getPatente() {
			return patente;
		}


		public void setPatente(String patente) {
			this.patente = patente;
		}


		public LocalDateTime getFecha() {
			return fecha;
		}


		public void setFecha(LocalDateTime fecha) {
			this.fecha = fecha;
		}


		public String getEstado() {
			return estado;
		}


		public void setEstado(String estado) {
			this.estado = estado;
		}
		
	    

	    



}
