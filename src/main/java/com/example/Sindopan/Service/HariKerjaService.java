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
	
	
	public List<HariKerjaModel> readHariKerja(String month, String month2) {
		String x ="";
		  if(month==null && month2==null) {
			  x="01";
		  }
		  else if (month2!=null) {
			  x=month2;
		  }
		  else {
			  x=month;
		  }
		  return hr.searchByMonthOrderByDate(x); 
	}
	 
	
	public List<HariKerjaModel> readHariKerja(){
		return hr.findAll();
	}
	
	public void saveDate(HariKerjaModel hm) {
		hr.save(hm);
	}
	
	public void updateDate(HariKerjaModel hm) {
		hr.save(hm);
	}
	
	public Time getTime(String time) throws ParseException {
		if(time.equals("")) {
			return null;
		}
		else {
			return Time.valueOf(time+":00");
		}
	}

}
