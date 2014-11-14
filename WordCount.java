// Lucy Brooks 
// 10Te
import java.io.*;
import java.net.*;
import java.util.*;

public class WordCount 
{
  public static void main(String[] args) throws IOException, MalformedURLException 
  {
    URL url = new URL("http://basisphoenix.azurewebsites.net/wp-content/uploads/2014/11/battleship.txt");
    Scanner input = new Scanner(url.openStream());
    String txt = "";
    
      // create an ArrayList of type String to store the unique words
      ArrayList<String>wordList=new ArrayList<String>();
      
      // create an ArrayList of type Integer to store the count of each time the unique word appears
      ArrayList<Integer>wordCount=new ArrayList<Integer>();
      
      while(input.hasNextLine()) {
      // get the next line from the input file
      txt = input.nextLine();
      
      // print the original input
      System.out.println(txt);
      System.out.println();
      
      // call your method countUniqueWords
      countUniqueWords(wordList, wordCount, txt);
      
      // print out number of unique words found, like: "Number of unique words: 23"
      int h=txt.length();
      System.out.println("Number of Unique words: "+h);
      
      System.out.println();
      
      System.out.println("Count\tWord ");
      // for each word in your ArrayList of unique words, print the count followed by a tab and the word
      for(int i=0; i<wordList.size(); i++)
      {
        int k=0;
        k = wordList.get(i).length();
        System.out.println(wordList.set(i, wordList.get(i))+"\t"+k);
      }
      
      
    }
    input.close();
  }
  
  // COMPLETE method countUniqueWords - use wordList to store the unique words in String input with a length > 3 and
  // wordCount to count the number of occurances of each unique word.
  //
  // Parameters:
  //    wordList - an ArrayList of type String to store a sorted list of unique words in the String input
  //    wordCount - an ArraltList of type Integer to store a list of the for each unique word in the String input
  //    input - String of text to be processed
  // Return Type: void
  public static void countUniqueWords(ArrayList<String> wordList, ArrayList<Integer> wordCount, String input) 
  {
    Scanner getWords = new Scanner(input).useDelimiter("[\\W]");
    int index = 0;
    String word = "";
    
    while (getWords.hasNext())
    {
      word=getWords.next();
      if (word.length() > 3)
      {
        if (wordList.indexOf(word)!=-1)
        {
          index=wordList.indexOf(word);
          wordCount.add(index,1);  
        }
        else
        {
          wordList.add(word);
          wordCount.add(1);
        }
      }
    }
    
    getWords.close();
    
    // sort wordList alphabetically, don't forget you will need to swap the values of wordCount
    // anytime you swap values in wordList
    for(int i=0; i<wordList.size()-1; i++)
    {
      String first ="";
      int second=0;
      if(wordList.get(i).compareTo(wordList.get(i+1))>0)
      {
        first =wordList.get(i);
        wordList.set(i, wordList.get(i+1));
        wordList.set(i+1, first);
        
        second=wordCount.get(i);
        wordCount.set(i, wordCount.get(i+1));
        wordCount.set(i+1, second);
        
        i=0;
      }
    }
  }
}
