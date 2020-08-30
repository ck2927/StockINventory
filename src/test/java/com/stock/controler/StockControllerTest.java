package com.stock.controler;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.stock.controller.StockController;
import com.stock.dao.StockRepository;
import com.stock.entity.Stock;
import com.stock.service.StockService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StockController.class)
public class StockControllerTest {
	
	@Autowired
	private MockMvc mockmvc;
	@InjectMocks
	StockController stockController;
	@Mock
	private StockService stockservice;
	@Mock
	private StockRepository stockRepository;
	
	@Ignore
	@Test
	public void testAddStock() throws Exception {
		//MockHttpServletRequest request = new MockHttpServletRequest();
		//RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		when(stockRepository.save(new Stock())).thenReturn(getStock());
		Stock stock = new Stock(110,808074,"LIC",1450.00,"2020-08-30","2020-08-30",100);
		// assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
       // assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
		
		//when(stockservice.insert(new Stock(110,808074,"LIC",1450.00,"2020-08-30","2020-08-30",100)))
        
        this.mockmvc.perform(MockMvcRequestBuilders.post("/stockinventory/stocks/add")
				.accept(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Ignore
	@Test
	public void testSearchStock() throws Exception {
		int stocknumner = 17;
		Mockito.when(stockservice.findById(stocknumner)).thenReturn(searchStock());
		//Optional<Stock> result = searchStock();
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("http://localhost:8082/stockinventory/stocks/"+stocknumner).accept(org.springframework.http.MediaType.APPLICATION_JSON);
//		MvcResult result = this.mockmvc.perform(requestBuilder).andReturn();
//		System.out.println(" testSearchStock result :: "+result);
//		MockHttpServletResponse response = result.getResponse();
//		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		//assertEquals("http://localhost:8082/stockinventory/stocks/17",
			//	response.getHeader(HttpHeaders.LOCATION));
		this.mockmvc.perform(MockMvcRequestBuilders.get("/stockinventory/stocks/"+stocknumner)
				.accept(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Ignore
	@Test
	public void deleteStock() throws Exception 
	{
		
		mockmvc.perform( MockMvcRequestBuilders.delete("/stockinventory/remove", getStock()) )
	        .andExpect(status().isAccepted());
	}
	
	public Optional<Stock> searchStock() {
		Stock stock = new Stock();
		stock.setLastUpdateDate("2020-08-20");
		stock.setPruchasePrice(185.5);
		stock.setPurchaseDate("2020-08-20");
		stock.setStockId(10852);
		stock.setStockName("TCS");
		stock.setStockNumber(17);
		stock.setStockQuantity(100);
		List<Stock> liststock = new ArrayList();
		liststock.add(stock);
		Optional<Stock> optional = liststock.stream().findFirst();
		return optional;
	}
	
	private Stock getStock() {
		Stock stock = new Stock();
		stock.setLastUpdateDate("2020-08-20");
		stock.setPruchasePrice(125.5);
		stock.setPurchaseDate("2020-08-25");
		stock.setStockId(0);
		stock.setStockName(null);
		stock.setStockNumber(3);
		stock.setStockQuantity(0);
		return stock;
	}

}
