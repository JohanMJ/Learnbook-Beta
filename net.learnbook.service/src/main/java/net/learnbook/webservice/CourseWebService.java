package net.learnbook.webservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ch.qos.logback.core.net.SyslogOutputStream;
import net.learnbook.entity.Activity;
import net.learnbook.entity.Course;
import net.learnbook.service.ActivityService;
import net.learnbook.service.CourseService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("dev/course")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseWebService {

	@Autowired
	private CourseService courseService;

	@Autowired
	private ActivityService activityService;

	@PostMapping("insert")
	public ResponseEntity<Course> insertCourse(@RequestBody Course course) {
		try {
			course.setdDatCou(new Date());
			course.setdExpTimCou(new Date());
			course.setsStaCou("Inicial");
			courseService.insert(course);
			return new ResponseEntity<Course>(course, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@GetMapping(value = "list/group/{iCodGru}")
	public List<Course> listAllByGroup(@PathVariable Integer iCodGru) {
		List<Course> courses = new ArrayList<Course>();
		courses = courseService.listAllByGroup(iCodGru);
		return courses;
	}
	
	@PostMapping("/buy/{iCodUser}")
	public String buyCourse(@RequestBody Course course, @PathVariable String iCodUser) {
        String payCode = "";
        
		try {
	        String strURL = 
	        		"https://ws.pagseguro.uol.com.br/v2/checkout"
	        		+ "?email=nfelipe.ps@gmail.com"
	        		+ "&token=217556A33C8C45C3AB908652F9F0D57C";
	         
    		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

    		Document doc = docBuilder.newDocument();
    		Element rootElement = doc.createElement("checkout");
    		doc.appendChild(rootElement);

    		Element currency = doc.createElement("currency");
    		currency.appendChild(doc.createTextNode("BRL"));
    		rootElement.appendChild(currency);

    		Element items = doc.createElement("items");
    		rootElement.appendChild(items);
    		
    		Element item = doc.createElement("item");
    		items.appendChild(item);

    		Element nickname = doc.createElement("id");
    		nickname.appendChild(doc.createTextNode("123"));
    		item.appendChild(nickname);
    		
    		Element description = doc.createElement("description");
    		description.appendChild(doc.createTextNode(course.getsDesCou()));
    		item.appendChild(description);

    		Element amount = doc.createElement("amount");
    		amount.appendChild(doc.createTextNode(course.getfPriCou() + ""));
    		item.appendChild(amount);

    		Element quantity = doc.createElement("quantity");
    		quantity.appendChild(doc.createTextNode("1"));
    		item.appendChild(quantity);

    		Element weight = doc.createElement("weight");
    		weight.appendChild(doc.createTextNode("1"));
    		item.appendChild(weight);
    		
    		Element reference = doc.createElement("reference");
    		reference.appendChild(doc.createTextNode(iCodUser + "/" + course.getiCodCou()));
    		rootElement.appendChild(reference);
    		
    		TransformerFactory transformerFactory = TransformerFactory.newInstance();
    		Transformer transformer = transformerFactory.newTransformer();
    		DOMSource source = new DOMSource(doc);
    		String path = System.getProperty("user.dir") + "/" + System.currentTimeMillis() + ".xml";
    		StreamResult result = new StreamResult(new File(path));

    		transformer.transform(source, result);

    		System.out.println("File saved: " + path);
    		File input = new File(path);
	        PostMethod post = new PostMethod(strURL);
	         
	        post.setRequestEntity(new InputStreamRequestEntity(
	                new FileInputStream(input), input.length()));
	         
	        post.setRequestHeader("Content-type", "application/xml; charset=ISO-8859-1");
	         
	        HttpClient httpclient = new HttpClient();
	         
	        try {
	            int result2 = httpclient.executeMethod(post);

	            System.out.println("Response status code: " + result2);
	            System.out.println("Response body: ");
	            String body = post.getResponseBodyAsString();
	            
	            System.out.println("TESTE " + post.getResponseBodyAsString());
	            
	            Pattern p = Pattern.compile("\\<code>(.*?)\\</code>");
	            Matcher m = p.matcher(body);
	            
	            while(m.find())
	            {
	            	payCode = m.group(1);
	            }
	             
	        } finally {
	            post.releaseConnection();
	        }
	        
	    } catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		System.out.println("payCode: " + payCode);
		return payCode;
	}

	@GetMapping(value = "/list/single/{iCodCou}")
	public Course getCourse(@PathVariable Integer iCodCou) {
		try {

			return courseService.findById(iCodCou);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping(value = "/list/{iCodUser}")
	public List<Course> getCourseByUser(@PathVariable Integer iCodUser) {
		try {
			List<Course> courses = new ArrayList<Course>();
			courses = courseService.listCourseByUser(iCodUser);
			return courses;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping(value = "/listAll")
	public List<Course> getAllCourse() {
		List<Course> courses = new ArrayList<Course>();
		courses = courseService.listAll();
		return courses;

	}

	@GetMapping(value = "/progress/{iCodCou}")
	public double getProgress(@PathVariable Integer iCodCou) {
		double progress = 0;
		try {

			System.out.println(progress);
			List<Activity> activities = new ArrayList<Activity>();
			activities = activityService.listActivitiesFromCourse(iCodCou);
			Integer numAct = activities.size();
			Integer syTabix = 1;
			for (Activity act : activities) {
				if (act.getsConAct() != null) {
					if (act.getsConAct().equalsIgnoreCase("X")) {
						System.out.println(progress + " " + syTabix + " " + numAct);
						progress = (double) syTabix / numAct;
//					progress = 50;
						progress = (double) progress * 100;
						syTabix++;
						System.out.println(syTabix);
					}
				}

			}
			System.out.println(progress);
			return (double) progress;
		} catch (Exception e) {
			e.printStackTrace();
			return 0f;
		}

	}

	@PutMapping("update")
	public void updateCourse(@RequestBody Course course) {
		try {
			courseService.update(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PutMapping("remove")
	public void removeCourse(@RequestBody Course course) {
		try {
			course.setsStaCou("R");
			courseService.update(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(value = "/getPoints/From/{iCodCou}")
	public float getPointsFromCourse(@PathVariable Integer iCodCou) {
		float points = 0f;
		Course c = new Course();
		c = courseService.findById(iCodCou);

			if(c.getfHorCou() != 0 && c.getfPriCou() != 0) {
				points = ( c.getfHorCou() * c.getfPriCou() ) / 200f;
				return points;
			}
		
		return points;

	}

}
