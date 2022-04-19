package com.example.Sindopan.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.Sindopan.model.KehadiranModel;

public interface KehadiranRepository extends JpaRepository<KehadiranModel,Integer>{
	
	@Modifying
	@Query(value="select * from kehadiran_table k where k.nama_karyawan=?1 order by k.tanggal",nativeQuery = true)
	List<KehadiranModel>SearchByNamaKaryawan(String nama);

}
