package com.example.Sindopan.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.Sindopan.model.KaryawanModel;

public interface KaryawanRepository extends JpaRepository<KaryawanModel, Integer> {
	
	@Modifying
	@Query("delete from KaryawanModel k where k.id in ?1")
	void deleteKaryawanWithIds(List<Integer> ids);
	
	@Modifying
	@Query(value="select * from employee_table where nama_pegawai =?1",nativeQuery = true)
	List<KaryawanModel> searchByEmployeeName(String namaPegawai);

}
