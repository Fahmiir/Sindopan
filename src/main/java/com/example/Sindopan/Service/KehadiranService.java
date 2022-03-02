package com.example.Sindopan.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Sindopan.Repository.KehadiranRepository;

import org.springframework.util.StringUtils;

@Service
@Transactional
public class KehadiranService {
	
	@Value("${app.upload.dir:${user.home}}")
    public String uploadDir;
	
	@Autowired
	KehadiranRepository kr;
	
	Workbook workbook;
	
	public void uploadFile(MultipartFile file) {
        try {
            Path copyLocation = Paths
                .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Could not store file " + file.getOriginalFilename()
                + ". Please try again!");
        }
        List<String> list = new ArrayList<String>();
        System.out.println("Upload Dir "+uploadDir.concat("\\").concat(file.getOriginalFilename()));
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
		
		// Getting number of columns in the Sheet
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
		System.out.println("-------Sheet has '"+noOfColumns+"' columns------");
        
        
	}

}
