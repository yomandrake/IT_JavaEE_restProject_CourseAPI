package com.ITAcademy.restproject.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository myTopicRepository;
	
	////OLD with hardcoded DB
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("spring","SpringFrameworks","SpringFrameworks Description"),
//			new Topic("java","CoreJava","Core Java Description"),
//			new Topic("javascript","Javascript","Javascript Description")));
	
	public  List<Topic> getAllTopics() {
		//return topics;//OLD with hardcoded DB
		List<Topic> allTopics = new ArrayList<>();
		myTopicRepository.findAll().forEach(allTopics::add);
		return allTopics;
		
	}
	
	
	public Optional<Topic> getTopic(String id) {
		//return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		 return myTopicRepository.findById(id);		
	}
	
	public void addTopic(Topic topic) {
		//topics.add(topic);//OLD without Persistence
		myTopicRepository.save(topic);//With CrudRepository 
	}


	public void updateTopic(String id, Topic topic) {
//		for (int i = 0; i < topics.size(); i++) { ////OLD without Persistence
//			if (topics.get(i).getId().equals(id)) {
//				//Update attributes
//				topics.set(i, topic);
//			}
//		}
		myTopicRepository.save(topic);//With CrudRepository 
	}


	public void deleteTopic(String id) {
//		for (int i = 0; i < topics.size(); i++) {
//			if (topics.get(i).getId().equals(id)) {
//				//Update attributes
//				topics.remove(i);
//			}
//		}
		myTopicRepository.deleteById(id);	
	}
	
	
}
