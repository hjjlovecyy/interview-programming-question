This is the programming question in my java written examination
-----

continuous updating...

#### Question 1: [Judge whether the goods are qualified or not](./src/main/java/or/hjj/interview/TestQualifiedGood.java)
Description:

    Currently there are n items, each of which has three parameters: ai, bi, ci and the definition of unqualified 
    items is based on: if there is j item, so that aj>ai, bj>bi, cj>ci, then i item is unqualified. Output the 
    number of unqualified items. 
    
For Example:

    Input
    3
    1 4 2
    2 4 2
    2 5 3
    
    output
    1
    
Should use standard IO: `System.in` and `System.out`.
#### Question 2: [Generate different String](./src/main/java/or/hjj/interview/CreatUniqueString.java)
Description:

    Use 1-9, a-z and A-Z to generate an ID (Sring) with a length of 4 without repetition. Write two methods, 
    one is to get an ID without repetition and one is to get the total number of generated ids.
    
Two Method:
```Java
// generate str
public String generator() {}
// total number
public int getTotal() {}
```
#### Question 3: [Merge two sorted array to an array](./src/main/java/or/hjj/interview/TwoArrayMerge.java)
Description:

    Two arrays that have been sorted into descending order, merge the two arrays, and remain in descending 
    order after the merge.

Method:
```Java
public static int[] together(int[] A,int[] B) {}
```
#### Question 4": [Find subset according to target](./src/main/java/or/hjj/interview/FindArraySubset.java)
Description:
    
    Given an array(all the values in this array is positive) and a target value, the subsets whose sum is 
    equal to target should be found. The value in the subsets could be repeated.

For Example:

    Input: array={2, 3, 7, 9}, target=9
    
    output: {9}, {2, 7}, {3, 3, 3}, {2, 2, 2, 3}
    
#### Question 5": [Two strings' optimal path](./src/main/java/or/hjj/interview/OptimalPath.java)
Description:
    
    Given two string, one is target string, another is source string.Please calculate how much step can one
    source changing into target. Only deletion and addition can be used.
    
For Example:

    Input: target: "abcd", source: "acc"
    
    output: 3 (1. -c; 2. +b; 3. +d)


### May this repo help you!