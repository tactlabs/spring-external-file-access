package org.tact.base.rest;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/base")
public class BaseController {
	
	/**
	 * 
	 * @return
	 * 
	 * Possible urls:
	 * 		http://localhost:1878/base/
	 */
    @GetMapping(value = "")
    public <T> T testBase() {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }
    
    @RequestMapping(value = "/charset", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody <T> T testCharSet(			
			@RequestParam(value = "spotcd", defaultValue = "4") String spotCD,
			@RequestParam(value = "item_name", required=false) final String name,
			final HttpServletRequest request, 
			final HttpServletResponse response			
	) {
		
		Map<String, Object> map = new LinkedHashMap<>();
		
		print("name : ["+name+"]");
		
		map.put("name", name);
		map.put("apiresult", "000");
		map.put("message", "ok");
		
		return (T) map;
	}
    
    public static void print(Object obj){
    	System.out.println(obj);
    }
    
    /**
     * 
     * @return
     * 
     * possible urls: 
	 * 		/commits
	 * 		/base/commits
	 * 		http://localhost:1878/base/commits
     */
    @GetMapping(value = "/commits")
    public <T> T getCommits() {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
    	
    	map.put(""+getDateInTimestampSeconds(1), 7);
    	map.put(""+getDateInTimestampSeconds(2), 5);
    	for(int i=0;i<40;i++){
    		int r = getRandomNumber(200);
    		int rValue = getRandomNumber(100);
    		map.put(""+getDateInTimestampSeconds(r), rValue);
    	}
        
        //map.put(""+getDateInTimestampSeconds(17), 2);
        
        return (T) map;
    }
    
    // https://stackoverflow.com/questions/4902653/java-util-date-seven-days-ago
    public static Date getDate(int n_days){
    	long DAY_IN_MS = 1000 * 60 * 60 * 24;
    	return new Date(System.currentTimeMillis() - (n_days * DAY_IN_MS));
    }
    
    // https://stackoverflow.com/questions/974973/java-timestamp-how-can-i-create-a-timestamp-with-the-date-23-09-2007
    public static long getDateInTimestamp(int n_days){
    	long DAY_IN_MS = 1000 * 60 * 60 * 24;
    	return (System.currentTimeMillis() - (n_days * DAY_IN_MS));
    }
    
    public static long getDateInTimestampSeconds(int n_days){
    	long DAY_IN_MS = 1000 * 60 * 60 * 24;
    	return (System.currentTimeMillis() - (n_days * DAY_IN_MS)) / 1000;
    }
    
    public static int getRandomNumber(int high){
    	Random r = new Random();
    	int result = r.nextInt(high-0) + 0;
    	
    	return result;
    }
    
    /**
     * 
     * @return
     * 
     * Possible urls:
	 * 		http://localhost:1878/base/img
     */
    @GetMapping(value = "/img")
    public <T> T getImage() {
        
    	Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");
        map.put("seven", "eight");
        
        return (T) map;
    }
}
