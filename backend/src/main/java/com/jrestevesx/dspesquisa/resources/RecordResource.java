package com.jrestevesx.dspesquisa.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrestevesx.dspesquisa.dto.RecordDTO;
import com.jrestevesx.dspesquisa.dto.RecordInsertDTO;
import com.jrestevesx.dspesquisa.services.RecordService;

@RestController
@RequestMapping(value = "/records")
public class RecordResource {
	
	@Autowired
	private RecordService service;
	
	@GetMapping
	public ResponseEntity<List<RecordDTO>> findAll(){
		List<RecordDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto){
		RecordDTO newDTO = service.insert(dto);
		return ResponseEntity.ok().body(newDTO);
	}
}
