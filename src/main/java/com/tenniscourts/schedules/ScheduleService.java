package com.tenniscourts.schedules;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenniscourts.tenniscourts.TennisCourt;

@Service
public class ScheduleService {

	@Autowired
    ScheduleRepository scheduleRepository;

	@Autowired
    ScheduleMapper scheduleMapper;

    public ScheduleDTO addSchedule(Long tennisCourtId, CreateScheduleRequestDTO createScheduleRequestDTO) {
    	Schedule schedule= new Schedule();
    	TennisCourt tennisCourt= new TennisCourt();
    	tennisCourt.setId(tennisCourtId);
    	schedule.setTennisCourt(tennisCourt);
    	schedule.setStartDateTime(createScheduleRequestDTO.getStartDateTime());
    	schedule.setEndDateTime(createScheduleRequestDTO.getStartDateTime().plusHours(1));// guests will play for one hour
    	return scheduleMapper.map(scheduleRepository.save(schedule));
    }

    public List<ScheduleDTO> findSchedulesByDates(LocalDateTime startDate, LocalDateTime endDate) {
        //TODO: implement
        return null;
    }

    public ScheduleDTO findSchedule(Long scheduleId) {
        //TODO: implement
        return null;
    }

    public List<ScheduleDTO> findSchedulesByTennisCourtId(Long tennisCourtId) {
        return scheduleMapper.map(scheduleRepository.findByTennisCourt_IdOrderByStartDateTime(tennisCourtId));
    }
}
