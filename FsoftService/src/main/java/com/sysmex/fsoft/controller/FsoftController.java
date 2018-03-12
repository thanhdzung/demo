package com.sysmex.fsoft.controller;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sysmex.fsoft.util.SetProcTimeBean;
import com.sysmex.fsoft.util.Util;

@RestController
@RequestMapping("/fsoft")
public class FsoftController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Util util;
	
	@Autowired
    private SetProcTimeBean setProcTimeBean;
	
	@Value("${service.projectServiceId}")
	private String projectServiceId;
	
	@Value("${service.hrServiceId}")
	private String hrServiceId;
	
	@Autowired
	private Environment environment;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping("")
	public String hello() {
		return "Hello Fsoft!";
	}
	
	@ResponseBody
	@RequestMapping("/project/{id}")
	@HystrixCommand(fallbackMethod = "fallbackMethodFsoftProject")
	public String getFsoftProject(@PathVariable int id) {
		String html = "<h3>Fsoft Project Detail (" + getActiveProfile() + "):</h3>";		
		html += "<br/>";
		
		URI uri = util.getServiceUrl(projectServiceId, "http://localhost:0000/");
		String url = uri.toString() + "/project/fsoftProject/" + id;
		logger.debug("getProject from URL: {}", url);
		ResponseEntity<String> resultStr = restTemplate.getForEntity(url, String.class);
		logger.debug("getProject http-status: {}", resultStr.getStatusCode());
		logger.debug("getProject body: {}", resultStr.getBody());
		
		html += resultStr.getBody();
		return html;
	}
	
	public String fallbackMethodFsoftProject(int id) {
		return "fallbackMethodFsoftProject";
	}
	
	@ResponseBody
	@RequestMapping("/employee/{id}")
	@HystrixCommand(fallbackMethod = "fallbackMethodFsoftEmployee")
	public String getFsoftEmployee(@PathVariable int id) {
		String html = "<h3>Fsoft Employee Detail (" + getActiveProfile() + "):</h3>";		
		html += "<br/>";
		
		URI uri = util.getServiceUrl(hrServiceId, "http://localhost:0000/");
		String url = uri.toString() + "/hr/fsoftEmployee/" + id;
		logger.debug("getEmployee from URL: {}", url);
		ResponseEntity<String> resultStr = restTemplate.getForEntity(url, String.class);
		logger.debug("getEmployee http-status: {}", resultStr.getStatusCode());
		logger.debug("getEmployee body: {}", resultStr.getBody());
		
		html += resultStr.getBody();
		return html;
	}
	
	public String fallbackMethodFsoftEmployee(int id) {
		return "fallbackMethodFsoftEmployee";
	}
	
	@ResponseBody
	@RequestMapping("/fail")
	@HystrixCommand(fallbackMethod = "fallbackMethodFsoftFail")
	public String getFsoftFail() throws Exception {
		throw new Exception("Test Fsoft Fallback");
	}
	
	public String fallbackMethodFsoftFail() {
		return "Inside fallbackMethodFsoftFail";
	}
	
	@ResponseBody
	@RequestMapping("/sleep")
	@HystrixCommand(fallbackMethod = "fallbackMethodTestFsoftleep")
	public String testFsoftSleep() throws Exception {
		int pt = setProcTimeBean.calculateProcessingTime();
        logger.info("/sleep called, processing time: {}", pt);

        sleep(pt);
        
        return "Sleep " + pt;
	}
	
	public String fallbackMethodTestFsoftleep() {
		return "Inside fallbackMethodTestFsoftleep";
	}
	
	private String getActiveProfile() {
		String profile = "";
		if (environment.getActiveProfiles().length > 0) {
			profile = environment.getActiveProfiles()[0];
		}
		logger.info("Profile Trip:" + profile);
		return profile;
	}
	
	private void sleep(int pt) {
        try {
            Thread.sleep(pt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	/**
     * Sample usage:
     *
     *  curl "http://localhost:6110/set-processing-time?minMs=1000&maxMs=2000"
     *
     * @param minMs
     * @param maxMs
     */
    @RequestMapping("/set-processing-time")
    public void setProcessingTime(
        @RequestParam(value = "minMs", required = true) int minMs,
        @RequestParam(value = "maxMs", required = true) int maxMs) {

        logger.info("/set-processing-time called: {} - {} ms", minMs, maxMs);

        setProcTimeBean.setDefaultProcessingTime(minMs, maxMs);
    }
}
