package com.example.Sindopan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tabel_golongan_darah")
public class GolonganDarahModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")		
	private int id;
	
	@Column(name="golonganDarah")
	private String golonganDarah;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGolonganDarah() {
		return golonganDarah;
	}

	public void setGolonganDarah(String golonganDarah) {
		this.golonganDarah = golonganDarah;
	}
	
	

}
