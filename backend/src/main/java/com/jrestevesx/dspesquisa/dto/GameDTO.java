package com.jrestevesx.dspesquisa.dto;

import java.io.Serializable;

import com.jrestevesx.dspesquisa.entities.Game;
import com.jrestevesx.dspesquisa.entities.enums.Platform;

public class GameDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private String title;
	private Platform platform;
	
	public GameDTO(){
		
	}
	
	public GameDTO(Game game) {
		id = game.getId();
		title = game.getTitle();
		platform = game.getPlatform();
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Platform getPlatform() {
		return platform;
	}

	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
}
