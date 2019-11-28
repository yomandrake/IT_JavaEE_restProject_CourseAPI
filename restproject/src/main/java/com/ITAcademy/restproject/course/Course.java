package com.ITAcademy.restproject.course;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ITAcademy.restproject.topic.Topic;

@Entity
public class Course {
	
	@Id
	private String id;
	private String name;
	private String description;
	
	@ManyToOne
	Topic topic;//Foreign Key
	

	public Course() {
	}
	
	public Course(String id, String name, String description, String topicId) { //Add associated Foreign key
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "","");		
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
		
	}
	public Topic getCourseTopic() {
		return topic;
	}

	public void setCourseTopic(Topic courseTopic) {
		this.topic = courseTopic;
	}
		
}
