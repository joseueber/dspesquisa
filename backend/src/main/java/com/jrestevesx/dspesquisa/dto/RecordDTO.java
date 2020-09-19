package com.jrestevesx.dspesquisa.dto;

import java.io.Serializable;
import java.time.Instant;

import com.jrestevesx.dspesquisa.entities.Record;
import com.jrestevesx.dspesquisa.entities.enums.Platform;

public class RecordDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private int age;
	private Instant moment;
	private String gameTitle;
	private Platform gamePlatform;
	private String genreName;
	
	public RecordDTO(){	
	}
	
	public RecordDTO(Record record) {
		id = record.getId();
		name = record.getName();
		age = record.getAge();
		moment = record.getMoment();
		gameTitle = record.getGame().getTitle();
		gamePlatform = record.getGame().getPlatform();
		genreName = record.getGame().getGenre().getName();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public String getGameTitle() {
		return gameTitle;
	}

	public void setGameTitle(String gameTitle) {
		this.gameTitle = gameTitle;
	}

	public Platform getGamePlatform() {
		return gamePlatform;
	}

	public void setGamePlatform(Platform gamePlatform) {
		this.gamePlatform = gamePlatform;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
	
}
