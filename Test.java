import java.util.Arrays;

class Test {
  public static void main(String[] args) {
    //generate all 3 digit numbers
    int[] number = new int[3];
    place_digits(number, 0);
  }

  static void place_digits(int[] number, int start_index){
    for(int digit=0; digit<10; digit++){
      number[start_index] = digit;
      if(start_index == 2){
        System.out.println(Arrays.toString(number));
      }else{
        place_digits(number, start_index+1);
      }
    }
  }
}