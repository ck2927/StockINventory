package com.stock.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Stock.findAll", query = "SELECT s FROM Stock s")
public class Stock implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stockNumber;
	@Column
	private int stockId;
	@Column
	private String stockName;
	@Column
	private double pruchasePrice;
	@Column
	private String purchaseDate;
	@Column
	private String lastUpdateDate;
	@Column
	private int stockQuantity;

	public Stock() {
	}

	public Stock(int stockNumber, int stockId, String stockName, double pruchasePrice, String purchaseDate,
			String lastUpdateDate, int stockQuantity) {
		super();
		this.stockNumber = stockNumber;
		this.stockId = stockId;
		this.stockName = stockName;
		this.pruchasePrice = pruchasePrice;
		this.purchaseDate = purchaseDate;
		this.lastUpdateDate = lastUpdateDate;
		this.stockQuantity = stockQuantity;
	}

	@Override
	public String toString() {
		return "Stock [stocknumber=" + stockNumber + ", stockId=" + stockId + ", stockName=" + stockName
				+ ", pruchasePrice=" + pruchasePrice + ", purchaseDate=" + purchaseDate + " , stockQuantity= "
				+ stockQuantity + ", lastUpdateDate= " + lastUpdateDate + "]";
	}

	public int getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getStockId() {
		return stockId;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getPruchasePrice() {
		return pruchasePrice;
	}

	public void setPruchasePrice(double pruchasePrice) {
		this.pruchasePrice = pruchasePrice;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

}
