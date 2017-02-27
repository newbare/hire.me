package br.com.bemobi.shortener.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bemobi.shortener.entity.Shorten;

public interface ShortenRepository extends JpaRepository<Shorten, Long> {
	
	@Query( "Select s FROM Shorten s WHERE s.shortUrl = alias" )
	public Boolean findByAlias(@Param("alias") Long alias);
	

	/*@Query(
            "Select t FROM Todo t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR LOWER(t.description) LIKE LOWER(CONCAT('%', :searchTerm, '%'))"
    )
    public List<Todo> search(@Param("searchTerm") String searchTerm);
	
	@Query(value = "SELECT x FROM User x WHERE x.name LIKE :name% ORDER BY x.id", countQuery = "SELECT COUNT(x) FROM User x WHERE x.name LIKE :name%")
    Page<User> findByNameLike(@Param("name") String name, Pageable page);
}*/
}
