package net.codejava.milk.pk;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MilkController {
	@Autowired
	private MilkService millService;

	@RequestMapping("/")
	public ModelAndView home() {
		List<Milk> listMilk = millService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listMilk", listMilk);
		return mav;
	}

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Milk> listMilk = millService.search(keyword);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listMilk", listMilk);
		return mav;
	}

	@RequestMapping("/filter")
	public ModelAndView filter(@RequestParam Long country, @RequestParam Long age, @RequestParam Long company) {
		ArrayList<Long> listCountry = new ArrayList<Long>();
		ArrayList<Long> listAge = new ArrayList<Long>();
		ArrayList<Long> listCompany = new ArrayList<Long>();

		if (country == 0) {
			listCountry.add((long) 1);
			listCountry.add((long) 2);
			listCountry.add((long) 3);
			listCountry.add((long) 4);
		} else {
			listCountry.add((long) country);
		}
		
		if (age == 0) {
			listAge.add((long) 1);
			listAge.add((long) 2);
			listAge.add((long) 3);
			listAge.add((long) 4);
		} else {
			listAge.add((long) age);
		}
		
		if (company == 0) {
			listCompany.add((long) 1);
			listCompany.add((long) 2);
			listCompany.add((long) 3);
			listCompany.add((long) 4);
		} else {
			listCompany.add((long) company);
		}
		
		
		List<Milk> listMilk = millService.filter(listCountry,listAge,listCompany);
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listMilk", listMilk);
		return mav;
	}
}
