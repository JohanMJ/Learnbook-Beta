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

import net.learnbook.entity.Category;
import net.learnbook.service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("dev/category")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryWebService {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("insert")
	public ResponseEntity<Category> insertCategory(@RequestBody Category category) {
		try {
			/*
			 * category.setdDatCou(new Date()); category.setdExpTimCou(new Date());
			 * category.setsStaCou("Inicial");
			 */
			categoryService.insert(category);
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/*
	 * @GetMapping(value = "/list/single/{iCodCou}") public Category
	 * getCategory(@PathVariable Integer iCodCou) { try {
	 * 
	 * return categoryService.findById(iCodCou); } catch (Exception e) {
	 * e.printStackTrace(); return null; } }
	 */

	/*
	 * @GetMapping(value = "/list/{iCodUser}") public List<Category>
	 * getCategoryByUser(@PathVariable Integer iCodUser) { try { List<Category> categories =
	 * new ArrayList<Category>(); categories = categoryService.listCategoryByUser(iCodUser);
	 * return categories; } catch (Exception e) { e.printStackTrace(); return null; }
	 * 
	 * }
	 */

	@GetMapping(value = "listAll")
	public List<Category> getAllCategory() {
		List<Category> categories = new ArrayList<Category>();
		categories = categoryService.listAll();
		return categories;

	}

}
