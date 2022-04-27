package com.example.Sindopan.Service;

import java.sql.Time;
import java.text.ParseException;
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
	
	public List<HariKerjaModel> readHariKerja(String month, String year, String hariKerja, String hariKerja2) {
		  if(month==null && year==null && hariKerja.equals("test") && hariKerja2.equals("test2")) {
			  month="01";
			  year = "2022";
		  }
		  else if(month==null && year==null && !hariKerja.equals("test") && !hariKerja2.equals("test2")) {
			  month=hariKerja;
			  year=hariKerja2;
		  }
		  return hr.searchByMonthAndYearsOrderByDate(month,year); 
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
	
	public String getMonth(String month,String hariKerja) {
		  if(month==null && !hariKerja.equals("test")) {
			  month=hariKerja;
		  }
		return month;
	}
	
	public String getYears(String years,String hariKerja2) {
		  if(years==null && !hariKerja2.equals("test2")) {
			  years=hariKerja2;
		  }
		return years;
	}
	
	public void deleteHariKerja(int id) {
		hr.deleteById(id);
	}

}
