package in.bommaipadam.comic.repo;

import org.springframework.data.repository.CrudRepository;

import in.bommaipadam.comic.model.Comic;

public interface ComicRepo extends CrudRepository<Comic, Long> {

}
