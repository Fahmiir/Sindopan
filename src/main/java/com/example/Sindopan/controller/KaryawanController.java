package com.example.Sindopan.controller;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.Sindopan.Service.KaryawanService;
import com.example.Sindopan.model.AgamaModel;
import com.example.Sindopan.model.JenisKelaminModel;
import com.example.Sindopan.model.KaryawanModel;

@Controller
public class KaryawanController {
	
	@Autowired
	KaryawanService ks;
	
	@Value("${uploadDir}")
	private String uploadFoto;

	
	@RequestMapping(value="/saveKaryawan")
	public String saveDataKaryawan(HttpServletRequest request,@RequestParam("fileFoto") MultipartFile Image) throws ParseException, IOException {
        String namaPegawai  = request.getParameter("txtNamaPegawai");
        String alamat       = request.getParameter("txtAlamat");
        String agama        = request.getParameter("cmbAgama");
        String tempatLahir  = request.getParameter("txtTempatLahir");
        Date tanggalLahir = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("txtTanggalLahir"));
        String JenisKelamin = request.getParameter("cmbJenisKelamin");
		String uploadDirectory = request.getServletContext().getRealPath(uploadFoto);
		String filePath = Paths.get(uploadDirectory, Image.getOriginalFilename()).toString();
		String jabatan = request.getParameter("txtJabatan");
		KaryawanModel km = new KaryawanModel();
		km.setNamaPegawai(namaPegawai);
		km.setAlamat(alamat);
		km.setAgama(agama);
		km.setTempatLahir(tempatLahir);
		km.setTanggalLahir(tanggalLahir);
		km.setJenisKelamin(JenisKelamin);
		km.setPicByte(Image.getBytes());
		km.setType(Image.getContentType());
		km.setImage(Image.getOriginalFilename());
	    km.setJabatan(jabatan);
		ks.create(km);
		ks.createDirectory(uploadDirectory, filePath, Image);
		return "redirect:/goToKaryawan";
	}
	
	@RequestMapping(value="/editKaryawan")
	public String editDataKaryawan(HttpServletRequest request,@RequestParam("fileFoto") MultipartFile Image) throws ParseException, IOException {
		int id = Integer.valueOf(request.getParameter("editTxtId"));
        String namaPegawai  = request.getParameter("editTxtNamaPegawai");
        String alamat       = request.getParameter("editTxtAlamat");
        String agama        = request.getParameter("editCmbAgama");
        String tempatLahir  = request.getParameter("editTxtTempatLahir");
        Date tanggalLahir = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("txtTanggalLahir"));
        String JenisKelamin = request.getParameter("editCmbJenisKelamin");
		String uploadDirectory = request.getServletContext().getRealPath(uploadFoto);
		String filePath = Paths.get(uploadDirectory, Image.getOriginalFilename()).toString();
		String jabatan = request.getParameter("editTxtJabatan");
		KaryawanModel km = new KaryawanModel();
		km.setId(id);
		km.setNamaPegawai(namaPegawai);
		km.setAlamat(alamat);
		km.setAgama(agama);
		km.setTempatLahir(tempatLahir);
		km.setTanggalLahir(tanggalLahir);
		km.setJenisKelamin(JenisKelamin);
		km.setPicByte(Image.getBytes());
		km.setType(Image.getContentType());
		km.setImage(Image.getOriginalFilename());
	    km.setJabatan(jabatan);
		ks.create(km);
		ks.createDirectory(uploadDirectory, filePath, Image);
		return "redirect:/goToKaryawan";
	}
	
	@RequestMapping("/image/display/{id}")
	@ResponseBody
	public void showImage(@PathVariable("id") Integer id, HttpServletResponse response, Optional<KaryawanModel> imageGallery) throws IOException {
		imageGallery = ks.getImageById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(imageGallery.get().getPicByte());
		response.getOutputStream().close();
	} 
	
	@RequestMapping(value="/deleteKaryawan", produces="text/plain")
	@ResponseBody
	public String deleteDataKaryawan(@RequestBody List<Integer> id) {
		ks.delete(id);
		return  "redirect:/goToKaryawan";
	}
	
	

}
