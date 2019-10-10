package com.srpago.gasws.rest.core.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "datos_venta", uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class DatosVenta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", length=11, nullable=false, unique=true)
	protected Integer id;
	@Column(name = "calleStation", length=100, nullable=true)
	protected String calleStation;
	@Column(name = "cardNumber", length=100, nullable=true)
	protected String cardNumber;
	@Column(name = "email", length=100, nullable=true)
	protected String email;
	@Column(name = "gasStation", length=100, nullable=true)
	protected String gasStation;
	@Column(name = "dato2", length=100, nullable=true)
	protected String dato2;
	@Column(name = "dato3", length=100, nullable=true)
	protected String dato3;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCalleStation() {
		return calleStation;
	}
	public void setCalleStation(String calleStation) {
		this.calleStation = calleStation;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGasStation() {
		return gasStation;
	}
	public void setGasStation(String gasStation) {
		this.gasStation = gasStation;
	}
	public String getDato2() {
		return dato2;
	}
	public void setDato2(String dato2) {
		this.dato2 = dato2;
	}
	public String getDato3() {
		return dato3;
	}
	public void setDato3(String dato3) {
		this.dato3 = dato3;
	}
	
	
}
