package com.kchaou.restapi.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Person implements Serializable {

	@Id
	@GeneratedValue
	@Column(name="idperson")
	private Long idPesron;
	private String name;
	@Column(name="familyname")
	private String familyName;
	private String adress;
	private String mail;
	private String phone;
	
	

	public Person() {
		super();
		
	}

	public Person( String name, String familyName, String adress, String mail, String phone) {
	
	
		this.name = name;
		this.familyName = familyName;
		this.adress = adress;
		this.mail = mail;
		this.phone = phone;
	}

	public Long getIdPesron() {
		return idPesron;
	}

	public void setIdPesron(Long idPesron) {
		this.idPesron = idPesron;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
