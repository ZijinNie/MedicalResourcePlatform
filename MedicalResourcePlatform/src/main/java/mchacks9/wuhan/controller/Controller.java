package mchacks9.wuhan.controller;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mchacks9.wuhan.dto.*;
import mchacks9.wuhan.model.*;
import mchacks9.wuhan.satausEnum.*;

import mchacks9.wuhan.service.PlatformService;

@CrossOrigin(origins = "*")
@RestController
public class Controller {
	@Autowired
	private PlatformService service;

	@GetMapping(value = {"/getAllRequests"})
	public List<RequestDto> getAllRequests(){
		List<RequestDto> requestDtos = new ArrayList<>();
		for(Request r : service.getAllRequests()) {
			requestDtos.add(convertDto(r));
		}
		return requestDtos;
	}
	@GetMapping(value = {"/getAllHospitals"})
	public List<HospitalDto> getAllHospitals() {
		List<HospitalDto> hDtos = new ArrayList<>();
		List<Hospital> hs = service.getAllHospitals();
		for (Hospital h:hs) {
			hDtos.add(convertDto(h));
		}
		return hDtos;
	}
	
	@GetMapping(value = {"/getAllItems"})
	public List<ItemDto> getAllItems() {
		List<ItemDto> iDtos = new ArrayList<>();
		List<Item> is = service.getAllItems();
		for (Item i:is) {
			iDtos.add(convertDto(i));
		}
		return iDtos;
	}
	
	@GetMapping(value = {"/getAllItemEntrys"})
	public List<ItemEntryDto> getAllItemEntrys() {
		List<ItemEntryDto> ieDtos = new ArrayList<>();
		List<ItemEntry> ies = service.getAllItemEntrys();
		for (ItemEntry ie:ies) {
			ieDtos.add(convertDto(ie));
		}
		return ieDtos;
	}
	

	@GetMapping(value = {"/hospitals/{username}"})
	public HospitalDto getHospital(@PathVariable("username") String username
			) throws IllegalArgumentException{
		Hospital h = service.getHospital(username);
		if(h == null) throw new IllegalArgumentException("Cannot find hospital");
		return convertDto(h);
	}
	
	@PostMapping(value = {"/requestAuto"}, headers="Accept=application/json")
	public RequestDto makeAutoRequest(
			@RequestBody RequestForm form)throws IllegalArgumentException{
		String city = form.getCity();
		String contact = form.getContact();
		String hospital = form.getHospital();
		String address = form.getAddress();
		String state = form.getState();
		String timeString = form.getTime();
		
		System.out.print(timeString);
		
		Time time = java.sql.Time.valueOf(timeString);
		List<ItemEntryDto> itemsDto = form.getItemEntry();
		if( itemsDto == null) {
			throw new IllegalArgumentException("null items");
		}
		Hospital h ;

		h= service.getHospital(hospital);
		if(h==null) {
			h = service.createHospital(hospital, hospital, hospital, city, state, address, hospital, contact);
		}

		List<ItemEntry> itemEntry = new ArrayList<ItemEntry>();
		ItemEntry ie;
		Item i;
		int count = 0;
		for(ItemEntryDto ieDto : itemsDto) {
			ItemDto iDto = ieDto.getItem();
			
			i= service.getItemByName(iDto.getName());
			if(i == null) {
				i = service.createItem(iDto.getName(),iDto.getDescription());
			}
			ie = service.createItemEntry(i, ieDto.getQuantity());
			count += ieDto.getQuantity();
			itemEntry.add(ie);
		}
		
		EmergencyStatus emr ;
		if(count < 5000) {
			emr = EmergencyStatus.LOW;
		}else if(count < 20000) {
			emr = EmergencyStatus.MEDIAN;
		}else emr = EmergencyStatus.HIGH;
		
		Request r = service.createRequest(h, itemEntry, time, emr);
		
		return convertDto(r);
	}

	@PostMapping(value = {"/makeRequest"})
	public RequestDto makeRequest(
			@RequestBody SimpleRequestForm form) throws IllegalArgumentException{
		String hospital = form.getUsername();
		String timeString = form.getTimeString();
		List<ItemEntryDto> itemsDto = form.getItemEntries();
		
		Time time = java.sql.Time.valueOf(timeString);
		if( itemsDto == null) {
			throw new IllegalArgumentException("null items");
		}
		Hospital h ;

		h= service.getHospital(hospital);
		if(h==null) {
			throw new IllegalArgumentException("Hospital does not exist");
		}
		
		List<ItemEntry> itemEntry = new ArrayList<ItemEntry>();
		ItemEntry ie;
		Item i;
		int count = 0;
		for(ItemEntryDto ieDto : itemsDto) {
			ItemDto iDto = ieDto.getItem();
			
			i= service.getItemByName(iDto.getName());
			if(i == null) {
				i = service.createItem(iDto.getName(),iDto.getDescription());
			}
			ie = service.createItemEntry(i, ieDto.getQuantity());
			count += ieDto.getQuantity();
			itemEntry.add(ie);
		}
		
		EmergencyStatus emr ;
		if(count < 5000) {
			emr = EmergencyStatus.LOW;
		}else if(count < 20000) {
			emr = EmergencyStatus.MEDIAN;
		}else emr = EmergencyStatus.HIGH;
		
		Request r = service.createRequest(h, itemEntry, time, emr);
		return convertDto(r);
	}

//	@PostMapping(value = {"/makeRequest/allFilled"})
//	public RequestDto makeRequest(@RequestParam(name = "request") RequestDto rDto) throws IllegalArgumentException{
//		RequestDto rDto = new RequestDto();
//
//	}
	
