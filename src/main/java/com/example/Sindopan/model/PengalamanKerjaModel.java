package com.example.Sindopan.model;

import java.sql.Date;

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
}
