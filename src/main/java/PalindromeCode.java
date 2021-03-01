public class PalindromeCode {
    public static void main(String[] args) {

    }

    /**2.回文数
     *
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
     *
     */

    public boolean isPalindrome(int x) {
        long a=0;
        int b=x;


        if(x<0){return false;}
        while (x>0){
            a=a*10+x%10;
            x=x/10;
        }

        return a==b;
    }
}
