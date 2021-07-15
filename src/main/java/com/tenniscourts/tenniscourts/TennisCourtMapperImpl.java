package com.tenniscourts.tenniscourts;

import org.springframework.stereotype.Service;

@Service
public class TennisCourtMapperImpl implements TennisCourtMapper {

	@Override
	public TennisCourtDTO map(TennisCourt source) {
		TennisCourtDTO tennisCourtDTO= new TennisCourtDTO();
		tennisCourtDTO.setId(source.getId());
		tennisCourtDTO.setName(source.getName());
		return tennisCourtDTO;
	}

	@Override
	public TennisCourt map(TennisCourtDTO source) {
		TennisCourt tennisCourt= new TennisCourt();
		tennisCourt.setId(source.getId());
		tennisCourt.setName(source.getName());
		
		return tennisCourt;
	}

}
