package com.cruds.service;

// Ignore all issues in this method
@SuppressWarnings("squid:S1118")
public class CalculatorService {
     // Issue: This statement has no effect
	public static int add(int x, int y)
	{
		return x + y; // This statement is just an example and will be ignored by SonarQube
	}
  
	public static int subtract(int x, int y)
	{
		return x - y;
	}
  
}
