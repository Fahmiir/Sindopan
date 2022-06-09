package com.example.Sindopan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Sindopan.Service.HariKerjaService;
import com.example.Sindopan.Service.KaryawanService;
import com.example.Sindopan.Service.KehadiranService;
import com.example.Sindopan.Service.SindopanService;
import com.example.Sindopan.model.AgamaModel;
import com.example.Sindopan.model.HariKerjaModel;
import com.example.Sindopan.model.JenisKelaminModel;
import com.example.Sindopan.model.KaryawanModel;
import com.example.Sindopan.model.KehadiranModel;
import com.example.Sindopan.model.MaritalStatusModel;
import com.example.Sindopan.model.PendidikanModel;


@Controller
public class SindopanController {
    @Autowired
    SindopanService ss;
    
	@Autowired
	KaryawanService as;
	
	@Autowired
	HariKerjaService hs;
	
	@Autowired
	KehadiranService ks;

	
	@RequestMapping(value="/")
	public String menuHome() {
		return "index";
	}
	
	@RequestMapping(value="/welcome")
	public String menuWelcome() {
		return "welcome";
	}
	
	@RequestMapping(value="/hariKerja")
	public String menuHariKerja(Model model,HttpServletRequest request,@RequestParam(value="hariKerja",required=false)String hariKerja,@RequestParam(value="hariKerja2",required=false)String hariKerja2) throws InterruptedException {
		List<HariKerjaModel> hk = new ArrayList<>();
		List<HariKerjaModel> hk2 = new ArrayList<>();
		String month = request.getParameter("bulansrc");	
		String years = request.getParameter("tahunsrc");
		hk = hs.readHariKerja(month,years,hariKerja,hariKerja2);
		hk2 = hs.readHariKerja();
		model.addAttribute("ListHariKerjaModel", hk);
		model.addAttribute("ListHariKerjaModel2", hk2);
		model.addAttribute("valueSelected",hs.getMonth(month, hariKerja));
		model.addAttribute("valueSelected2",hs.getYears(years, hariKerja2));
		return "hariKerja";
	}
	
	@RequestMapping(value="/kehadiran")
	public String menuKehadiran(Model model,HttpServletRequest request) {
		List<KehadiranModel> kk = new ArrayList<>();
		List<HariKerjaModel> hk = new ArrayList<>();
		List<KaryawanModel>  km = new ArrayList<>();
		String id = request.getParameter("cmbNamaKaryawan");
		String bulan = request.getParameter("bulansrc");
		String tahun = request.getParameter("tahunsrc");
		kk = ks.readKehadiran(id,bulan,tahun);
		hk = hs.readHariKerja();
		km = as.readAllKaryawan();
		model.addAttribute("ListKehadiranModel", kk);
		model.addAttribute("ListHariKerjaModel", hk);
		model.addAttribute("ListKaryawanModel", km);
		model.addAttribute("idSelected", id);
		model.addAttribute("monthSelected", bulan);
		model.addAttribute("yearSelected", tahun);
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
		List<MaritalStatusModel> mk = new ArrayList<>();
		List<PendidikanModel> lk = new ArrayList<>();
		ak = as.readAgama();
		jk = as.readJenisKelamin();
		kk = as.readKaryawan(namaKaryawan);
		mk = as.readMaritalStatus();
		lk = as.readPendidikanTerakhir();
		model.addAttribute("ListAgama", ak);
		model.addAttribute("ListJenisKelamin", jk);
		model.addAttribute("ListKaryawanModel", kk);
		model.addAttribute("ListMaritalStatus", mk);
		model.addAttribute("ListPendidikan",lk);
		return "karyawan";
	}
	
	@RequestMapping(value="/logout")
	public String menuLogOut() {
		return "index";
	}
}
