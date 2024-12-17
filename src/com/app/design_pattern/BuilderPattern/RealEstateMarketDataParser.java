package com.app.design_pattern.BuilderPattern;

public class RealEstateMarketDataParser implements CSVParser {

	@Override
	public void parseCSV() {
		System.out.println("Parsing and preprocessing real estate related CSV data...");
	}
}
