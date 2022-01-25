package com.example.Sindopan.controller;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Sindopan.Service.HariKerjaService;
import com.example.Sindopan.model.HariKerjaModel;

@Controller
public class HariKerjaController {
	
	@Autowired
	HariKerjaService hs;
	
	@RequestMapping(value="/editHari")
	public String menuEditHari(HttpServletRequest request,@RequestParam(value="chkmerah",required = false)String status) throws ParseException {
		int id = Integer.valueOf(request.getParameter("editId"));
		Date hariKerja = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("viewTanggal").substring(0,10));
		String keterangan = request.getParameter("kolomket");
		HariKerjaModel hm = new HariKerjaModel();
		Time jamMasuk = hs.getTime(request.getParameter("jamMasuk"));
		Time jamKeluar = hs.getTime(request.getParameter("jamPulang"));
		hm.setIdHari(id);
		hm.setKeterangan(keterangan);
		hm.setTanggal(hariKerja);
		hm.setMerahBukan(status);
		hm.setJamMasuk(jamMasuk);
		hm.setJamKeluar(jamKeluar);
		hs.updateDate(hm);
		return "redirect:/hariKerja";
	}

}
