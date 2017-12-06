package com.searchsort.binary;

//Java program for implementation of QuickSort
class QuickSort
{

 int partition(Integer arr[], int tail, int head)
 {
     int pivot = arr[head]; 
     int i = (tail-1); // index of smaller element
     for (int j=tail; j<head; j++)
     {
         
         if (arr[j] <= pivot)
         {
             i++;

             // swap arr[i] and arr[j]
             int temp = arr[i];
             arr[i] = arr[j];
             arr[j] = temp;
         }
     }

     // swap arr[i+1] and arr[head] (or pivot)
     int temp = arr[i+1];
     arr[i+1] = arr[head];
     arr[head] = temp;

     return i+1;
 }


 
 void sort(Integer arr[], int tail, int head)
 {
     if (tail < head)
     {
         
         int pi = partition(arr, tail, head);

         // Recursively sort elements before
         // partition and after partition
         sort(arr, tail, pi-1);
         sort(arr, pi+1, head);
     }
 }
}
