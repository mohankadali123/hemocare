package com.programerthings.firstpro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.programerthings.firstpro.dao.AdminRepo;
import com.programerthings.firstpro.dao.BloodBankRepo;
import com.programerthings.firstpro.dao.HospitalRepo;
import com.programerthings.firstpro.dao.UserOtpRepo;
import com.programerthings.firstpro.dao.UsersRepo;
import com.programerthings.firstpro.mail.EmailService;
import com.programerthings.firstpro.model.Admin;
import com.programerthings.firstpro.model.BloodBank;
import com.programerthings.firstpro.model.Hospitals;
import com.programerthings.firstpro.model.UserOtp;
import com.programerthings.firstpro.model.Users;

@Controller
public class HomeController {
	
	@Autowired
	BloodBankRepo repo;
	
	@Autowired
	HospitalRepo hosrepo;
	
	@Autowired
	UserOtpRepo otpRepo;
	
	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	AdminRepo adminRepo;
	
	int adminhid;
	
	Users user = new Users();
    		
	@RequestMapping("home")
	public String home()
	{
		return "home.html";
	}
	
	@RequestMapping("signup")
	public String signup(@ModelAttribute Users formuser)
	{
		user.setEmail(formuser.getEmail());
		user.setPassword(formuser.getPassword());
		user.setName(formuser.getName());
		user.setBloodGroup(formuser.getBloodGroup());
		String otp=generateOTP();
		UserOtp obj = new UserOtp();
		obj.setEmail("dummy@gmail.com");
		obj.setOtp(otp);
		obj.setEmail(formuser.getEmail());
		otpRepo.save(obj);		
		
		String to = formuser.getEmail();
        String subject = "Test Email";
        String body = "Your otp to register is "+otp;
        emailService.sendSimpleEmail(to, subject, body);
		
		return "otpcheck.html";
	}
	
	
	@RequestMapping("signuplogin")
	public String signuplogin()
	{
		return "signuplogin.html";
	}
	
	@RequestMapping("changebb")
	public String change()
	{
		return "changeblood.html";
	}
	
	@RequestMapping("adminlogin")
	public String adminlogin(Model model)
	{
		
		return "adminlogin.html";
	}
	@RequestMapping("adminvalid")
	public String adminvalid(@ModelAttribute Admin admin,Model model)
	{
		System.out.println("username"+admin.getUsername());
		Admin obj= adminRepo.findByUsername(admin.getUsername());
		if(obj==null) return "changeblood.html";
		if(obj.getPassword().equals(admin.getPassword())) {
		 adminhid=obj.getHid();	
		 System.out.println("ADMINHID"+adminhid);
			model.addAttribute("hid", adminhid);
		return "adminhomepage.html";
		}
		return "adminlogin.html";
	}
	
	@RequestMapping("changebbform")
	public String change(BloodBank cbb)
	{
       
		repo.save(cbb);
		return "changebb.html";
	}

	@RequestMapping("showdata")
	public ModelAndView showdata(@RequestParam int hid)
	{
       ModelAndView mv=new ModelAndView();
       BloodBank blood = repo.findById(hid).orElse(null);
       mv.addObject("yourObject",blood);
       mv.setViewName("test.html");
       return mv;
	}
	
	 private EmailService emailService = null;

	    @Autowired
	    public HomeController(EmailService emailService) {
	        this.emailService = emailService;
	    }

	    @RequestMapping("sendmail")
	    public String sendEmail() {
	        String to = "mohankadali374@gmail.com";
	        String subject = "Test Email";
	        String body = "Naku A+ blood kavali.";
	        //emailService.sendSimpleEmail(to, subject, body);
	        //emailService.sendHtmlEmail(to, subject, "mohan");
	        return "home.html";
	    }
	    
	    @RequestMapping("hospitals")
		public ModelAndView hospitals()
		{
	       ModelAndView mv=new ModelAndView();
	       List<Hospitals> objectList = (List<Hospitals>) hosrepo.findAll();
	       mv.addObject("objectList",objectList);
	       mv.setViewName("hospitals.html");
	       return mv;
		}	
	    	  

	    public String generateOTP() {
	        int otpLength = 6;
	        Random random = new Random();
	        StringBuilder otp = new StringBuilder();

	        for (int i = 0; i < otpLength; i++) {
	            otp.append(random.nextInt(10));
	        }
	        
	        return otp.toString();
	    }

	    @RequestMapping("otpage")
		public String otp1()
		{
	    	
			return "otpcheck.html";
		}
	    
	    @RequestMapping("request")
		public String request()
		{
	    	
			return "request.html";
		}
	    
	    @RequestMapping("otpValid")
		public String check(@ModelAttribute UserOtp formotp)
		{ 
	    	UserOtp obj = otpRepo.findByEmail(formotp.getEmail());
	    	if ((obj.getOtp()).equals(formotp.getOtp())) {
	    		usersRepo.save(user);
	    	    return "home.html";
	    	} else {
	    	    return "otpcheck.html";
	    	}
		}
		
	    		
	    @RequestMapping("donorsmail")
		public String donors(@RequestParam String name,@RequestParam String email,@RequestParam String pincode,@RequestParam String phone,@RequestParam String bloodGroup)
		{
	    	List<Users> userlist = usersRepo.findByBloodGroup(bloodGroup);
	    	
	    	for(Users i:userlist) {
	    		emailService.sendHtmlEmail(i.getEmail(), "requesting blood", i.getName(),name,email,pincode,phone,bloodGroup);
	    	}
	    	
	        return "home.html";
		}
	    
	    @RequestMapping("changeblood")
		public String changeblood(@RequestParam String option,@RequestParam String bloodGroup,@RequestParam int integer,Model model)
		{
	    	BloodBank obj=repo.findByHid(adminhid);
	    	if(bloodGroup.equals("A+")) {
	    		int blood=obj.getApos();
	    		if(option.equals("increase"))
	    			obj.setApos(blood+integer);
	    	}
	    	repo.save(obj);
			model.addAttribute("hid", adminhid);
			return "adminhomepage.html";
		}
}














