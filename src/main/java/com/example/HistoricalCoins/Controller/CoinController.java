package com.example.HistoricalCoins.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.HistoricalCoins.Service.CoinService;
import com.example.HistoricalCoins.model.Coin;

@Controller
public class CoinController {
	
	@Autowired
	private CoinService service;
	
	@RequestMapping("/coin/{id}")
	public String addCoin(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
		
		model.addAttribute("coin", service.getCoinById(id));
		
		return "Coin";
	}

	@GetMapping({"/", "viewCoins"})
	public String viewAllToDoItems(Model model, @ModelAttribute("message") String message) {
		model.addAttribute("list", service.getAllCoins());
		model.addAttribute("message", message);
		
		return "ViewCoins";
	}
	
	@GetMapping("/addCoin")
	public String addCoin(Model model) {
		model.addAttribute("newCoin", new Coin());
		System.out.println(model);
		
		return "AddCoin";
	}
	
	
	@PostMapping("/saveCoin")
	public String saveCoin(Coin coin, RedirectAttributes redirectAttributes) {
		if(service.saveOrUpdateCoin(coin)) {
			redirectAttributes.addFlashAttribute("message", "Save Success");
			return "redirect:/viewCoins";
		}
		
		redirectAttributes.addFlashAttribute("message", "Save Failure");
		return "redirect:/addCoin";
	}
	
	@GetMapping("/editCoin/{id}")
	public String editCoin(@PathVariable Long id, Model model) {
		model.addAttribute("coin", service.getCoinById(id));
		
		return "EditCoin";
	}
	
	@PostMapping("/editSaveCoin")
	public String editSaveCoin(Coin coin, RedirectAttributes redirectAttributes) {
		if(service.saveOrUpdateCoin(coin)) {
			redirectAttributes.addFlashAttribute("message", "Edit Success");
			return "redirect:/viewCoins";
		}
		
		redirectAttributes.addFlashAttribute("message", "Edit Failure");
		return "redirect:/editCoin/" + coin.getId();
	}
	
	@GetMapping("/deleteCoin/{id}")
	public String deleteCoinItem(@PathVariable Long id, RedirectAttributes redirectAttributes) {
		if (service.deleteCoin(id)) {
			redirectAttributes.addFlashAttribute("message", "Delete Success");
			return "redirect:/viewCoins";
		}
		
		redirectAttributes.addFlashAttribute("message", "Delete Failure");
		return "redirect:/viewCoins";
	}

}
