package com.xworkz.newspaper.service;

import com.xworkz.newspaper.dto.NewsPaperDTO;

public interface NewsPaperService {
	boolean validateNewsPaperDTO(NewsPaperDTO newsPaperDTO);
	
	boolean saveNewsPaperDTO(NewsPaperDTO newsPaperDTO );
	
	boolean validateNewsPaperName(String newsPaperName);
	
	NewsPaperDTO getNewsPaperDTO(String newsPaperName);
}
