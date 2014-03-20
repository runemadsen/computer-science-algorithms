// Iterative
// -------------------------------------------------------

int[] selectiveSortIterative(int[] original)
{
  for(int i = 0; i < original.length; i++)
  {
    int smallestIndex = i;

    for(int j = i + 1; j < original.length; j++)
    {
      if(original[j] < original[smallestIndex])
      {
        smallestIndex = j;
      }
    }

    int tempIndex = original[i];
    original[i] = original[smallestIndex];
    original[smallestIndex] = tempIndex;
  }

  return original;
}

// Recursion
// -------------------------------------------------------

int[] selectiveSortRecursive(int[] original, int index)
{
  if(index == original.length-1)  return original;
  
  int smallestIndex = index;
  for(int i = index + 1; i < original.length; i++)
  {
    if(original[i] < original[smallestIndex])
    {
      smallestIndex = i;
    }
  }
  int tempIndex = original[index];
  original[index] = original[smallestIndex];
  original[smallestIndex] = tempIndex;
  return selectiveSortRecursive(original, index + 1);
}

// Go
// -------------------------------------------------------

int[] unsorted = {1, 5, 7, 6, 4, 5, 9, 8, 3, 4, 2};

void setup()
{
  //println(selectiveSortIterative(unsorted));
  println(selectiveSortRecursive(unsorted, 0));
}