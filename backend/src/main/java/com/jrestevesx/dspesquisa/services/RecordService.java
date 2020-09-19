package com.jrestevesx.dspesquisa.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrestevesx.dspesquisa.dto.RecordDTO;
import com.jrestevesx.dspesquisa.dto.RecordInsertDTO;
import com.jrestevesx.dspesquisa.entities.Game;
import com.jrestevesx.dspesquisa.entities.Record;
import com.jrestevesx.dspesquisa.repositories.GameRepository;
import com.jrestevesx.dspesquisa.repositories.RecordRepository;

@Service
public class RecordService {

	@Autowired
	private RecordRepository  repository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<RecordDTO> findAll(){
		List<Record> list = repository.findAll();
		return list.stream().map(x -> new RecordDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public RecordDTO insert(RecordInsertDTO dto) {
		Record record = new Record();
		
		record.setName(dto.getName());
		record.setAge(dto.getAge());
		record.setMoment(Instant.now());
		
		Game game =  gameRepository.getOne(dto.getGameId());
		record.setGame(game);
		
		record = repository.save(record);
		
		return new RecordDTO(record); 
	}

	@Transactional(readOnly = true)
	public Page<RecordDTO> findByMoments(Instant minDate, Instant maxDate, PageRequest pageRequest) {
		return repository.findByMoments(minDate, maxDate, pageRequest).map(x -> new RecordDTO(x));
	}
}
