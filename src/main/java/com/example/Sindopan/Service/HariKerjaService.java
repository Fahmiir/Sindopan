package com.example.Sindopan.Service;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Sindopan.Repository.HariKerjaRepository;

import com.example.Sindopan.model.HariKerjaModel;

@Service
@Transactional
public class HariKerjaService {
	
	@Autowired
	HariKerjaRepository hr;
	
	
	public List<HariKerjaModel> readHariKerja(String month,String hariKerja) {
		  if(month==null && hariKerja.equals("test")) {
			  month="01";
		  }
		  else if(month==null && !hariKerja.equals("test")) {
			  month=hariKerja;
		  }
		  return hr.searchByMonthOrderByDate(month); 
	}
	 
	
	public List<HariKerjaModel> readHariKerja(){
		return hr.findAll();
	}
	
	public void saveDate(HariKerjaModel hm) {
		hr.save(hm);
	}
	
	public void updateDate(HariKerjaModel hm) {
		if(hm.getMerahBukan()!=null && hm.getKeterangan()!=null) {
			hm.setJamMasuk(null);
			hm.setJamKeluar(null);
		}
		else if (hm.getJamMasuk()!=null && hm.getJamKeluar()!=null) {
			hm.setMerahBukan(null);
			hm.setKeterangan(null);
		}
		hr.save(hm);
	}
	
	public Time getTime(String time) throws ParseException {
		if(time.equals("")) {
			return null;
		}
		else {
			if(time.length()==8) {
				return Time.valueOf(time);
			}
			else {
				return Time.valueOf(time+":00");	
			}
		}
	}

}
