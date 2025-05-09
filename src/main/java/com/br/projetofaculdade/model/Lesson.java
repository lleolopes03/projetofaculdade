package com.br.projetofaculdade.model;

import java.util.Objects;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
public class Lesson {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length=100, nullable = false)
	@NotNull
	@NotBlank
	@Length(min=5,max=100)
	private String name;
	
	@Column(length=11,nullable=false)
	@NotNull
	@NotBlank
	private String youtubeUrl;
	
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name = "course_id",nullable=false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Course course;
	
	public Lesson() {}

	public Lesson(Long id, String name, String youtubeUrl) {
		super();
		this.id = id;
		this.name = name;
		this.youtubeUrl = youtubeUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYoutubeUrl() {
		return youtubeUrl;
	}

	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		return Objects.equals(id, other.id);
	}

    
}
