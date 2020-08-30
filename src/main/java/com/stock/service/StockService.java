package com.stock.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.dao.StockRepository;
import com.stock.entity.Stock;

@Service
@Transactional
public class StockService {

	@Autowired
	private StockRepository stockRepository;

	public void insert(Stock stock) {
		stockRepository.save(stock);
	}

	public Optional<Stock> findById(int stockId) {
		return stockRepository.findById(stockId);
	}

	public Iterable<Stock> findAll() {
		return stockRepository.findAll();
	}

	public void updateStock(Stock stock) {
		stockRepository.save(stock);
	}

	public void deleteStock(Stock stock) {
		stockRepository.delete(stock);
	}

}
