import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

   public List<Integer> numbers = new ArrayList<>(6);
   private String category;
   private Character alphabet;
   private int price; 
//   
   private int cnt; // 번호 맞춘 개수
   
   public int getCnt() {
      return cnt;
   }


   public void setCnt(int cnt) {
      this.cnt = cnt;
   }


   public int getPrice() {
      return price;
   }


   public void setPrice(int price) {
      this.price = price;
   }


   public LottoNumber(char alphabet, String category, List<Integer> numbers) {
      this.alphabet = alphabet;
      this.category = category;
      for(int i = 0; i <=5 ; i++) {
         this.numbers.add(numbers.get(i));
      }
   }
   
   
   public Character getAlphabet() { //코딩판 떠난다
      return alphabet;
   }





   public void setAlphabet(Character alphabet) {
      this.alphabet = alphabet;
   }





   public String getNumbers() {
      StringBuilder sb = new StringBuilder();
      for(int a : numbers) {
         sb.append(a).append(" ");
      }
      return sb.toString();
   }





   public String getCategory() {
      return category;
   }





   public void setCategory(String category) {
      this.category = category;
   }





   public void setNumbers( List<Integer> numbers) {
      this.numbers = numbers;
   }





   
   
   
}
