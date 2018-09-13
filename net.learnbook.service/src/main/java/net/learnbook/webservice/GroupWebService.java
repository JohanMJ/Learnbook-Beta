package net.learnbook.webservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import net.learnbook.entity.Course;
import net.learnbook.entity.Group;
import net.learnbook.service.GroupService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("dev/group")
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupWebService {

	@Autowired
	private GroupService groupService;

	@PostMapping("insert")
	public ResponseEntity<Group> insertGroup(@RequestBody Group group) {
		try {
			if(group != null) {
			float total = 0;
			for(Course c: group.getCourses()) {
				total = total + c.getfPriCou();
			}
			total = total * (0.80f);
			group.setfPriGru(total);
			groupService.insert(group);
			return new ResponseEntity<Group>(group, HttpStatus.OK);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * @GetMapping(value = "/list/single/{iCodCou}") public Group
	 * getGroup(@PathVariable Integer iCodCou) { try {
	 * 
	 * return groupService.findById(iCodCou); } catch (Exception e) {
	 * e.printStackTrace(); return null; } }
	 * 
	 * 
	 * 
	 * @GetMapping(value = "/list/{iCodUser}") public List<Group>
	 * getGroupByUser(@PathVariable Integer iCodUser) { try { List<Group> groups =
	 * new ArrayList<Group>(); groups = groupService.listGroupByUser(iCodUser);
	 * return groups; } catch (Exception e) { e.printStackTrace(); return null; }
	 * 
	 * }
	 */

	@GetMapping(value = "listAll")
	public List<Group> getAllGroup() {
		List<Group> groups = new ArrayList<Group>();
		groups = groupService.listAll();
		return groups;

	}

}
