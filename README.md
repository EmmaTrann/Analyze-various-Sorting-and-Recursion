# Analyze-various-Sorting-and-Recursion
Date: February 24, 2020

Java program that times the execution of three sorting algorithms (radix sort, merge sort, quick sort), reports on the run times and whether the algorithms actually sorted the list 

All questions can be found in the "Assignment 1 (1)" file (Cited to COMP2140 course material)

## Report Answer 

cited: code resources based on instructor and course COMP2140 given information.

QUESTION 1: In the main function, increase array size from arraySize= 10K,...,50K by 10K at every step and record sorting times (keep the randomization at 25%, i.e., numSwaps = 0.25 × arraySize) for each algorithm. In your report, crate a table (in text, columns separated by the | character ) of times versus array size for each algorithm. The columns of the table will be 1) alg name, 2) arraySize, 3) time (ms).

    No || Alg Name       || Alg Size || Time(ms)
    ----------------------------------------------------
    1. || Merge Sort    || 10,000   || 858179.8   
         (shared array) || 20,000   || 1729880.86
                        || 30,000   || 2527854.69
                        || 40,000   || 3145588.31
                        || 50,000   || 4161968.7

	2. || Merge Sort    || 10,000   || 4.076364846E7
     (not shared array) || 20,000   || 1.4106805142E8
                        || 30,000   || 3.0675691886E8
                        || 40,000   || 5.0090357094E8
                        || 50,000   || 8.1940670536E8
                        
	3. || Quick Sort    || 10,000   || 605065.06
                        || 20,000   || 1252547.36
                        || 30,000   || 1977969.37
                        || 40,000   || 2747916.88
                        || 50,000   || 3394712.54 
                        
    4. || Radix Sort    || 10,000   || 893895.32
                        || 20,000   || 1597246.04
                        || 30,000   || 2209560.7
                        || 40,000   || 2798808.58
                        || 50,000   || 3324275.83

QUESTION 2: Was merge sort (the efficient version) faster than quick sort? Why or why not? Answer the question for arraySize= 10000, number of swaps=2500.

    Quick sort was faster than merge sort (the efficient version). 
    Because merge sort uses extra space for the temporary array, 
    while quick sort is in-place sorting; therefore, quick sort was faster.
 
QUESTION 3: What is the cost of using the inefficient merge sort vs the merge sort? Answer the question for arraySize= 10000, number of swaps=2500.

    The cost of using inefficient merge sort in this case is 3.9905468660000004E7 ms later. 

QUESTION 4: Was radix sort faster than merge sort (the efficient version)? Answer the question for arraySize= 10000, number of swaps=2500.

    Radix sort was faster than merge sort (the efficient version) in this case. 
