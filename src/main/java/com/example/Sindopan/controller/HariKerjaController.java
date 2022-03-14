package com.example.Sindopan.controller;

import java.util.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Sindopan.Service.HariKerjaService;
import com.example.Sindopan.model.HariKerjaModel;


@Controller
public class HariKerjaController {
	
	@Autowired
	HariKerjaService hs;
	
	private String month;
	
	@RequestMapping(value="/addHari")
	public String menuAddHari(HttpServletRequest request,@RequestParam(value="addchkmerah",required = false)String status, Model model, HttpSession session) throws ParseException {
		Date hariKerja = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("addharikerja"));
		java.sql.Date workDay = new java.sql.Date(hariKerja.getTime());
		String keterangan = request.getParameter("addkolomket");
		Time jamMasuk = hs.getTime(request.getParameter("addjammasuk"));
		Time jamKeluar = hs.getTime(request.getParameter("addjampulang"));
		month = request.getParameter("addBulan");
		HariKerjaModel hm = new HariKerjaModel();
		hm.setKeterangan(keterangan);
		hm.setTanggal(workDay);
		hm.setMerahBukan(status);
		hm.setJamMasuk(jamMasuk);
		hm.setJamKeluar(jamKeluar);
		hs.saveDate(hm);
		session.setAttribute("month", month);
   		return "redirect:/hariKerja";
	}
	
	@RequestMapping(value="/editHari")
	public String menuEditHari(HttpServletRequest request,@RequestParam(value="chkmerah",required = false)String status) throws ParseException {
		int id = Integer.valueOf(request.getParameter("editId"));
		Date hariKerja = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("viewTanggal").substring(0,10));
		java.sql.Date workDay = new java.sql.Date(hariKerja.getTime());
		String keterangan = request.getParameter("kolomket");
		Time jamMasuk = hs.getTime(request.getParameter("jamMasuk"));
		Time jamKeluar = hs.getTime(request.getParameter("jamPulang"));
		HariKerjaModel hm = new HariKerjaModel();
		hm.setIdHari(id);
		hm.setKeterangan(keterangan);
		hm.setTanggal(workDay);
		hm.setMerahBukan(status);
		hm.setJamMasuk(jamMasuk);
		hm.setJamKeluar(jamKeluar);
		hs.updateDate(hm);
		return "redirect:/hariKerja";
	}
	
}
