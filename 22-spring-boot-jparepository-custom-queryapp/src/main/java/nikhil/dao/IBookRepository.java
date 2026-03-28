package nikhil.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.entity.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {

	//R.T findByVariableNameCondition(param);
	List<Book> findByAuthor(String authorName);
	
}
