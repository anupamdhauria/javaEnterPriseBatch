package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MoreQueryParamController {

	@GetMapping("/booksinfo")
	public String getMoreInfo(@RequestParam("bookname")String bookName,@RequestParam("bookauthor")String bookAuthor,Model model) {
		String message="Book name :" + bookName +"|"+ " Book author :"+ bookAuthor;
		model.addAttribute("query", message);
		return "index";
	}
}
