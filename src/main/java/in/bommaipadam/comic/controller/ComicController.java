package in.bommaipadam.comic.controller;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import in.bommaipadam.comic.model.Comic;
import in.bommaipadam.comic.repo.ComicRepo;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ComicController {

	private final ComicRepo comicRepo;

	@RequestMapping("/all")
	public String all(Model model) {
		model.addAttribute("comics", comicRepo.findAll());
		return "comics/all";
	}

	@RequestMapping("/")
	public String start(Model model) {
		model.addAttribute("comics", comicRepo.findAll());
		return "comics/index";
	}

	@GetMapping("/{id}")
	public String getById(@PathVariable String id, Model model) {
		try {
			Long idLong = Long.parseLong(id);
			Optional<Comic> comic = comicRepo.findById(idLong);
			comic.orElseThrow(() -> new NoSuchElementException("comic For this Id not found"));
			model.addAttribute("comic", comic.get());
			return "comics/single";
		} catch (Exception e) {
			System.out.println("Error here is : " + e);
			return "404/noResult";
		}
	}

}
