package com.stock.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.entity.Stock;
import com.stock.service.StockService;

/**
 * @author Chandan
 *
 */
@RestController
@RequestMapping("/stocks")
public class StockController {
	private static final Logger log = LoggerFactory.getLogger(StockController.class);
	@Autowired
	private StockService stockService;

	@RequestMapping(method = RequestMethod.GET, value = "/{stockId}")
	public Optional<Stock> searchStock(@PathVariable int stockId) {
		log.info("Stock request ID " + stockId);
		return stockService.findById(stockId);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/purchaseallstock")
	public Iterable<Stock> getAllStock() {
		log.info("All Stock request");
		return stockService.findAll();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public void insertStock(@RequestBody Stock stock) {
		log.info("add Stock request details  " + stock);
		stockService.insert(stock);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update")
	public void updateStock(@RequestBody Stock stock) {
		log.info("update Stock request details  " + stock);
		stockService.updateStock(stock);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/remove")
	public void removeStock(@RequestBody Stock stock) {
		log.info("update Stock request details  " + stock);
		stockService.deleteStock(stock);
	}

}
