package com.example.Sindopan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TabelPengalamanKerja")
public class PengalamanKerjaModel {

	@Id
	@GeneratedValue
	@Column(name="idPengalaman")
	private int idPengalaman;
	
	@Column(name="idKaryawan")
	private int idKaryawan;
	
	@Column(name="namaPerusahaan")
	private String namaPerusahaan;
	
	@Column(name="alasanResign")
	private String alasanResign;
	
	@Column(name="tanggalMasuk")
	private Date tanggalMasuk;
	
	@Column(name="tanggalKeluar")
	private Date tanggalKeluar;
	
	@Column(name="namaPegawai")
	private String namaPegawai;

	public int getIdPengalaman() {
		return idPengalaman;
	}

	public void setIdPengalaman(int idPengalaman) {
		this.idPengalaman = idPengalaman;
	}

	public int getIdKaryawan() {
		return idKaryawan;
	}

	public void setIdKaryawan(int idKaryawan) {
		this.idKaryawan = idKaryawan;
	}

	public String getNamaPerusahaan() {
		return namaPerusahaan;
	}

	public void setNamaPerusahaan(String namaPerusahaan) {
		this.namaPerusahaan = namaPerusahaan;
	}

	public String getAlasanResign() {
		return alasanResign;
	}

	public void setAlasanResign(String alasanResign) {
		this.alasanResign = alasanResign;
	}

	public Date getTanggalMasuk() {
		return tanggalMasuk;
	}

	public void setTanggalMasuk(Date tanggalMasuk) {
		this.tanggalMasuk = tanggalMasuk;
	}

	public Date getTanggalKeluar() {
		return tanggalKeluar;
	}

	public void setTanggalKeluar(Date tanggalKeluar) {
		this.tanggalKeluar = tanggalKeluar;
	}

	public String getNamaPegawai() {
		return namaPegawai;
	}

	public void setNamaPegawai(String namaPegawai) {
		this.namaPegawai = namaPegawai;
	}
	
	
}
