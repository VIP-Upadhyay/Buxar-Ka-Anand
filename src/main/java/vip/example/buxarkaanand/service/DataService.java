package vip.example.buxarkaanand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vip.example.buxarkaanand.model.AppSetting;
import vip.example.buxarkaanand.model.Funds;
import vip.example.buxarkaanand.model.Suggestion;
import vip.example.buxarkaanand.model.UserData;
import vip.example.buxarkaanand.repository.AppRepo;
import vip.example.buxarkaanand.repository.FundsRepo;
import vip.example.buxarkaanand.repository.SuggestRepo;
import vip.example.buxarkaanand.repository.UserRepo;

@Service
public class DataService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired 
	FundsRepo fundsRepo;
	
	@Autowired
	AppRepo appRepo;
	
	@Autowired
	SuggestRepo suggestRepo;
	
	public UserData saveUser(UserData userData) {
		return userRepo.save(userData);
	}
	
	public Suggestion saveSuggestion(Suggestion suggestion) {
		return suggestRepo.save(suggestion);
	}
	
	public Funds getByKey() {
		return fundsRepo.findByKey("funds");
	}
	
	public AppSetting getAppSByKey() {
		return appRepo.findByKey("setting");
	}
	
	public Funds saveFunds(Funds fnd) {
		return fundsRepo.save(fnd);
	}
	public AppSetting saveApp(AppSetting fnd) {
		return appRepo.save(fnd);
	}

	public boolean getTM(String tm) {
		return userRepo.existsByTransactionMessage(tm);
	}
	public List<UserData> getPages(int page,int size) {
		Pageable paging = PageRequest.of(page, size,Sort.Direction.DESC,"userId");
		return userRepo.findAll(paging).toList();
	}
	public List<Suggestion> getSPages(int page,int size) {
		Pageable paging = PageRequest.of(page, size,Sort.Direction.DESC,"sId");
		return suggestRepo.findAll(paging).toList();
	}
	public String getUpi(){
		return appRepo.findUpiIdByKey("setting");
	}
}
