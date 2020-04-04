https://www.youtube.com/watch?v=rc2QdQ7U78I&t=246s

Method 1: 

build a map named `brdyTolen`, key is the boundary of a consecutive sequence, value is the length of this consecutive sequence

1. if a number doesn't have left and right neighbor, its length is 1;
2. if a number have left and right neighbor, we update its left boundary and right boundary length
3. if a number just have left or right neighbor, itself is boundary, update itself and its boundary length

![](https://i.imgur.com/GcDJMIh.png)



Method 2:

for a number, find its left boundary and remove all of number from it to left boundary,
then find its right boundary and remove all of number from it to right boundary

calculate the length. 