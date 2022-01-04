package com.xworkz.newspaper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.newspaper.dto.NewsPaperDTO;
import com.xworkz.newspaper.service.NewsPaperService;

@Component
@RequestMapping("/")
public class NewsPaperController {

	@Autowired
	private NewsPaperService newsPaperService;

	public NewsPaperController() {
		System.out.println(this.getClass().getSimpleName() + " Created ");
	}

	@RequestMapping("/submitnewspaper.abc")
	public String onSubmitClicked(@ModelAttribute NewsPaperDTO NewsPaperDTO, Model model) {
		System.out.println("Invoked onSubmitClicked()");

		if (this.newsPaperService.validateNewsPaperDTO(NewsPaperDTO)) {
			boolean isSaved = this.newsPaperService.saveNewsPaperDTO(NewsPaperDTO);
			if (isSaved) {
				model.addAttribute("validationMessage", "NewsPaper details have been saved. thank you");
			} else {
				model.addAttribute("validationMessage", "could not save the data. try again ");
			}

		} else {
			model.addAttribute("validationMessage", "Invalid Data try again");
		}

		return "/welcome.jsp";

	}

	@RequestMapping("/searchNewspaper.abc")
	public String onSearchButtonClicked(@RequestParam String searchNewsPaper, Model model) {
		System.out.println("Invoked onSearchButtonClicked()");

		if (this.newsPaperService.validateNewsPaperName(searchNewsPaper)) {
			NewsPaperDTO newsPaperDTO = this.newsPaperService.getNewsPaperDTO(searchNewsPaper);
			if (newsPaperDTO != null) {
				model.addAttribute("NEWSPAPERNAME", newsPaperDTO.getNewsPaperName());
				model.addAttribute("PRICE", newsPaperDTO.getPrice());
				model.addAttribute("LANGAUGE", newsPaperDTO.getLangauge());
				model.addAttribute("NOOFPAGES", newsPaperDTO.getNoOfPages());

				return "/welcome.jsp";
			} else {
				model.addAttribute("NOTFOUND", "newsPaper not Found .Enter valid NewsPaperName");
				return "/welcome.jsp";
			}

		} else {
			model.addAttribute("searchvalidationMessage", "Invalid newspaperName, try again");
		}
		return "/welcome.jsp";

	}

}
