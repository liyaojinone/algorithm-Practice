package queen;

public class eightQueens {
    public static void main(String[] args) {
        queens queens = new queens(10,10);
        queens.checkQueen(0);
        System.out.println("解法数量 = " + queens.getRe());
    }

}
class queens{
    private int[] q;
    private int max;
    private int re=0;

    public int getRe() {
        return re;
    }

    public int[] getQ() {
        return q;
    }

    public queens(int cap,int max) {
        this.q= new int[cap];
        this.max=max;
    }
    public boolean nextQueen(int queenId){
        for (int i = 0; i !=queenId ; i++) {
         //八皇后中每个位置不能在同一行 同一列
        if(q[i]==q[queenId] ||Math.abs(queenId-i)==Math.abs(q[queenId]-q[i])){
          return false;
        }
        //  ！错误  if(q[queenId]==q[queenId-1] || q[queenId]==q[queenId-1]+1 || q[queenId]==q[queenId-1]-1){
            //          return false;
            //        }

        }
        return true;
    }
    public void show(){
        for (int i=0;i<q.length;i++){

            System.out.print(q[i]+" ");
        }
        re++;
        System.out.println();
    }
    public void checkQueen(int n){
       if (n==max){
           show();
           return;
       }
        for (int i = 0; i < max; i++) {
            q[n]=i;
            if (nextQueen(n)){
                checkQueen(n+1);
            }

        }
    }
}