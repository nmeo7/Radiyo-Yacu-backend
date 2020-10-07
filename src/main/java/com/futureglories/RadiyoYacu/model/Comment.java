package com.futureglories.RadiyoYacu.model;

import java.time.LocalDateTime;

public class Comment {

	public User author;
	public String content;
	public LocalDateTime time;

	public Comment(User author, String content) {
	}
}