package com.xworkz.newspaper.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.newspaper.dao.NewsPaperDAO;
import com.xworkz.newspaper.dto.NewsPaperDTO;
import com.xworkz.newspaper.entity.NewsPaperEntity;

@Component
public class NewsPaperServiceImpl implements NewsPaperService {

	@Autowired
	private NewsPaperDAO newsPaperDAO;

	public NewsPaperServiceImpl() {
		System.out.println(this.getClass().getSimpleName() + " Created ");
	}

	@Override
	public boolean validateNewsPaperDTO(NewsPaperDTO newsPaperDTO) {
		System.out.println("Invoked validateNewsPaperDTO()");
		boolean flag = false;

		if (newsPaperDTO.getNewsPaperName() != null && !newsPaperDTO.getNewsPaperName().isEmpty()) {
			flag = true;

		} else {
			flag = false;
			System.out.println("Invalid NewsPaperName");
			return flag;
		}

		if (newsPaperDTO.getLangauge() != null && !newsPaperDTO.getLangauge().isEmpty()) {
			flag = true;

		} else {
			flag = false;
			System.out.println("Invalid Langauge");
			return flag;
		}
		if (newsPaperDTO.getPrice() > 0) {
			flag = true;

		} else {
			flag = false;
			System.out.println("Invalid price");
			return flag;
		}
		if (newsPaperDTO.getNoOfPages() > 0) {
			flag = true;

		} else {
			flag = false;
			System.out.println("Invalid noofpages");
			return flag;
		}

		return flag;

	}

	@Override
	public boolean saveNewsPaperDTO(NewsPaperDTO newsPaperDTO) {

		NewsPaperEntity newsPaperEntity = new NewsPaperEntity();
		BeanUtils.copyProperties(newsPaperDTO, newsPaperEntity);
		boolean result = this.newsPaperDAO.saveNewsPaperEntity(newsPaperEntity);

		return result;
	}

	@Override
	public boolean validateNewsPaperName(String newsPaperName) {

		System.out.println("Invoked validateNewsPaperName()");
		boolean flag = false;

		if (!newsPaperName.isEmpty() && newsPaperName != null) {
			flag = true;
			return flag;
		} else {
			flag = false;
			System.out.println("Invalid NewsPaperName");
			return flag;
		}

	}

	@Override
	public NewsPaperDTO getNewsPaperDTO(String newsPaperName) {
		System.out.println("Invoked getNewsPaperDTO()");
		NewsPaperEntity entity = this.newsPaperDAO.getNewsPaperEntity(newsPaperName);

		if (entity != null) {
			NewsPaperDTO dto = new NewsPaperDTO();
			BeanUtils.copyProperties(entity, dto);
			return dto;

		} else {
			return null;
		}
	}

}
