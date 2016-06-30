package com.sei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * This is a class to remove the duplicate numbers from an array
 * @author      Smitha Prabhu
 * @version     1.0              
 */

public class DuplicateNumber {

	static Logger logger = Logger.getLogger("DuplicateNumber");
	/**
	 *  Array of random integers
	 */
	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
			18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3, 6,
			19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	/**
	 * Main method to invoke the program
	 * @param args
	 */
	public static void main(String[] args) {
		DuplicateNumber dup = new DuplicateNumber();

		logger.info(" removing the duplicates in the array ");
		long start = System.currentTimeMillis();
		Integer [] uniqueIntegers = dup.removedupLinkedHashSet();
		long end = System.currentTimeMillis();
		long ts = end - start;
		logger.info(" remove duplicate using linked hashset completed in time - " + ts);

		for (int j = 0; j < uniqueIntegers.length; j++) {
			
			logger.info(" "+uniqueIntegers[j]);
		}
		
		start = System.currentTimeMillis();
		uniqueIntegers = dup.removedupHashSet();
		end = System.currentTimeMillis();
		ts = end - start;
		logger.info(" remove duplicate using hashset completed in time - " + ts);

		for (int j = 0; j < uniqueIntegers.length; j++) {
						
			logger.info(" "+uniqueIntegers[j]);
		}
		
		start = System.currentTimeMillis();
		int[] whitelist = dup.removeDuplicatesArrays(dup.randomIntegers);
		end = System.currentTimeMillis();
		ts = end - start;
		logger.info(" remove duplicate using arrays completed in time - " + ts);

		for (int j = 0; j < whitelist.length; j++) {
						
			logger.info(" "+whitelist[j]);
		}

		start = System.currentTimeMillis();
		int[] uniqList = dup.removeDuplicatesSortingArray(dup.randomIntegers);
		end = System.currentTimeMillis();
		ts = end - start;
		logger.info(" remove duplicate using sorted arrays completed in time - " + ts);

		for (int j = 0; j < uniqList.length; j++) {
			
			logger.info(" "+uniqList[j]);
		}
		
	}

	/** Removes the duplicate numbers by using the linked hashset which maintains the original order
	 * Advantage - maintains the original order
	 * Disadvantage - slower than hashset
	 * @return the sorted array of integers
	 */
	public Integer[] removedupLinkedHashSet() {

		int end = randomIntegers.length;
		Set<Integer> uniqueSet = new LinkedHashSet<Integer>(); // LinkedHashSet maintains the original order															
		logger.info(" Adding to the LinkedHashSet ");
		for (int i = 0; i < end; i++) {
			uniqueSet.add(randomIntegers[i]);
		}

		logger.info(" Converting the unique set of elements into array ");		
		Integer[] result = new Integer[uniqueSet.size()];
        return uniqueSet.toArray(result);   
	}
	
	
	/**
	 * Removes the duplicate numbers by using the hashset.
	 * Advantage - faster
	 * Disadvantage - doesn't maintain original order
	 * @return the sorted array of integers
	 */
	public Integer[] removedupHashSet() {

		int end = randomIntegers.length;
		Set<Integer> uniqueSet = new HashSet<Integer>(); 
															
		logger.info(" Adding to the HashSet ");
		for (int i = 0; i < end; i++) {
			uniqueSet.add(randomIntegers[i]);
		}
				
		logger.info(" Converting the unique set of elements into array ");
		Integer[] result = new Integer[uniqueSet.size()];
        return uniqueSet.toArray(result);   		
	}
	

	/** Arrays are used to remove the duplicate numbers complexity is O(n2)
	 * Advantage - original order is maintained
	 * Disadvantage - slower  o(n2)
	 * @param arr Integer array input having duplicates
	 * @return  Array of unique integers after removing the duplicate
	 */
	public  int[] removeDuplicatesArrays(int[] arr) {
		int end = arr.length;

		for (int i = 0; i < end; i++) {
			for (int j = i + 1; j < end; j++) {
				if (arr[i] == arr[j]) {					
					arr[j] = arr[end - 1];
					end--;
					j--;
				}
			}
		}

		int[] whitelist = new int[end];		
		System.arraycopy(arr, 0, whitelist, 0, end);
		return whitelist;
	}
	
	

	/** The input array is sorted and the unique elements are placed in the beginning
	 * Advantage - Complexity is O(nlogn) faster than previous array implementation
	 * Disadvantage - The original order is not maintained
	 * @param arr Integer array input having duplicates
	 * @return  Array of unique integers after removing the duplicate
	 */
	public  int[] removeDuplicatesSortingArray(int[] arr){
	        
	        Arrays.sort(arr);
	        int lastNonRepeated = 0;
	        for (int i =  1; i < arr.length; i++){
	            if (arr[i] == arr[lastNonRepeated]){
	                continue;
	            }
	            arr[++lastNonRepeated] = arr[i];
	        }
	        	        
	        int[] answer = new int[lastNonRepeated+1];
	        for (int i = 0; i <= lastNonRepeated; i++){
	            answer[i] = arr[i];
	        }
	        return answer;
	    }

}
