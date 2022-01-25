package com.example.Sindopan.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Sindopan.Repository.SindopanRepository;
import com.example.Sindopan.model.SindopanModel;

@Service
@Transactional
public class SindopanService {
	
@Autowired
SindopanRepository sr;

public String read (String Username, String Password) {
	String page = "index" ;
	List<SindopanModel> sm = sr.findAll();
    for(int i=0;i<sm.size();i++) {
    	if(Username.equals(sm.get(i).getNamaUser()) && Password.equals(sm.get(i).getPassword())) {
    		page = "main";
    		break;
    	}
    }
    return page;
}

public String searchIframe(String iframe) {
	String page = null;
	if(iframe.contentEquals("karyawan")) {
		page="masterKaryawan";
	}
	else {
		page="welcome";
	}
	return page;
}
}
