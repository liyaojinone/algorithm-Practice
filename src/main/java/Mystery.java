public class Mystery {
    public static void main(String[] args) {
        Mystery mystery = new Mystery();
        mystery.mystert(1234);
    }
    public void mystert(int x){
        System.out.println(x%10);
        if((x/10)!=0){
            mystert(x/10);
        }
        System.out.println(x%10);
    }
}
