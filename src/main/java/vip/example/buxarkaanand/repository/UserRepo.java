package vip.example.buxarkaanand.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import vip.example.buxarkaanand.model.UserData;

public interface UserRepo extends JpaRepository<UserData, Long>{
	
//	Page<UserData> findAll(Pageable pageable);
	
	boolean existsByTransactionMessage(String tm);

}
