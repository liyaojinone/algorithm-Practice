package stackdemo;


import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
//如果是数字那么将其直接入栈到数组num中
//
//3、如果是操作数，需要进一步判断
//
//（1）如果是左括号'('直接入栈到数组opera中
//
//（2）如果是运算符（'+'、'-'、'*'、'/'），先判断数组stack的栈顶的操作数的优先级
// 如果是空栈那么直接入栈到数组opera），如果是左括号那么直接入栈到数组opera中，
// 如果栈顶是运算符，且栈顶运算符的优先级大于该运算符
//
//  那么将栈顶的运算符出栈，并入栈到数组num中，重复步骤3，
// 如果栈顶运算符优先级小于该运算符，那么直接将该运算符入栈到stack中
//
//（3）如果是右括号')'，那么说明在stack数组中一定有一个左括号与之对应（在你没输错的情况下），
// 那么将stack中的运算符依次出栈，并入栈到num中，直到遇到左括号'('（注意左括号不用入栈到num）
//
//4、如果中缀表达式扫描完了，那么将opera中的操作数依次出栈，并入栈到num中就可以了，
// 如果没有没有扫描完重复1-3步
public class ReversePolishNotation {
    public static void main(String[] args) {
        String expression = "(1+2)*(3+4)";
        List<String> ints = StartList(expression);
        Queue<String> transform = transform(ints);
        System.out.println(" ints = " + ints);
        System.out.println("transform ="+transform);
    }

    public static List<String> StartList(String s) {
        List<String> ints = new ArrayList<String>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            //!只能是一位，切割有问题

            String re= String.valueOf(chars[i]);
            ints.add(re);
        }
        return ints;
    }

    public static Queue<String> transform(List<String> S){
        StringStack stack = new StringStack(20);
        Queue<String> queue = new ArrayBlockingQueue<String>(30);
        for (int i = 0; i < S.size(); i++) {

            String s = S.get(i);
            if(!stack.isSymbol(s)){
                queue.add(s);
        // 如果是数字入数组队列
            }else {
//                System.out.println("stackTop=="+stack.getTop()+"   s ==  "+s);
                // 如果是操作符进行判断,是不是空栈 是直接入栈，不是进行判断
                if(stack.isNull()){
                    //空栈
                    stack.push(s);
                }else {
                    int symbolCap = stack.symbolString(s);
//                    System.out.println("symbolCap = " + symbolCap);
                    //非空栈,判断优先级
                    if (symbolCap==2){
                        //说明是“（）”,
                        if ("(".equals(s)){

                            stack.push(s);
                        }else if(")".equals(s)) {
                            String pop="";
                            //如果是右括号')'，那么说明在stack数组中一定有一个左括号与之对应，
                            //// 那么将stack中的运算符依次出栈，并入栈到num中，直到遇到左括号'('
                            while (true){
                                pop= stack.pop();
//                                System.out.println("pop = " + pop);
                                if ("(".equals(pop)){

//                                    System.out.println(" queue = " +queue);
                                    break;
                                }else {
                                    queue.add(pop);
                                    if (stack.isNull()){
                                        break;
                                    }
                                }
                            }
                        }

                    }
                    else {
                        String pop="";
                        int top=-1;
                        while (true){
                            top = stack.symbolString(stack.peekTop());
                            if (top >stack.symbolString(s)&&top!=2){
                                pop = stack.pop();
//                                System.out.println("pop = " + pop);
                                queue.add(pop);
                                if (stack.isNull()){
                                    stack.push(s);
                                    break;
                                }
                            }else {
                                stack.push(s);
                                break;
                            }
                        }
//
                    }

                }
            }

        }
       while (true){
           if (stack.isNull()){
               break;
           }
            String pop = stack.pop();
            queue.add(pop);
        }
        return queue;
    }
}

class StringStack{
    private int maxSize;
    private int top=-1;
    private String[] arr;

    public  StringStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr=new  String[maxSize];
    }

    public  String peekTop() {
        return arr[top];
    }

    public boolean isFull(){
        return this.top == maxSize - 1;
    }
    public boolean isNull(){
        return this.top == -1;
    }
    public void push(String a){
        if (isFull()){
            System.out.println("栈满！");
            return;
        }
        top++;
        arr[top]=a;
    }
    public String pop(){
        if (isNull()){
            throw new RuntimeException("栈空了");
        }
        String value= arr[top];
        top--;
        return value;
    }
    public void showList(){
        if (isNull()){
            throw new RuntimeException("栈空了");
        }
        System.out.println("栈中的数据为");
        for (int i = top; i >=0 ; i--) {
            System.out.println(arr[i]+"\t");
        }
    }
    public boolean isSymbol(String c){
        return "-".equals(c)||"+".equals(c)||"*".equals(c)||"/".equals(c)
                ||"(".equals(c)||")".equals(c);
    }
    public int symbolCap(char symbol){
        if (symbol=='-'||symbol=='+'){
            return 0;
        }else if (symbol=='*'||symbol=='/'){
            return 1;
        }else if (symbol=='('||symbol==')'){
            return 2;
        }else {
            throw new RuntimeException("符号不合法");
        }
    }
    public int symbolString(String symbol){
        switch (symbol){
            case "-":
                return 0;
            case "+":
                return 0;
            case "*":
                return 1;
            case "/":
                return 1;
            case "(":
                return 2;
            case ")":
                return 2;
            default:
                throw new RuntimeException("符号不合法");
        }
    }

    public int calculation(int a , int b , char symbol){
        switch (symbol){
            case '+':
                return a+b;
            case '-':
                return b-a;
            case '*':
                return b*a;
            case '/':
                return b/a;
            default:
                throw new IllegalStateException("Unexpected value: " + symbol);
        }
    }

    public int getTop() {
        return top;
    }
}
