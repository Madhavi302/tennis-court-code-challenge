package com.tenniscourts.guests;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tenniscourts.config.BaseRestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@Api(value="tenniscourt", description="Operations pertaining to guests in Tennis court")
public class GuestController extends BaseRestController {

	@Autowired
    private final GuestService guestService;

	@PostMapping("/createGuest")
	@ApiOperation(value = "Create a guest in tennis court", response = Guest.class)
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest) {
        return new ResponseEntity<Guest>(guestService.createGuest(guest),HttpStatus.CREATED);
    }
	
	@PostMapping("/updateGuestById/{id}")
	@ApiOperation(value = "Update a guest in tennis court with the given id", response = Guest.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully updated the guest"),	       
	        @ApiResponse(code = 404, message = "No Guest found with id")
	})
    public ResponseEntity<Guest> updateGuestById(@PathVariable long id, @RequestBody Guest guest) {
        return new ResponseEntity<Guest>(guestService.updateGuest(id, guest),HttpStatus.CREATED);
    }

	@GetMapping("/findGuestById/{id}")
	@ApiOperation(value = "get the guest details by id", response = Guest.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully fetched the guest details by id"),	       
	        @ApiResponse(code = 404, message = "No Guest found with id")
	})
	public ResponseEntity<Guest> findGuestById(@PathVariable long id) {
        return new ResponseEntity<Guest>(guestService.findGuestById(id),HttpStatus.OK);
    }
	
	@GetMapping("/findGuestByName/{name}")
	@ApiOperation(value = "get the guest details by name", response = Guest.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully fetched the guest details by name"),	       
	        @ApiResponse(code = 404, message = "No Guest found with name")
	})
	public ResponseEntity<Guest> findGuestByName(@PathVariable String name) {
        return new ResponseEntity<Guest>(guestService.findGuestByName(name),HttpStatus.OK);
    }
	
	@GetMapping("/findAllGuests")
	@ApiOperation(value = "Fetch all the guests in tenniscourt", response = List.class)	
	public ResponseEntity<List<Guest>> findAllGuests() {
        return new ResponseEntity<List<Guest>>(guestService.findAllGuests(),HttpStatus.OK);
    }
}
