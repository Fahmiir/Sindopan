package com.example.Sindopan.model;

import java.sql.Time;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TabelHariKerja")
public class HariKerjaModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idHari")
	private int idHari;
	
	@Column(name="tanggal")
	private Date tanggal;
	
	@Column(name="jamMasuk")
	private Time jamMasuk;
	
	@Column(name="jamKeluar")
	private Time jamKeluar;
	
	@Column(name="keterangan")
	private String keterangan;
	
	@Column(name="addedBy")
	private String addedBy;
	
	@Column(name="addedOn",columnDefinition="DATETIME")
	private Date addedOn;
	
	@Column(name="updateBy")
	private String updateBy;
	
	@Column(name="updateOn",columnDefinition="DATETIME")
	private String updateOn;
	
	@Column(name="merahBukan")
	private String merahBukan;

	public int getIdHari() {
		return idHari;
	}

	public void setIdHari(int idHari) {
		this.idHari = idHari;
	}

	public Date getTanggal() {
		return tanggal;
	}

	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
	}

	public Time getJamMasuk() {
		return jamMasuk;
	}

	public void setJamMasuk(Time jamMasuk) {
		this.jamMasuk = jamMasuk;
	}

	public Time getJamKeluar() {
		return jamKeluar;
	}

	public void setJamKeluar(Time jamKeluar) {
		this.jamKeluar = jamKeluar;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public String getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(String addedBy) {
		this.addedBy = addedBy;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getUpdateOn() {
		return updateOn;
	}

	public void setUpdateOn(String updateOn) {
		this.updateOn = updateOn;
	}

	public String getMerahBukan() {
		return merahBukan;
	}

	public void setMerahBukan(String merahBukan) {
		this.merahBukan = merahBukan;
	}
	
	
	
	

}
