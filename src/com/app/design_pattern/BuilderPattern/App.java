package com.app.design_pattern.BuilderPattern;


public class App {

	public static void main(String[] args) {
		
		
		CSVParser machineLearningParser = new MachineLearningDataParser();
		CSVParser realEstateParser = new RealEstateMarketDataParser();
		CSVParser stockMarketParser = new StockMarketAdapter(new StockMarketDataParser());
		
		machineLearningParser.parseCSV();
		realEstateParser.parseCSV();
		stockMarketParser.parseCSV();
	}
}