	@PostMapping(value = {"/register"})
	public HospitalDto register(@RequestParam String username,
	@RequestParam String password,
	@RequestParam String name,
	@RequestParam String city,
	@RequestParam String state,
	@RequestParam String strAddr,
	@RequestParam String description,
	@RequestParam String contact) throws IllegalArgumentException{

		Hospital hospital = service.createHospital(username, password, name, city, state, strAddr, description, contact);
		return convertDto(hospital);
	}
	
	@PostMapping(value = {"/item/{name}"})
	public ItemDto createItem(@PathVariable(name = "name") String name, @RequestParam String description) {
		Item i =service.createItem(name, description);
		return convertDto(i);
	}
	
	
	@PostMapping(value = {"/login"})
	public boolean login(@RequestBody LoginForm loginForm) throws IllegalArgumentException{
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		Hospital h = service.getHospital(username);
		if(h == null) {
			throw new IllegalArgumentException("User Does Not Exist");
		}
		return password.equals(h.getPassword());

	}
	
	// Tool methods
	private String convertEmerEnum(EmergencyStatus s) {
		String res = "";
		if (s == EmergencyStatus.LOW) {
			res = "Low";
		}else if (s == EmergencyStatus.MEDIAN) {
			res = "Median";
		}else if (s == EmergencyStatus.HIGH) {
			res = "High";
		}
		return res;
	}

	private EmergencyStatus convertEmerEnum(String s) {
		if (s == "Low") {
			return EmergencyStatus.LOW;
		}else if (s == "Median") {
			return EmergencyStatus.MEDIAN;
		}else if (s == "High") {
			return EmergencyStatus.HIGH;
		}else {
			return EmergencyStatus.LOW;
		}
	}

	private String convertFulfEnum(FulfillStatus s) {
		String res = "";
		if (s == FulfillStatus.CANCELLED) {
			res = "Cancelled";
		}else if (s == FulfillStatus.FULFILLED) {
			res = "Fullfilled";
		}else if (s == FulfillStatus.ONGOING) {
			res = "Ongoing";
		}
		return res;
	}

	private FulfillStatus convertFulfEnum(String s) {
		if (s == "Cancelled") {
			return FulfillStatus.CANCELLED;
		}else if (s == "Fullfilled") {
			return FulfillStatus.FULFILLED;
		}else if (s == "Ongoing") {
			return FulfillStatus.ONGOING;
		}else {
			return FulfillStatus.CANCELLED;
		}
	}

	private RequestDto convertDto(Request r) {
		List<ItemEntry> ies = r.getItems();
		List<ItemEntryDto> ieDtos = new ArrayList<ItemEntryDto>();
		for (ItemEntry ie: ies) {
			ieDtos.add(convertDto(ie));
		}

		return new RequestDto(r.getRid(),r.getPosttime(),convertEmerEnum(r.getEmerStatus()),
				convertFulfEnum(r.getFulfillStatus()),convertDto(r.getHospital()),ieDtos);
	}

	private ItemEntryDto convertpDto(ItemEntry ie) {
//		return new ItemEntryDto(ie.getIeid(), ie.getQuantity());
		return new ItemEntryDto( ie.getQuantity());

	}

	private ItemDto convertDto(Item i) {
		return new ItemDto(i.getName(),i.getDescription());
	}

	private ItemEntryDto convertDto(ItemEntry ie) {
//		return new ItemEntryDto(ie.getIeid(), ie.getQuantity(), convertDto(ie.getItem()));
		return new ItemEntryDto(ie.getQuantity(), convertDto(ie.getItem()));

	}

	private HospitalDto convertDto(Hospital h) {
		List<Request> rs = h.getRequests();
		List<RequestDto> rDtos = new ArrayList<RequestDto>();
		for (Request r: rs) {
			rDtos.add(convertpDto(r));
		}
		return new HospitalDto(h.getUsername(), h.getPassword(), h.getName(), h.getCity(), h.getState(),
				h.getStrAddr(), h.getDescription(), h.getContact(), rDtos);
	}

	private RequestDto convertpDto(Request r) {
		return new RequestDto(r.getRid(),r.getPosttime(),convertEmerEnum(r.getEmerStatus()),
				convertFulfEnum(r.getFulfillStatus()));
	}

}
