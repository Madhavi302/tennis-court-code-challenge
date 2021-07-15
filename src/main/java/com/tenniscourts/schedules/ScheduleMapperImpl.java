package com.tenniscourts.schedules;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tenniscourts.tenniscourts.TennisCourt;
import com.tenniscourts.tenniscourts.TennisCourtDTO;

@Service
public class ScheduleMapperImpl implements ScheduleMapper{

	@Override
	public Schedule map(ScheduleDTO source) {
		Schedule schedule= new Schedule();
		schedule.setStartDateTime(source.getStartDateTime());
		schedule.setEndDateTime(source.getEndDateTime());
		schedule.setId(source.getId());
		TennisCourt tennisCourt= new TennisCourt();
		tennisCourt.setId(source.getTennisCourt().getId());
		tennisCourt.setName(source.getTennisCourt().getName());
		schedule.setTennisCourt(tennisCourt);
		
		return schedule;
	}

	@Override
	public ScheduleDTO map(Schedule source) {
		ScheduleDTO schedule= new ScheduleDTO();
		schedule.setId(source.getId());
		schedule.setStartDateTime(source.getStartDateTime());
		schedule.setEndDateTime(source.getEndDateTime());
		schedule.setTennisCourtId(source.getTennisCourt().getId());
		TennisCourtDTO tennisCourt= new TennisCourtDTO();
		tennisCourt.setId(source.getTennisCourt().getId());
		tennisCourt.setName(source.getTennisCourt().getName());			
		schedule.setTennisCourt(tennisCourt);
		
		return schedule;
	}

	@Override
	public List<ScheduleDTO> map(List<Schedule> source) {		
		List<ScheduleDTO> schedules= new ArrayList<>();
		source.forEach(sourceSchedule->{
			ScheduleDTO schedule= new ScheduleDTO();
			schedule.setId(sourceSchedule.getId());
			schedule.setStartDateTime(sourceSchedule.getStartDateTime());
			schedule.setEndDateTime(sourceSchedule.getEndDateTime());
			schedule.setTennisCourtId(sourceSchedule.getTennisCourt().getId());
			TennisCourtDTO tennisCourt= new TennisCourtDTO();
			tennisCourt.setId(sourceSchedule.getTennisCourt().getId());
			tennisCourt.setName(sourceSchedule.getTennisCourt().getName());			
			schedule.setTennisCourt(tennisCourt);
			schedules.add(schedule);
		});
		
		return schedules;
	}

}
