package com.futureglories.RadiyoYacu.service;

import java.io.IOException;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.futureglories.RadiyoYacu.model.Audio2;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;

@Service
public class Audio2Service {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private GridFsOperations operations;

    public Audio2 getAudio2(String id) throws IllegalStateException, IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        Audio2 video = new Audio2();
        // video.setTitle(file.getMetadata().get("title").toString());
        video.setStream(operations.getResource(file).getInputStream());
        return video;
    }

    public GridFSFile getAudio3(String id) throws IllegalStateException, IOException {
        return gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
    }

    public String addAudio2(String title, MultipartFile file) throws IOException {
        ObjectId id = gridFsTemplate.store(file.getInputStream(), file.getName());
        return id.toString();
    }

}