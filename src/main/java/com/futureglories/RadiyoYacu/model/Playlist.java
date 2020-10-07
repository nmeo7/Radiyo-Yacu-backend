package com.futureglories.RadiyoYacu.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Playlist {

	@Id
	public String id;
	public String title;
	public User author;
	public List<Audio> audios;

	public Playlist(String title, List<Audio> audios) {
	}
	
	public Playlist() {}
}