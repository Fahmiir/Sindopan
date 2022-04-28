package com.example.Sindopan.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kehadiran_table")
public class KehadiranModel {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="namaKaryawan")
	private String namaKaryawan;
	
	@Column(name="tanggal")
	private Date tanggal;
	
	@Column(name="checkIn")
	private Time checkIn;
	
	@Column(name="checkOut")
	private Time checkOut;
	
	@Column(name="idKaryawan")
	private Integer idKaryawan;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamaKaryawan() {
		return namaKaryawan;
	}

	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public Time getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Time checkIn) {
		this.checkIn = checkIn;
	}

	public Time getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Time checkOut) {
		this.checkOut = checkOut;
	}

	public Integer getIdKaryawan() {
		return idKaryawan;
	}

	public void setIdKaryawan(Integer idKaryawan) {
		this.idKaryawan = idKaryawan;
	}
	
	

}
