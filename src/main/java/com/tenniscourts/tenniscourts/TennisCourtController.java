package com.tenniscourts.tenniscourts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tenniscourts.config.BaseRestController;

import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class TennisCourtController extends BaseRestController {

	@Autowired
    private final TennisCourtService tennisCourtService;

	@PostMapping("/addTennisCourt")
	@ApiOperation(value = "Creates a tenniscourt and returns the courtId", response = Long.class)
    public ResponseEntity<Long> addTennisCourt( @RequestBody TennisCourtDTO tennisCourtDTO) {
        return  new ResponseEntity<Long>(tennisCourtService.addTennisCourt(tennisCourtDTO).getId(), HttpStatus.CREATED);
    }

    //TODO: implement rest and swagger
    public ResponseEntity<TennisCourtDTO> findTennisCourtById(Long tennisCourtId) {
        return ResponseEntity.ok(tennisCourtService.findTennisCourtById(tennisCourtId));
    }

    //TODO: implement rest and swagger
    public ResponseEntity<TennisCourtDTO> findTennisCourtWithSchedulesById(Long tennisCourtId) {
        return ResponseEntity.ok(tennisCourtService.findTennisCourtWithSchedulesById(tennisCourtId));
    }
}
