package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//Since jpaRepository extends pagingAndSorting Repository and that internally anyways implements 
//CrudRepository
public interface AlienRepo extends JpaRepository<Alien, Integer> {
	
	/*
	 * These are the predefined query method name format
	 * findBy<property_name><GreaterThan><SmallerThan>
	 * getBy<property_name><GreaterThan><SmallerThan>
	 * 
	 * We can write any complex query by using @Query annotation using jpql
	 * We can give any name to this kind of project
	 * 
	 * */
	
	List<Alien> findByTech(String tech);
	
	List<Alien> findByAidGreaterThan(int aid);
	
	@Query("from Alien where tech=?1 order by aname")
	List<Alien> findByTechSorted(String tech);

}
