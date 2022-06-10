package com.example.Sindopan.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tabel_pelatihan")
public class PelatihanModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")	
	private int id;
	
	@Column(name="pelatihan")
	private int pelatihan;
	
	@Column(name="tanggalMulai")
	private Date tanggalMulai;
	
	@Column(name="tanggalBerakhir")
	private Date tanggalBerakhir;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPelatihan() {
		return pelatihan;
	}

	public void setPelatihan(int pelatihan) {
		this.pelatihan = pelatihan;
	}

	public Date getTanggalMulai() {
		return tanggalMulai;
	}

	public void setTanggalMulai(Date tanggalMulai) {
		this.tanggalMulai = tanggalMulai;
	}

	public Date getTanggalBerakhir() {
		return tanggalBerakhir;
	}

	public void setTanggalBerakhir(Date tanggalBerakhir) {
		this.tanggalBerakhir = tanggalBerakhir;
	}
	
	

}
