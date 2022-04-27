package com.example.Sindopan.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.Sindopan.model.HariKerjaModel;

public interface HariKerjaRepository extends JpaRepository<HariKerjaModel, Integer>{
	
	@Modifying
	@Query(value="Select * from tabel_hari_kerja t where SUBSTRING(cast(t.tanggal as varchar(23)),6,2) =?1 and SUBSTRING(cast(t.tanggal as varchar(23)),1,4) =?2 order by t.tanggal",nativeQuery = true)
	List<HariKerjaModel>searchByMonthAndYearsOrderByDate(String month, String year);
	

}
