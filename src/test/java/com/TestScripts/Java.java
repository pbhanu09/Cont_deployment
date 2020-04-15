package com.TestScripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

public class Java 
{

	
	@Test
	public void maxNum()
	{
		int num[] = {1,4,55,3,56,89,56,98};
		
		int maxnum = 0;
		
		for (int i = 0; i < num.length; i++)
		{
			if(maxnum<num[i])
			{
				maxnum = num[i];
				
			}
			
		}
		System.out.println(maxnum);
	}
	
	@Test
	public void removeDuplicateCollection()
	{
		ArrayList<String> values = new ArrayList<String>();
		values.add("Bhanu1");
		values.add("Bhanu2");
		values.add("Bhanu3");
		values.add("Bhanu1");
		values.add("Bhanu2");
		values.add("Bhanu4");
		values.add("Bhanu5");
		
		for (int i = 0; i < values.size(); i++)
		{
			for (int j = i+1; j < values.size(); j++) 
			{
				if(values.get(i).equals(values.get(j)))
				{
					values.remove(j);
				}
			}
			
		}
		System.out.println(values);
		
		
	}
	
	@Test
	public void TwoArraysEqual()
	{
		int num1[] = {1,2,3,4,5,6};
		int num2[] = {1,2,3,4,5,6};
		
		if(num1.length == num2.length)
		{
			for (int i = 0; i < num1.length; i++) 
			{
				if(num1[i] == num2[i])
				{
					System.out.println("values are same");
				}
			}
		}
			
	}
	
	@Test
	public void commonEleWithin2Array()
	{
		int num1[] = {1,2,3,4,5,6};
		int num2[] = {1,6,44,55,32,7};
		HashSet<Integer> val = new HashSet<Integer>();
		
		for (int i = 0; i < num1.length; i++)
		{
			for (int j = 0; j < num2.length; j++)
			{
				if(num1[i] ==num2[j])
				{
					val.add(num1[i]);
				}
			}
		}
		
		System.out.println(val);
		
		
	}
	
	@Test
	public void reverseAString()
	{
		String name = "Bhanuprakash";
		String reverse= "";
		
		char nameIs[] = name.toCharArray();
		
		for (int i = nameIs.length-1; i > 0; i--)
		{
			reverse = reverse + nameIs[i];
		}
		System.out.println(reverse);
		
	}
	
	@Test
	public void splitAString()
	{
		String name = "Bhanu Prakash Is";
		
		String nameIs[] = name.split(" ");
		
		for (int i = 0; i < nameIs.length; i++)
		{
			String val = nameIs[i];
			System.out.println(val);
		}
	}
	
	@Test
	public void Sort()
	{
		String name = "bhanuprakash";
		char nameIs[] = name.toCharArray();
		Arrays.sort(nameIs);
		System.out.println(nameIs);
	}
	
	@Test
	public void duplicateAndCount()
	{
		ArrayList<String> values = new ArrayList<String>();
		Map<String,Integer> maps = new  HashMap<String,Integer>();
		
		values.add("Bhanu1");
		values.add("Bhanu1");
		values.add("Bhanu3");
		values.add("Bhanu2");
		values.add("Bhanu7");
		values.add("Bhanu3");
		values.add("Bhanu3");
		values.add("Bhanu3");
		
		for (String string : values)
		{
			Integer j = maps.get(string);
			maps.put(string, (j == null)?1: j+1);
		}
		
		for(Map.Entry<String, Integer> val : maps.entrySet())
		{
			System.out.println(val.getKey() + val.getValue());
			
		}
		System.out.println(maps);
		
	}
	
	@Test
	public void PrimeNumber()
	{
		int num = 59;
		boolean flag = false;
		
		for (int i = 2; i <+ num/2; ++i)
		{
			if(num % 2==0)
			{
				flag= true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println(num + "is a prime number");
		}
		
		
	}
	
	@Test
	public void Palindrome()
	{
		int num = 454;
		int r,sum =0;
		int temp=0;
		
		while(num>0)
		{
			r= num%10;
			sum = (sum*10)+r;
			num = num/10;
			
		}
		if(temp==sum) {
			System.out.println("ele is palindrone");
		}
	}
}
