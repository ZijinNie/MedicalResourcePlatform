package mchacks9.wuhan.controller;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mchacks9.wuhan.model.Request;
import mchacks9.wuhan.service.PlatformService;

@CrossOrigin(origins = "*")
@RestController
public class Controller {
	@Autowired
	private PlatformService service;
	
	@GetMapping(value = {"/requests"})
	public List<RequestDto> getAllRequests(){
		List<RequestDto> requestDtos = new ArrayList<>();
		for(Request r : service.getAllRequests()) {
			requestDtos.add(convertDto(r));
		}
		return requestDtos;
	}
	
	@PostMapping(value = {"/makeRequest"})
	public RequestDto makeRequest(@RequestParam(name = "hospital") HospitalDto hDto, 
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME, pattern = "YYYY:MM:DD:HH:mm") LocalTime time,
			@RequestParam(name = "emerStatus") String emerStatus,
			@RequestParam(name = "fulfillStatus") String fulfillStatus,
			@RequestParam(name = "items") List<ItemEntryDto> items) throws IllegalArgumentException{
		RequestDto rDto = new RequestDto();
		rDto.set
		
	}
	
	@PostMapping(value = {"/makeRequest/allFilled"})
	public RequestDto makeRequest(@RequestParam(name = "request") RequestDto rDto) throws IllegalArgumentException{
		RequestDto rDto = new RequestDto();
		
	}
	
	private RequestDto convertDto(Request r) {
		return new RequestDto();
	}
}
