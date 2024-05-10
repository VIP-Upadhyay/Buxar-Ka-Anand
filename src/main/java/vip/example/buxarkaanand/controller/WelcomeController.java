package vip.example.buxarkaanand.controller;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.zxing.WriterException;

import jakarta.servlet.http.HttpSession;
import vip.example.buxarkaanand.model.AppSetting;
import vip.example.buxarkaanand.model.Funds;
import vip.example.buxarkaanand.model.Status;
import vip.example.buxarkaanand.model.Suggestion;
import vip.example.buxarkaanand.model.UserData;
import vip.example.buxarkaanand.service.DataService;
import vip.example.buxarkaanand.service.QRCodeService;

@Controller
public class WelcomeController {
	@Autowired
	DataService service;
	
	@RequestMapping(value = "/")
	public String get(Model model) {
		Funds funds = service.getByKey();
		if(funds==null) {
			funds = service.saveFunds(new Funds(1, "funds", 0));
		}
		AppSetting appSetting = service.getAppSByKey();
		if(appSetting==null) {
			appSetting = new AppSetting();
			appSetting.setKey("setting");
			appSetting = service.saveApp(appSetting);
		}
		model.addAttribute("funds", funds.getTotalFunds());
		System.out.println(appSetting.getPhoneNo());
		model.addAttribute("appSetting", appSetting);
		return "index.jsp";
	}
	
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
	public String set() {
		System.out.println("hello");
		return "admin.html";
	}
	
	@GetMapping(value = "/donate")
	public String value(@ModelAttribute UserData userData,HttpSession model) {
		userData.setStatus(Status.CREATE);
		String transactionNote = generateTransactionCode();
		if(service.getTM(transactionNote)) {
			return value(userData,model);
		}
		userData.setTransactionMessage(transactionNote);
		userData = service.saveUser(userData);
		model.setAttribute("user", userData);
		return "checkout.jsp";
	}
	
	@PostMapping(value = "/suggest")
	public String svalue(@ModelAttribute Suggestion suggestion) {
		service.saveSuggestion(suggestion);
		return "redirect:/";
	}
	
	@Autowired
	QRCodeService qrCodeService;
	
	@GetMapping(value = "/generateQRCodeWithLogo/{amount}", produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<byte[]> generateQRCodeWithLogo(
	        @PathVariable double amount,HttpSession session
	) throws IOException, WriterException {
		if (session.getAttribute("user")!=null) {
			UserData userData =(UserData) session.getAttribute("user");
			String upiId = service.getUpi();
			if (upiId.equals("")) {
				upiId = "exampleupi@ybl";
			}
		    byte[] qrCodeImage = qrCodeService.generateQRCodeWithLogo1(upiId, amount, userData.getTransactionMessage());
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.IMAGE_PNG);
		    headers.setContentLength(qrCodeImage.length);
		    return new ResponseEntity<>(qrCodeImage, headers, HttpStatus.OK);
		}else {
			return null;
		}
		
	}
	
	 @PostMapping("/completePayment")
	    public String completePayment(double amount, Model model,HttpSession session) {
	        // Simulate payment completion
	        if (session.getAttribute("user")!=null) {
				UserData userData =(UserData) session.getAttribute("user");
				if (userData!=null) {
					userData.setStatus(Status.CAPTURE);
					service.saveUser(userData);
					Funds funds = service.getByKey();
					if (funds==null) {
						funds = service.saveFunds(new Funds(1, "funds", 0));
					}
					funds.setTotalFunds(amount+funds.getTotalFunds());
					System.out.println(userData.toString()+" he");
					service.saveFunds(funds);
					session.removeAttribute("user");
				}
			}
	        return "redirect:/";
	    }

	    public String generateTransactionCode() {
	        // Generate a random number between 100000 and 999999
	        Random random = new Random();
	        int randomNumber = random.nextInt(900000) + 100000;
	        return String.valueOf(randomNumber);
	    }

}
