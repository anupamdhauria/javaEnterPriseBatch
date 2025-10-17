package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import in.ineuron.service.IWishMessageService;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class WishMessageController {

	@Autowired
	private IWishMessageService service;
	
	
	/*
	 * @RequestMapping(value="/display",method=RequestMethod.GET) public
	 * ModelAndView showWishMessage() {
	 * 
	 * ModelAndView mv = new ModelAndView(); String msg = service.generateMessage();
	 * mv.addObject("msg",msg); mv.setViewName("display"); return mv;
	 * 
	 * }
	 */
	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String homePage() {
		return "home";
	}
	
	
	
	/*
	 * @RequestMapping(value="/display",method=RequestMethod.GET) public String
	 * showWishMessage(Model model) {
	 * System.out.println("Implementation Class is::"+model.getClass().getName());
	 * String msg=service.generateMessage(); model.addAttribute("msg", msg); return
	 * "display"; }
	 */
	
	/*
	 * @RequestMapping(value="/display",method=RequestMethod.GET) public String
	 * showWishMessage(Map<String,Object> map) {
	 * System.out.println("Implementation Class is::"+map.getClass().getName());
	 * String msg=service.generateMessage(); map.put("msg", msg); return "display";
	 * }
	 */
	
	/*
	 * @RequestMapping(value="/display",method=RequestMethod.GET) public void
	 * showWishMessage(Map<String,Object> map) {
	 * System.out.println("Implementation Class is::"+map.getClass().getName());
	 * String msg=service.generateMessage(); map.put("msg", msg);
	 * 
	 * }
	 */
	
	
	/*
	 * @RequestMapping(value="/display",method=RequestMethod.GET) public void
	 * showWishMessage(HttpServletResponse response) throws IOException {
	 * System.out.println("Implementation Class is::"+response.getClass().getName())
	 * ; String msg=service.generateMessage(); response.setContentType("text/html");
	 * PrintWriter writer =response.getWriter();
	 * writer.println("<br>Hello User::"+msg+"</br>");
	 * 
	 * }
	 */
	
	/*
	 * @RequestMapping(value="/display",method=RequestMethod.GET) public String
	 * showWishMessage(HttpServletResponse response) throws IOException {
	 * System.out.println("Implementation Class is::"+response.getClass().getName())
	 * ; String msg=service.generateMessage(); response.setContentType("text/html");
	 * PrintWriter writer =response.getWriter();
	 * writer.println("<br>Hello User::"+msg+"</br>"); return null;
	 * 
	 * }
	 */
	
	@RequestMapping(value="/display",method=RequestMethod.GET)
	public Map<String,Object> showWishMessage() throws IOException {
		String msg=service.generateMessage();
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("msg", msg);
		return map;
	}
}
