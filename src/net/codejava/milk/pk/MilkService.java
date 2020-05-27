package net.codejava.milk.pk;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MilkService {
	@Autowired
	MilkRepository repo;

	public List<Milk> listAll() {
		return (List<Milk>) repo.findAll();
	}
	
	public List<Milk> search(String keyword) {
	    return repo.search(keyword);
	}
	
	public List<Milk> filter(List<Long> listcountry,List<Long> listage,List<Long> listcompany) {
	    return repo.filter(listcountry,listage,listcompany);
	}
	
	
}
