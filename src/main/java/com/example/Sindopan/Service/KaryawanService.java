package com.example.Sindopan.Service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Sindopan.Repository.AgamaRepository;
import com.example.Sindopan.Repository.JenisKelaminRepository;
import com.example.Sindopan.Repository.KaryawanRepository;
import com.example.Sindopan.model.AgamaModel;
import com.example.Sindopan.model.JenisKelaminModel;
import com.example.Sindopan.model.KaryawanModel;

@Service
@Transactional
public class KaryawanService {
	
	@Autowired
	AgamaRepository ar;
	
	@Autowired
	JenisKelaminRepository jr;
	
	@Autowired
	KaryawanRepository kr;
	
	public List<AgamaModel> readAgama() {
		return ar.findAll();
	}
	
	public List<KaryawanModel> readKaryawan(String namaKaryawan) {
		if(namaKaryawan.isEmpty()) {
		    return kr.findAll();
		}
		else {
			return kr.searchByEmployeeName(namaKaryawan);
		}
	}
	public List<JenisKelaminModel> readJenisKelamin() {
		return jr.findAll();
	}
	
	public void create (KaryawanModel km) {
	    kr.save(km);
	}
	
	public void createDirectory(String uploadDirectory, String filePath, MultipartFile Image) {
	try {	
		File dir = new File(uploadDirectory);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
		stream.write(Image.getBytes());
		stream.close();
	} catch (Exception e) {
		e.printStackTrace();
		System.out.print("fail");
	}

	}
	
	public Optional<KaryawanModel> getImageById(Integer id){
		return kr.findById(id);
	}
	
	public void delete(List<Integer> id) {
		kr.deleteKaryawanWithIds(id);;
	}
}
