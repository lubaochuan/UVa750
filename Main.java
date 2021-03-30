import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

class Main {
  public static void main(String[] args) throws FileNotFoundException{
    //Scanner scan = new Scanner(new File("input2.txt"));
    Scanner scan = new Scanner(System.in);
    int cases = scan.nextInt();
    for(int i=0; i<cases; i++){
      int row_first = scan.nextInt(); // postion of the first queen
      int col_first = scan.nextInt();
      int sol_num = 1;
      int[] solution = new int[9]; // 1 based index
      System.out.println("SOLN       COLUMN");
      //                  SOLN       COLUMN
      System.out.println(" #      1 2 3 4 5 6 7 8\n");
      //                   #      1 2 3 4 5 6 7 8\n\n
      solution[0] = 1; // solution index, update in place_queen()
      // place the queens starting from the first column
      // recursively: place_queen() calls place_queen
      place_queen(solution, 1, row_first, col_first);

      if(i != cases-1){
        System.out.println();
      }
    }
  }

  static void place_queen(int[] solution, int col, int row_first, int col_first){
    for(int row=1; row<=8; row++){
      solution[col] = row; // in column col pick a row to put next queen
      if(!conflict(solution, col, row_first, col_first)){
        if(col==8){
          //System.out.println(Arrays.toString(solution));
          StringBuilder sb = new StringBuilder();
          for(int i=1; i<=8; i++){
            sb.append(" "+solution[i]);
          }
          System.out.println(" "+solution[0]+"    "+sb);
          solution[0]++;
        }else{
          place_queen(solution, col+1, row_first, col_first);
        }
      }   
    }
  }

  static boolean conflict(int[] solution, int end_index, int row_first, int col_first){
    boolean result = false;
    for(int col=1; col<end_index; col++){
      if((col==col_first && solution[col]!=row_first) // overlap first queen
       || solution[col]==solution[end_index] // two queens in same row
       || Math.abs(col-end_index)==Math.abs(solution[col]-solution[end_index])){ // new queen on a diagonal with a previous queue
        result = true;
        break;
      }
    }
    return result;
  }
}