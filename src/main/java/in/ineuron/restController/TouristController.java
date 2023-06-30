package in.ineuron.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Tourist;
import in.ineuron.service.ITouristMangService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/tourist")
public class TouristController {

	@Autowired
	private ITouristMangService service;

	@PostMapping("/enroll")
	@ApiOperation("To enroll Tourist Data")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
		System.out.println(tourist);
		String msg = service.saveTouristData(tourist);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}

	@GetMapping("/findAll")
	@ApiOperation("To Display all tourist data")
	public ResponseEntity<?> displayAllTouristData() {
		List<Tourist> list = service.fetchTouristsData();
		return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	@ApiOperation("To search tourist information by id")
	public ResponseEntity<?> getTouristInfo(@PathVariable Integer id) {
		Tourist info = service.findTouristById(id);
		return new ResponseEntity<Tourist>(info, HttpStatus.OK);
	}

	@PutMapping("/modify")
	@ApiOperation("To modify tourist information")
	public ResponseEntity<String> modifyTouristData(@RequestBody Tourist tourist) {
		String msg = service.updateTouristDataByID(tourist);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@PatchMapping("/modifyBudget/{id}/{hike}")
	@ApiOperation("To modify the tourist budget")
	public ResponseEntity<String> modifyTouristBudget(@PathVariable Integer id, @PathVariable Float hike) {
		String msg = service.updateTouristBudgetById(id, hike);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation("To delete the tourist data")
	public ResponseEntity<String> deleteTouristData(@PathVariable Integer id) {
		String msg = service.deleteTouristById(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
