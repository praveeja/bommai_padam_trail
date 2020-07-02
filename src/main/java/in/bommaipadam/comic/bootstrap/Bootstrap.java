package in.bommaipadam.comic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.bommaipadam.comic.model.Comic;
import in.bommaipadam.comic.repo.ComicRepo;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {

	private final ComicRepo comicRepo;

	@Override
	public void run(String... args) throws Exception {

		Comic a = new Comic("SpiderMan", "marvelComic", "https://i.imgur.com/H24v3Wk.jpg");
		Comic b = new Comic("BatManIronMan", "marvelComic", "https://i.imgur.com/oenEL9Y.jpg");
		Comic c = new Comic("Stone To Death", "fictional", "https://i.imgur.com/sRlZ0Fy.jpg");
		Comic d = new Comic("Ball Bearers", "fictional", "https://i.imgur.com/k9zrGne.jpg");
		Comic e = new Comic("Half Half", "fictional", "https://i.imgur.com/iHlUT7H.jpg");

		comicRepo.save(a);
		comicRepo.save(b);
		comicRepo.save(c);
		comicRepo.save(d);
		comicRepo.save(e);

		System.out.println("inserted comic " + a.getName());
	}
}
