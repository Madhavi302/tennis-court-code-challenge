package com.tenniscourts.tenniscourts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenniscourts.exceptions.EntityNotFoundException;
import com.tenniscourts.schedules.ScheduleService;

@Service
public class TennisCourtService {

	@Autowired
    TennisCourtRepository tennisCourtRepository;

	@Autowired
	ScheduleService scheduleService;

	@Autowired
    TennisCourtMapper tennisCourtMapper;

    public TennisCourtDTO addTennisCourt(TennisCourtDTO tennisCourt) {
        return tennisCourtMapper.map(tennisCourtRepository.saveAndFlush(tennisCourtMapper.map(tennisCourt)));
    }

    public TennisCourtDTO findTennisCourtById(Long id) {
        return tennisCourtRepository.findById(id).map(tennisCourtMapper::map).orElseThrow(() -> {
            throw new EntityNotFoundException("Tennis Court not found.");
        });
    }

    public TennisCourtDTO findTennisCourtWithSchedulesById(Long tennisCourtId) {
        TennisCourtDTO tennisCourtDTO = findTennisCourtById(tennisCourtId);
        tennisCourtDTO.setTennisCourtSchedules(scheduleService.findSchedulesByTennisCourtId(tennisCourtId));
        return tennisCourtDTO;
    }
}
