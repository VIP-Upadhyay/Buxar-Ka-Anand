package vip.example.buxarkaanand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vip.example.buxarkaanand.model.UserData;
import vip.example.buxarkaanand.repository.UserRepo;
import vip.example.buxarkaanand.service.DataService;

@RestController
@RequestMapping("admin/api")
public class ApiController {
	
	@Autowired
	DataService service;
	
	@GetMapping(value = "/getUser", produces = "application/json")
	public List<UserData> methodName(@RequestParam(defaultValue = "0") int size,@RequestParam(defaultValue = "25") int page) {
		return service.getPages(page, size);
	}


}
