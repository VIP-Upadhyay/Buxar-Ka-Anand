package vip.example.buxarkaanand.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vip.example.buxarkaanand.model.AppSetting;

public interface AppRepo extends JpaRepository<AppSetting, Long>{
	
	AppSetting findByKey(String key);
	
	 @Query("SELECT a.upiId FROM AppSetting a WHERE a.key = :key")
	 String findUpiIdByKey(@Param("key") String key);

}
