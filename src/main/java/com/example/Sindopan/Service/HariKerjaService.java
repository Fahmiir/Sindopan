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
	
	public List<HariKerjaModel> readHariKerja() {
		return hr.findAll();
	}
	
	public void updateDate(HariKerjaModel hm) {
		hr.save(hm);
	}
	
	public Time getTime(String time) throws ParseException {
		System.out.println("Jam Masuk "+time);
		return Time.valueOf(time+":00");
	}

}
