package com.futureglories.RadiyoYacu.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.futureglories.RadiyoYacu.model.Audio;

public interface AudioRepository extends MongoRepository<Audio, String> {

  // public Audio findByFirstName(String firstName);
  // public List<Audio> findByLastName(String lastName);

}