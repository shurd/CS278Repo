package edu.vanderbilt.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExerciseApplicationTests {

	@Autowired
	VideoService videoService;
	
	@Test
	public void contextLoads() {	
	}
	
	@Test
	public void videoServiceLoaded() {
		assertNotNull(videoService);
	}
	
	@Test
	public void addVideoReturnsAListOfVideos() {
		Video video = new Video();
		Iterable<Video> videos = videoService.addVideo(video);
		assertNotNull(videos);
		assertTrue(videos.iterator().hasNext());
	}
	
	//Testing GET /video
	@Test
	public void getAllVideosReturnsAListOfVideos() {
		Video video = new Video();
		videoService.addVideo(video);
		Iterable<Video> videos = videoService.getAllVideos();
		assertNotNull(videos);
		assertTrue(videos.iterator().hasNext());
	}
	
	//Testing POST /video/{id}
	@Test
	public void updateVideoUpdatesVideo() {
		Video video = new Video();
		video.setName("Original");
		videoService.addVideo(video);
		
		
		Video updatedVideo = new Video();
		updatedVideo.setName("Update");
		Iterable<Video> videos = videoService.updateVideo(video.getId(), updatedVideo);
		assertNotNull(videos);
		assertTrue(videos.iterator().hasNext());
		
		assertEquals(videoService.getVideo(video.getId()).getName(), "Update");
	}

	//Test DELETE /video/{id}
	@Test
	public void deleteVideoDeletesVideo() {
		Video video = new Video();
		video.setName("Original");
		videoService.addVideo(video);
		assertNotNull(videoService.getVideo(video.getId()));
		
		videoService.deleteVideo(video.getId());
		
		assertNull(videoService.getVideo(video.getId()));
	}
	
	//Test POST /video with new request body
	@Test
	public void addVideoFullRequestBody() {
		Video video = new Video();
		video.setGenre("Genre");
		video.setName("My name");
		video.setSize((long) 1200);
		video.setUrl("www.url");
		Iterable<Video> videos = videoService.addVideo(video);
		assertNotNull(videos);
		assertTrue(videos.iterator().hasNext());
		
		video = videoService.getVideo(video.getId());
		assertEquals(video.getGenre(), "Genre");
		assertEquals(video.getName(), "My name");
		assertNotNull(video.getSize());
		assertEquals(video.getUrl(), "www.url");
	}
	
	
	
	//OPTIONAL
	@Test
	public void likeVideoAddsLike() {
		Video video = new Video();
		video.setGenre("Genre");
		video.setName("My name");
		video.setSize((long) 1200);
		video.setUrl("www.url");
		video.setLikes(0);
		Iterable<Video> videos = videoService.addVideo(video);
		assertNotNull(videos);
		video = videoService.getVideo(video.getId());
		assertEquals(video.getLikes(), 0);
		// add like
		videoService.likeVideo(video.getId());
		video = videoService.getVideo(video.getId());
		assertEquals(video.getLikes(), 1);
	}
	
	@Test
	public void likeVideoNotOnNull() {
		Video video = videoService.likeVideo((long) 100);
		assertEquals(video, null);
	}
}
