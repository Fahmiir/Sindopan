package com.example.Sindopan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "employee_table")
public class KaryawanModel {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="namaPegawai")
	private String namaPegawai;

	@Column(name="alamat")
	private String alamat;
	
	@Column(name="agama")
	private String agama;
	
	@Column(name="tempatLahir")
	private String tempatLahir;
	
	@Column(name="tanggalLahir")
	private Date  tanggalLahir;
	
	@Column(name="jenisKelamin")
    private String jenisKelamin;
	
	@Column(name="type")
    private String type;
	
	@Column(name="picByte", length=100000000)
    private byte[] picByte;
	
	@Column(name="image")
    private String image;
	
	@Column(name="jabatan")
	private String jabatan;
	
	@Column(name="NIK")
	private String NIK;
		
	@Column(name="filePath")
	private String filePath;
	
	@Column(name="maritalStatus")
	private String maritalStatus;
	
	@Column(name="pendidikanTerakhir")
	private String pendidikanTerakhir;
	
	@Column(name="tanggalJoin")
	private Date tanggalJoin;
	
	@Column(name="tanggalResign")
	private Date tanggalResign;
	
	@Column(name="addedBy")
    private String addedBy;

	@Column(name="addedOn")
	private Date addedOn;
	
	@Column(name="updateBy")
	private String updateBy;
	
	@Column(name="updateOn")
	private String updateOn;
	
	@Column(name="statusData")
	private String statusData;
	
	@Column(name="defunct")
	private Integer defunct;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamaPegawai() {
		return namaPegawai;
	}

	public void setNamaPegawai(String namaPegawai) {
		this.namaPegawai = namaPegawai;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getAgama() {
		return agama;
	}

	public void setAgama(String agama) {
		this.agama = agama;
	}

	public String getTempatLahir() {
		return tempatLahir;
	}

	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getNIK() {
		return NIK;
	}

	public void setNIK(String nIK) {
		NIK = nIK;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getPendidikanTerakhir() {
		return pendidikanTerakhir;
	}

	public void setPendidikanTerakhir(String pendidikanTerakhir) {
		this.pendidikanTerakhir = pendidikanTerakhir;
	}

	public Date getTanggalJoin() {
		return tanggalJoin;
	}

	public void setTanggalJoin(Date tanggalJoin) {
		this.tanggalJoin = tanggalJoin;
	}

	public Date getTanggalResign() {
		return tanggalResign;
	}

	public void setTanggalResign(Date tanggalResign) {
		this.tanggalResign = tanggalResign;
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

	public String getStatusData() {
		return statusData;
	}

	public void setStatusData(String statusData) {
		this.statusData = statusData;
	}

	public Integer getDefunct() {
		return defunct;
	}

	public void setDefunct(Integer defunct) {
		this.defunct = defunct;
	}
	
	

}
