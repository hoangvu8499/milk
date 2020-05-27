package net.codejava.milk.pk;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MilkRepository extends CrudRepository<Milk, Integer> {
	
	@Query(value = "SELECT m FROM Milk m WHERE m.name LIKE '%' || :keyword || '%'")
	public List<Milk> search(@Param("keyword") String keyword);
//	+ "OR c.company LIKE '%' || :keyword || '%'"
	
	@Query(value = "SELECT m FROM Milk m WHERE m.country IN :listcountry AND m.age IN :listage AND m.company IN :listcompany")
	public List<Milk> filter(@Param("listcountry") List<Long> listcountry,
			@Param("listage") List<Long> listage,
			@Param("listcompany") List<Long> listcompany);
	
}
