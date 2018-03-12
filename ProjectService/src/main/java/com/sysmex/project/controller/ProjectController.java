package com.sysmex.project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysmex.project.model.Project;

@RefreshScope
@RequestMapping("/project")
@RestController
public class ProjectController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment environment;
	
	@Value("${project.mission}")
	private String mission;
	
	@RequestMapping("")
	public String getMisssion() {
		return this.mission;
	}
	
	@RequestMapping("/fsoftProject/{id}")
	public String getFsoftProject(@PathVariable int id) {
		String html = "<h3>Fsoft Project Detail:</h3>";		
		Project project = new Project(id, "FsoftProject" + id, getActiveProfile());
		html += "<br/><b>Id:</b>&nbsp;" + project.getId();
		html += "<br/><b>Name:</b>&nbsp;" + project.getName();
		html += "<br/><b>Replica:</b>&nbsp;" + project.getReplica();
		html += "<br/><h3>Spring Project Active Profile: " + getActiveProfile() + "</h3>";
		return html;
	}
	
	@RequestMapping("/fisProject/{id}")
	public String getFISProject(@PathVariable int id) {
		String html = "<h3>FIS Project Detail:</h3>";
		Project project = new Project(id, "FISProject" + id, getActiveProfile());
		html += "<br/><b>Id:</b>&nbsp;" + project.getId();
		html += "<br/><b>Name:</b>&nbsp;" + project.getName();
		html += "<br/><b>Replica:</b>&nbsp;" + project.getReplica();
		html += "<br/><h3>Spring Project Active Profile: " + getActiveProfile() + "</h3>";
		return html;
	}
	
	private String getActiveProfile() {
		String profile = "";
		if (environment.getActiveProfiles().length > 0) {
			profile = environment.getActiveProfiles()[0];
		}
		logger.info("Profile Trip:" + profile);
		return profile;
	}
}