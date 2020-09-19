package com.jrestevesx.dspesquisa.dto;

import java.io.Serializable;
import java.time.Instant;

import com.jrestevesx.dspesquisa.entities.Record;

public class RecordInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private int age;
	private long gameId;
	
	public RecordInsertDTO(){
		
	}
	
	public RecordInsertDTO(Record record) {
		name = record.getName();
		age = record.getAge();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	
}
