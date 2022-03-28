package com.example.Sindopan.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Sindopan.Repository.KehadiranRepository;
import com.example.Sindopan.model.KehadiranModel;

import org.springframework.util.StringUtils;

@Service
@Transactional
public class KehadiranService {

	@Value("${app.upload.dir:${user.home}}")
	public String uploadDir;

	@Autowired
	KehadiranRepository kr;

	Workbook workbook;

	public void uploadFile(MultipartFile file) throws ParseException {
		try {
			Path copyLocation = Paths
					.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
			Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Could not store file " + file.getOriginalFilename() + ". Please try again!");
		}
		List<String> list = new ArrayList<String>();

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();

		System.out.println("Upload Dir " + uploadDir.concat("\\").concat(file.getOriginalFilename()));
		// Create the Workbook
		try {
			workbook = WorkbookFactory.create(new File(uploadDir.concat("\\").concat(file.getOriginalFilename())));
			System.out.println("Workbook berhasil");
		} catch (EncryptedDocumentException | IOException | NullPointerException e) {
			System.out.println("Workbook tidak berhasil");
			e.printStackTrace();
		}

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);
		System.out.println("Sheet " + sheet);
		// Getting number of columns in the Sheet
		int noOfColumns = sheet.getRow(0).getLastCellNum();

		System.out.println("-------Sheet has '" + noOfColumns + "' columns------");
		
		// Using for-each loop to iterate over the rows and columns
		for (Row row : sheet) {
			for (Cell cell : row) {
				String cellValue = dataFormatter.formatCellValue(cell);
			//	System.out.println(cellValue);
				list.add(cellValue);
			}
		}
		
		ArrayList<KehadiranModel> list2 = new ArrayList<KehadiranModel>();
		
	    int i = noOfColumns;
		do {
			KehadiranModel km = new KehadiranModel();
			km.setNamaKaryawan(list.get(i));
			Date d = new SimpleDateFormat("dd/MM/yyyy").parse(parseDate(list.get(i+1)));
			java.sql.Date j = new java.sql.Date(d.getTime());
			km.setTanggal(j);
//			km.setTanggal(new java.sql.Date(new SimpleDateFormat("dd/MM/yyyy").parse(parseDate(list.get(i+1)))).getTime());
//			km.setCheckIn(Time.valueOf(list.get(i+2)+":00"));
            km.setCheckOut(Time.valueOf(list.get(i+3)+":00"));
            km.setDurasiKerja(list.get(i+4));
            km.setKeterangan(list.get(i+5));
            list2.add(km);
            kr.save(km);
			i=i+noOfColumns;
		}
		while (i<list.size());
		
		System.out.println("Panjang list "+list.size());
		
		


	}

	public String parseDate(String date) {
		String[] splitDate = date.split(" ");
		String month = null;
		switch (splitDate[1]) {
		    case "January" :
		        month = "01";
		        break;
		    case "February" :
		        month = "02";
		        break;
		    case "March" :
		        month = "03";
		        break;
		    case "April" :
		        month = "04";
		        break;
		    case "May" :
		        month = "05";
		        break;
		    case "June" :
		        month = "06";
		        break;
		    case "July" :
		        month = "07";
		        break;
		    case "August" :
		        month = "08";
		        break;
		    case "September" :
		        month = "09";
		        break;
		    case "October" :
		        month = "10";
		        break;
		    case "November" :
		        month = "11";
		        break;
		    case "December" :
		        month = "12";
		        break;
		}
		return splitDate[0].concat("/").concat(month).concat("/").concat(splitDate[2]);
	}
}



class Kehadiran {
	String namaKaryawan;
	String tanggal;
	String jamMasuk;
	String jamKeluar;
	
	Kehadiran(String namaKaryawan, String tanggal,String jamMasuk, String jamKeluar){
		this.namaKaryawan=namaKaryawan;
		this.tanggal=tanggal;
		this.jamMasuk=jamMasuk;
		this.jamKeluar=jamKeluar;
	}
}
