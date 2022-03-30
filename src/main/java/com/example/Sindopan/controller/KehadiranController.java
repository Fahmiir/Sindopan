package com.example.Sindopan.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.Sindopan.Service.KehadiranService;


@Controller
public class KehadiranController {
	
	@Autowired
	KehadiranService ks;

	@RequestMapping(value="/uploadFile")
	public String menuUploadFile(@RequestParam("fileAbsensi") MultipartFile file, Model model) throws ParseException {
		ks.uploadFile(file);
		return "redirect:/kehadiran";
	}
}
