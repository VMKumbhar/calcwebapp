package com.cruds.service;

public class CalculatorService {
    // Ignore all issues in this method
    @SuppressWarnings("squid:S1118")
	public static int add(int x, int y)
	{
	    // Issue: This statement has no effect
		return x + y; // This statement is just an example and will be ignored by SonarQube
	}
  
	public static int subtract(int x, int y)
	{
		return x - y;
	}
  
}
