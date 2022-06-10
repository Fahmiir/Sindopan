package com.example.Sindopan.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_history_table")
public class KaryawanHistoryModel {
	
	
	@Id
	@Column(name="idKaryawanHistori")
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private Integer idKaryawanHistori;

	@Column(name="idKaryawan")
	private Integer idKaryawan;
	
	@Column(name="nik")
	private String nik;
	
	@Column(name="namaKaryawan")
	private String namaKaryawan;
	
	@Column(name="kotaLahir")
	private String kotaLahir;
	
	@Column(name="tanggalLahir")
	private Date tanggalLahir;
	
	@Column(name="jenisKelamin")
	private String jenisKelamin;
	
	@Column(name="maritalStat")
	private String maritalStat;
	
	@Column(name="kotaTinggal")
	private String kotaTinggal;
	
	@Column(name="alamatTanggal")
	private String alamatTanggal;
	
	@Column(name="agama")
	private String agama;
	
	@Column(name="pendidikanTerakhir")
	private String pendidikanTerakhir;

	@Column(name="foto")
	private String foto;

	@Column(name="jabatan")
	private String jabatan;

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

	@Column(name="action")
	private String action;

	@Column(name="actionBy")
	private String actionBy;

	@Column(name="actionOn")
	private String actionOn;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="phoneNumber2")
	private String phoneNumber2;
	
	@Column(name="contactEmergency")
	private String contactEmergency;
	
	@Column(name="provinsi")
	private String provinsi;
	
	@Column(name="kota")
	private String kota;
	
	@Column(name="kecamatan")
	private String kecamatan;
	
	@Column(name="kelurahan")
	private String kelurahan;
	
	@Column(name="RT")
	private String RT;
	
	@Column(name="RW")
	private String RW;
	
	@Column(name="golonganDarah")
	private String golonganDarah;

	public Integer getIdKaryawanHistori() {
		return idKaryawanHistori;
	}

	public void setIdKaryawanHistori(Integer idKaryawanHistori) {
		this.idKaryawanHistori = idKaryawanHistori;
	}

	public Integer getIdKaryawan() {
		return idKaryawan;
	}

	public void setIdKaryawan(Integer idKaryawan) {
		this.idKaryawan = idKaryawan;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNamaKaryawan() {
		return namaKaryawan;
	}

	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}

	public String getKotaLahir() {
		return kotaLahir;
	}

	public void setKotaLahir(String kotaLahir) {
		this.kotaLahir = kotaLahir;
	}

	public Date getTanggalLahir() {
		return tanggalLahir;
	}

	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}

	public String getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}

	public String getMaritalStat() {
		return maritalStat;
	}

	public void setMaritalStat(String maritalStat) {
		this.maritalStat = maritalStat;
	}

	public String getKotaTinggal() {
		return kotaTinggal;
	}

	public void setKotaTinggal(String kotaTinggal) {
		this.kotaTinggal = kotaTinggal;
	}

	public String getAlamatTanggal() {
		return alamatTanggal;
	}

	public void setAlamatTanggal(String alamatTanggal) {
		this.alamatTanggal = alamatTanggal;
	}

	public String getAgama() {
		return agama;
	}

	public void setAgama(String agama) {
		this.agama = agama;
	}

	public String getPendidikanTerakhir() {
		return pendidikanTerakhir;
	}

	public void setPendidikanTerakhir(String pendidikanTerakhir) {
		this.pendidikanTerakhir = pendidikanTerakhir;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getJabatan() {
		return jabatan;
	}

	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public String getActionOn() {
		return actionOn;
	}

	public void setActionOn(String actionOn) {
		this.actionOn = actionOn;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getContactEmergency() {
		return contactEmergency;
	}

	public void setContactEmergency(String contactEmergency) {
		this.contactEmergency = contactEmergency;
	}

	public String getProvinsi() {
		return provinsi;
	}

	public void setProvinsi(String provinsi) {
		this.provinsi = provinsi;
	}

	public String getKota() {
		return kota;
	}

	public void setKota(String kota) {
		this.kota = kota;
	}

	public String getKecamatan() {
		return kecamatan;
	}

	public void setKecamatan(String kecamatan) {
		this.kecamatan = kecamatan;
	}

	public String getKelurahan() {
		return kelurahan;
	}

	public void setKelurahan(String kelurahan) {
		this.kelurahan = kelurahan;
	}

	public String getRT() {
		return RT;
	}

	public void setRT(String rT) {
		RT = rT;
	}

	public String getRW() {
		return RW;
	}

	public void setRW(String rW) {
		RW = rW;
	}

	public String getGolonganDarah() {
		return golonganDarah;
	}

	public void setGolonganDarah(String golonganDarah) {
		this.golonganDarah = golonganDarah;
	}
	
	

}
