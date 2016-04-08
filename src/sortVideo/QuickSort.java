package sortVideo;

/**
 * Version 0.1
 * @author Harrison
 * 4-8-16
 */

import java.util.*;

public class QuickSort 
{
/**
 * Main method.
 * @param args
 */
	public static void main(String [] args)
	{
		QuickSort video = new QuickSort();
		
		List<Integer> input = video.generateRandomNumbers(35);
		
		//Before application.
		System.out.println(input);
		
		//After application.
		System.out.println(video.quicksort(input));
	}
	
	/**
	 * Sorts 35 integers in list with quicksort algorithmn.
	 * 
	 */
	
	private List<Integer> quicksort(List<Integer> input)
	{
		if (input.size() <= 1)
		{
			return input;
		}
		
		int middle = (int) Math.ceil((double)input.size() / 2);
		int pivot = input.get(middle);
		
		List<Integer> less = new ArrayList<Integer>();
		List<Integer> greater = new ArrayList<Integer>();
		
		for(int i = 0; i < input.size(); i++)
		{
			if(input.get(i) <= pivot)
			{
				if(i == middle)
				{
					continue;
				}
				less.add(input.get(i));
			}
			else
			{
				greater.add(input.get(i));
			}
		}
		return concatenate(quicksort(less), pivot, quicksort(greater));
	}
	
	private List<Integer> concatenate(List<Integer> less, int pivot, List<Integer> greater)
	{
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < less.size(); i++)
		{
			list.add(less.get(i));
		}
		
		list.add(pivot);
		
		for(int i = 0; i < greater.size(); i++)
		{
			list.add(greater.get(i));
		}
		
		return list;
	}
	
	/**
	 * Finally generates random numbers after quicksort algorithmn.
	 */
	
	private List<Integer> generateRandomNumbers(int n)
	{
		List<Integer> list = new ArrayList<Integer>(n);
		Random random = new Random();
		
		for(int i=0; i < n; i++)
		{
			list.add(random.nextInt(n * 10));
		}
		return list;
	}
	
}
