package edu.vanderbilt.spring;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Long size;
	private String genre;
	private String url;
	private int likes = 0;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public Long getSize() {
		return size;
	}
	
	public void setSize(Long size){
		this.size = size;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre){
		this.genre = genre;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}
	
	public int getLikes() {
		return likes;
	}
	
	public void setLikes(int likes){
		this.likes = likes;
	}
	//Comments could be a new class with own variables and then represented here by list
}
