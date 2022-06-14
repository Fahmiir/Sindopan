package com.example.Sindopan.model;

import java.util.Date;

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
	private Integer id;
	
	@Column(name="idKaryawan")
	private Integer idKaryawan;
	
	@Column(name="namaKaryawan")
	private String namaKaryawan;
	
	@Column(name="namaPelatihan")
	private String namaPelatihan;
	
	@Column(name="tanggalMulai")
	private Date tanggalMulai;
	
	@Column(name="tanggalBerakhir")
	private Date tanggalBerakhir;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdKaryawan() {
		return idKaryawan;
	}

	public void setIdKaryawan(Integer idKaryawan) {
		this.idKaryawan = idKaryawan;
	}

	public String getNamaKaryawan() {
		return namaKaryawan;
	}

	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}

	public String getNamaPelatihan() {
		return namaPelatihan;
	}

	public void setNamaPelatihan(String namaPelatihan) {
		this.namaPelatihan = namaPelatihan;
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
