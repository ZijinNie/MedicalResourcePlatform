package mchacks9.wuhan.dao;

import org.springframework.data.repository.CrudRepository;

import mchacks9.wuhan.model.Hospital;
import mchacks9.wuhan.model.Request;

public interface HospitalRepository extends CrudRepository<Hospital,String>{
	Hospital findByName(String name);
	Hospital findByUsername(String username);
	boolean existsByName(String name);
	boolean existsByUsername(String username);
//	Hospital findByRequest(Request request);
}
