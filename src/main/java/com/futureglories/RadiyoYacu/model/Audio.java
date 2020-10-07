package com.futureglories.RadiyoYacu.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.mongodb.client.gridfs.model.GridFSFile;

// @Getter
// @Setter
// @ToString(exclude = { "id" })
// @Document(collection = "audio")
public class Audio {

	@Id
	public String id;
	public String title;
	
	// private InputStream stream;
	public GridFSFile stream_id;
	public String stream_checksum;

	public String description;
	public User author;

    public List<Comment> comments;
    public List<Bookmark> bookmarks;

    public int likesCount;
    public int dislikesCount;
    public int playsCount;

	// public List<AudioContent> related;
	
	public Audio (String title)
	{
		this.title = title;
	}

	public Audio () {}
}