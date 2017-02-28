package br.com.bemobi.shortener.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.bemobi.shortener.entity.Shorten;
/**
 * 
 * @author Jefferson Leite
 *
 */
public interface ShortenRepository extends JpaRepository<Shorten, Long> {
	
	
	@Query( "Select s FROM Shorten s WHERE LOWER(s.defaultUrl) = LOWER(?1) " )
	public Shorten findByUrl(String defaultUrl);
	
	
	@Query("select s FROM Shorten s order by click desc")
	List<Shorten> queryFirst10Byclick(Pageable pageable);	 
	 
	 
	 
	 

	/*@Query( "Select s FROM Shorten s WHERE s.shortUrl =?1 " )
	public Shorten findByAlias(Long shortUrl);
	 
	@Query(
            "Select t FROM Todo t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR LOWER(t.description) LIKE LOWER(CONCAT('%', :searchTerm, '%'))"
    )
    public List<Todo> search(@Param("searchTerm") String searchTerm);
	
	@Query(value = "SELECT x FROM User x WHERE x.name LIKE :name% ORDER BY x.id", countQuery = "SELECT COUNT(x) FROM User x WHERE x.name LIKE :name%")
    Page<User> findByNameLike(@Param("name") String name, Pageable page);*/

}
