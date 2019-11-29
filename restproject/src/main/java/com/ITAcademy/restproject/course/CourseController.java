package com.ITAcademy.restproject.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.restproject.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	//GET ALL COURSES
	@RequestMapping("/topics/{topicId}/courses")
	public  List<Course> getAllTopics(@PathVariable String topicId){
		return courseService.getAllCourses(topicId); 
	}
	//GET COURSE BY ID
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	//POST COURSE IN WITH TOPIC ID
	@RequestMapping(method=RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addTopic(@PathVariable String topicId, @RequestBody Course course) {
		Topic courseTopic = new Topic(topicId,"","");
		course.setCourseTopic(courseTopic);
		courseService.addCourse(course);
	}
	//PUT or UPDATE COURSE WUITH COURSE ID
	@RequestMapping(method=RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
		Topic courseTopic = new Topic(topicId,"","");
		course.setCourseTopic(courseTopic);
		courseService.updateCourse(course);
	}
	//DELETE COURSE WITH COURSE ID
	@RequestMapping(method=RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
	
	
}
