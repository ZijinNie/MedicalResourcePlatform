package mchacks9.wuhan.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mchacks9.wuhan.model.Hospital;
import mchacks9.wuhan.model.Request;

public interface RequestRepository extends CrudRepository<Request,Long>{
	List<Request> findByHospital(Hospital hospital);
}
