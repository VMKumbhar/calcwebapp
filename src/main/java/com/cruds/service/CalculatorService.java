package com.cruds.service;

public class CalculatorService {
	
	public static int add(int x, int y)
	{
		return x + y;
	}
    // Issue suppression starts here
    // NOSONAR
	public static int subtract(int x, int y)
	{
		return x - y;
	}
    // Issue suppression ends here
}
