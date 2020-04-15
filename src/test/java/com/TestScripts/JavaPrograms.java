package com.TestScripts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class JavaPrograms
{

	@Test(priority=0)
	public void maxnum()
	{
		int num[] = {1,2,5,67,89,77};
		int maxNum =0;
		for (int i = 0; i < num.length; i++)
		{
			if(maxNum<num[i])
			{
				maxNum = num[i];
			}
				
		}
		System.out.println(maxNum);
	}
	
	@Test(priority=1)
	public void removeDuplicateCollection()
	{
		List<String> values = new ArrayList<String>();
		values.add("Bhanu1");
		values.add("Bhanu2");
		values.add("Bhanu3");
		values.add("Bhanu4");
		values.add("Bhanu1");
		values.add("Bhanu3");
		values.add("Bhanu6");
		values.add("Bhanu2");
		
		
		for (int i = 0; i < values.size(); i++)
		{
			for (int j = i+1; j < values.size(); j++)
			{
				if(values.get(i).equals(values.get(j)))
				{
					values.remove(j);
					j--;
				}
			}
		}
		System.out.println(values);
			
	}

	@Test(priority=2)
	public void TwoArraysEqual()
	{
		int num1[] = {1,2,5,6,78,90};
		int num2[] = {1,2,5,6,78,90};
		
		if(num1.length == num2.length)
		{
			for (int i = 0; i < num1.length; i++) 
			{
				if(num1[i]==num2[i])
				{
					System.out.println("both the arrays are same");
				}
			}
		}
		
	}
		
	@Test(priority=3)
	public void commonEleWithin2Array()
	{
		int num1[] = {1,2,5,6,1,5,6,78,90};
		//int num2[] = {1,21,5,68,78,90};
		Set<Integer> count = new HashSet<Integer>();
		
		for (int i = 0; i < num1.length; i++)
		{
			for (int j = i+1; j < num1.length; j++)
			{
				if(num1[i]== num1[j])
				{
					count.add(num1[i]);
				}
			}
		}
		System.out.println(count);
				
	}
	
	@Test(priority=4)
	public void reverseAString()
	{
		String name = "BhanuPrakash";
		String rev ="";
		char nameIs[] = name.toCharArray();
		
		for(int i = nameIs.length; i>0;i--)
		{
			rev = rev + nameIs[i];
		}
		System.out.println(rev);
	}
	
	@Test(priority=5)
	public void split()
	{
		String name = "Bhanu Prakash";
		
		String namesIs[] = name.split(" ");
		
		for (int i = 0; i < namesIs.length; i++) 
		{
			System.out.println(namesIs[i]);
		}
	}
	
	@Test(priority=6)
	public void sort()
	{
		String name = "Bhanu Prakash";
		char nameIs[] = name.toCharArray();
		Arrays.sort(nameIs);
		System.out.println(nameIs);
			
	}
	
	@Test(priority=7)
	public void duplicate()
	{
		List<String> values = new ArrayList<String>();
		
		Map<String, Integer> maps = new  HashMap<String, Integer>();
		
		values.add("Bhanu1");
		values.add("Bhanu2");
		values.add("Bhanu3");
		values.add("Bhanu4");
		values.add("Bhanu2");
		values.add("Bhanu2");
		values.add("Bhanu4");
		
		for (String val : values)
		{
			Integer j = maps.get(val);
			maps.put(val, (j==null)?1:j+1);
		}
		
		for(Map.Entry<String, Integer> ValIs : maps.entrySet())
		{
			System.out.println(ValIs.getKey() + ValIs.getValue());
		}
		
		System.out.println(maps);
		
		
	}
	
	@Test(priority=8)
	public void Prime()
	{
		int num = 23;
		boolean flag = false;
		
		for(int i=2;i<num/2;++i)
		{
			if(num%2==0)
				flag = true;
				break;
				
		}
		
		if(!flag)
		{
			System.out.println("Given num is prime");
		}
	}
	
	@Test(priority=9)
	public void pan()
	{
		int num = 121;
		int r,sum=0;
		int temp=0;
		
		while(num>0)
		{
			r = num%10;
			sum = (sum*10)+r;
			num = num/10;
		}
		if(temp==num) {
			System.out.println("Pass");
		}
		
		
		
		
	}
}