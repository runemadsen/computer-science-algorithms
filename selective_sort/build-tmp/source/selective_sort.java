import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class selective_sort extends PApplet {

// Iterative
// -------------------------------------------------------

public int[] selectiveSortIterative(int[] original)
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

public int[] selectiveSortRecursive(int[] original, int index)
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

public void setup()
{
  //println(selectiveSortIterative(unsorted));
  println(selectiveSortRecursive(unsorted, 0));
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "selective_sort" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
