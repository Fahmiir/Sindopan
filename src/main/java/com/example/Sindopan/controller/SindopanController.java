package com.example.Sindopan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Sindopan.Service.HariKerjaService;
import com.example.Sindopan.Service.KaryawanService;
import com.example.Sindopan.Service.SindopanService;
import com.example.Sindopan.model.AgamaModel;
import com.example.Sindopan.model.HariKerjaModel;
import com.example.Sindopan.model.JenisKelaminModel;
import com.example.Sindopan.model.KaryawanModel;
import com.example.Sindopan.model.SindopanModel;

@Controller
public class SindopanController {
    @Autowired
    SindopanService ss;
    
	@Autowired
	KaryawanService as;
	
	@Autowired
	HariKerjaService hs;

	
	@RequestMapping(value="/")
	public String menuHome() {
		return "index";
	}
	
	@RequestMapping(value="/welcome")
	public String menuWelcome() {
		return "welcome";
	}
	
	@RequestMapping(value="/hariKerja")
	public String menuHariKerja(Model model,HttpServletRequest request, HttpSession session) {
		List<HariKerjaModel> hk = new ArrayList<>();
		String month = request.getParameter("bulansrc");
		String month2 = (String) session.getAttribute("month2");
		hk = hs.readHariKerja(month,month2);
		model.addAttribute("ListHariKerjaModel", hk);
		model.addAttribute("valueSelected",month);
		return "hariKerja";
	}
	
	@RequestMapping(value="/kehadiran")
	public String menuKehadiran(Model model) {
		return "kehadiran";
	}
	
	@RequestMapping(value="/prosesLogin")
	public String menuLogin(HttpServletRequest request, Model model) {
		String userName = request.getParameter("usr");
		String password = request.getParameter("psw");
		return ss.read(userName, password) ;
	}
	
	@RequestMapping(value="/goToKaryawan")
	public String menuDashboard(Model model, @RequestParam(value="txtSearch",required=false,defaultValue="") String namaKaryawan) {
		List<AgamaModel> ak = new ArrayList<>();
		List<JenisKelaminModel> jk = new ArrayList<>();
		List<KaryawanModel> kk = new ArrayList<>();
		ak = as.readAgama();
		jk = as.readJenisKelamin();
		kk = as.readKaryawan(namaKaryawan);
		model.addAttribute("ListAgama", ak);
		model.addAttribute("ListJenisKelamin", jk);
		model.addAttribute("ListKaryawanModel", kk);
		return "karyawan";
	}
	
	
	
	@RequestMapping(value="/logout")
	public String menuLogOut() {
		return "index";
	}
}
