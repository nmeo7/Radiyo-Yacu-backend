package com.futureglories.RadiyoYacu.controller;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;

import com.futureglories.RadiyoYacu.model.Audio;
import com.futureglories.RadiyoYacu.model.Audio2;
import com.futureglories.RadiyoYacu.service.StorageService;
import com.futureglories.RadiyoYacu.service.Audio2Service;

import com.futureglories.RadiyoYacu.repository.AudioRepository;

import com.mongodb.client.gridfs.model.GridFSFile;

// start with the business logic models and proceed with the technical parts.
// here will have to learn the basics of mongo db: parenting kinda thingie.
// well, the project is ready, will just add some simple things just little by little.

@RestController
public class AudioController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

    @Autowired
    private Audio2Service videoService;
    
	@Autowired
	private AudioRepository repository;

	@GetMapping("/greeting")
	public Audio greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Audio(String.format(template, name));// (counter.incrementAndGet(), String.format(template, name));
	}
	
    @GetMapping("/videos2/{id}")
    public void streamVideo(@PathVariable String id, HttpServletResponse response) throws IllegalStateException, IOException {
        Audio2 video = videoService.getAudio2(id);
        FileCopyUtils.copy(video.getStream(), response.getOutputStream());
    }

    @PostMapping("/videos/add")
    public String addVideo(@RequestParam("title") String title, @RequestParam("file") MultipartFile file, Model model) throws IOException, NoSuchAlgorithmException {
        
        byte[] bytes = file.getInputStream().readAllBytes();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] sha256Hash = digest.digest(bytes);
        StringBuilder sb = new StringBuilder();

        for (byte b : sha256Hash) {
            sb.append( String.format("%02x", b).toLowerCase()  );
        }
        System.out.println(">>>");
        System.out.println(sb.toString());
        
        String id = videoService.addAudio2(title, file);
        Audio a = new Audio(title);
        a.stream_id = videoService.getAudio3(id);
        repository.save(a);
        return "redirect:/videos/" + id;
    }
}