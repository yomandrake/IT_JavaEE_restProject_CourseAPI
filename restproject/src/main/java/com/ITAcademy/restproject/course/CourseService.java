package com.ITAcademy.restproject.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
////OLD with hardcoded DB
//	private List<Topic> topics = new ArrayList<>(Arrays.asList(
//			new Topic("spring","SpringFrameworks","SpringFrameworks Description"),
//			new Topic("java","CoreJava","Core Java Description"),
//			new Topic("javascript","Javascript","Javascript Description")));
	
	public  List<Course> getAllCourses(String topicId) {
		//return topics;//OLD with hardcoded DB
		List<Course> allCourses = new ArrayList<>();
		courseRepository.findByTopicId(topicId).forEach(allCourses::add);
		return allCourses;
		
	}
	
	
	public Optional<Course> getCourse(String id) {
		//return topics.stream().filter(t-> t.getId().equals(id)).findFirst().get();
		 return courseRepository.findById(id);		
	}
	
	public void addCourse(Course course) {
		//topics.add(topic);//OLD without Persistence
		courseRepository.save(course);//With CrudRepository 
	}


	public void updateCourse(String id, Course course) {
//		for (int i = 0; i < topics.size(); i++) { ////OLD without Persistence
//			if (topics.get(i).getId().equals(id)) {
//				//Update attributes
//				topics.set(i, topic);
//			}
//		}
		courseRepository.save(course);//With CrudRepository 
	}


	public void deleteCourse(String id) {
//		for (int i = 0; i < topics.size(); i++) {
//			if (topics.get(i).getId().equals(id)) {
//				//Update attributes
//				topics.remove(i);
//			}
//		}
		courseRepository.deleteById(id);	
	}
	
	
}
