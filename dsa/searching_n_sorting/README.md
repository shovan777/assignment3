# Sorting and Searching Algorithms
## Implementation
- the program can be run with java 8 or higher as

```bash
java -jar searchNSort.jar
```
- the simple program can be run by entering the number for the desired operation (1-6)
- output of binary search

```bash
enter the number you want to search for:
>> 
583
object found at index: 545
data found in 1ms
```

## Benchmark analysis of different sorting algorithms
###### ps: time is displayed in ```ms``` milliseconds

### Analysis with randomly generated unsorted integer arrays
1. 100 iteration were run for 100 different randomly generated array of size 10
```bash
following are the average runtimes for the different sorts
1. Merge Sort: 0.0297029702970297 ms
2. Quick Sort: 0.019801980198019802 ms
3. Insertion Sort: 0.0891089108910891 ms
```
- clearly quicksort beats both merge and insertion sort for small arrays 
- insertion falls behind merge by about ```.06 ms```
- all algorithms have performed on par
----
2. 1000 iteration were run for 1000 different randomly generated array of size 1000
```bash
following are the average runtimes for the different sorts
1. Merge Sort: 0.3465346534653465 ms
2. Quick Sort: 0.06930693069306931 ms
3. Insertion Sort: 0.9108910891089109 ms
```
- here the we see that the insertion sort falls behind merge sort with by about ```.7 ms``` 
- clearly the insertion is lagging much more as ```n``` has increased 100 times
- this is to be expected of insertion which is ```O(n^2)``` whereas both quick and merge are ```O(nlogn)```
- both merge and quick sort perform on par 
----
3. 1000 iteration were run for 10000 different randomly generated array of size 1000
```bash
following are the average runtimes for the different sorts
1. Merge Sort: 1.7326732673267327 ms
2. Quick Sort: 1.2772277227722773 ms
3. Insertion Sort: 53.68316831683168 ms
- the insertion sort is now no match as the order of ```n``` has increased to fifth order
- merge performed very poorly by falling behind merge sort by almost ```52 ms```
```

###### Conclusion
- the above analysis indicates quick sort as clear superior to the other two algorithms, for sorting randomly generated unsorted arrays

----
### Analysis with sorted integer array of size ```1000```
- Insertion Sort took about 0ms.
- Quick Sort took about 8ms.
- Merge Sort took about 1ms.
- The above result is to be expected as Insertion has the least amount of work to do for sorted arrays whereas in merge and quick the state of array does not matter. However, since I have implemented quick sort with the element at tail end to become the pivot, quick has the most units of work to perform which explains the superior performance of merge sort. This analysis indicates that quick sort has unstable performance which depends on the state of array (array being sorted or unsorted).

### Conclusion
- thus, based on above observations I would use merge sort for larger dataset as it has performance on par with quick sort and its performance does not depend on state(sortedness) of array. Also, for smaller arrays which has a higher chance of being sorted and operations where the array to be sorted is most likely sorted I would use Insertion sort.


