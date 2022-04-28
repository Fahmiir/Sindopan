package com.example.Sindopan.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.Sindopan.model.KehadiranModel;

public interface KehadiranRepository extends JpaRepository<KehadiranModel,Integer>{

	@Modifying
	@Query("delete from KehadiranModel k where k.idKaryawan in ?1")
	void deleteKaryawanByIds(List<Integer> ids);
	
	@Modifying
	@Query(value="select * from kehadiran_table k where k.id_karyawan=?1 and SUBSTRING(cast(k.tanggal as varchar(23)),6,2)=?2 and SUBSTRING(cast(k.tanggal as varchar(23)),1,4)=?3 order by k.tanggal",nativeQuery = true)
	List<KehadiranModel>SearchByNamaKaryawan(String id, String bulan, String tahun);

}
