package com.stock.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stock.entity.Stock;

@Repository
public interface StockRepository extends CrudRepository<Stock,Integer> {

	/*
	 * public void save(Stock stock) { // TODO Auto-generated method stub }
	 */

	/*
	 * public List<Stock> findById(int id) {
	 * 
	 * List<Stock> listStock = Arrays.asList(new
	 * Stock(1010,"Tata Moters",101.20,"30-12-2019",100)); return listStock; }
	 */

}
