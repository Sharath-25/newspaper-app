package com.xworkz.newspaper.dao;

import com.xworkz.newspaper.entity.NewsPaperEntity;

public interface NewsPaperDAO {
	boolean saveNewsPaperEntity(NewsPaperEntity newsPaperentity);
	
	NewsPaperEntity getNewsPaperEntity(String newsPaperName);
}
