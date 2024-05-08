package vip.example.buxarkaanand.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vip.example.buxarkaanand.model.Funds;

public interface FundsRepo extends JpaRepository<Funds, Long>{
	
	Funds findByKey(String key);

}
