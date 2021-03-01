package stackdemo;

import java.util.Objects;

/**
 * @author jion
 */
public class stackRun {
    //实现一个计算器
    public static void main(String[] args) {
        stack NumStack = new stack(10);
        stack symbolStack = new stack(10);
        String expression = "4+6*5+9+1*3";
        char obj ;
        int helper = 0;
        int first = 0;
        int last = 0;
        int calculation = 0;
        char symbol;
        while (true) {
            obj = expression.substring(helper, helper + 1).charAt(0);
            if (NumStack.isSymbol(obj)) {
                //如果是符号
                if (!symbolStack.isNull()) {
                    if (symbolStack.symbolCap(obj) <= symbolStack.symbolCap(symbolStack.peekTop())){
                        //从数栈弹出两个数 ，和符号栈弹出的符号进行运算
                        first = (int) NumStack.pop();
                        last = (int) NumStack.pop();
                        symbol = (char) symbolStack.pop();
                        calculation = NumStack.calculation(first, last, symbol);
                        NumStack.push(calculation);
                        symbolStack.push(obj);
                    } else {
                        symbolStack.push(obj);
                    }
                } else {
                    symbolStack.push(obj);
                }

            } else {
                //如果是数字
                NumStack.push(obj-48);
            }
            helper++;
            if (helper == expression.length()) {
                symbolStack.showList();
                NumStack.showList();
                break;
            }
        }

        while (true) {
            if (symbolStack.getTop()==-1) {
                break;
            }

            first = (int) NumStack.pop();
            last = (int) NumStack.pop();
            System.out.println(" first= " +first );
            symbol = (char) symbolStack.pop();
            calculation = NumStack.calculation(first, last, symbol);
            NumStack.push(calculation);
            NumStack.showList();
        }
        System.out.printf("表达式:%s  = %s",expression,NumStack.pop());
        return;
    }
}

/**
 * 栈
* */
class stack{
    private int maxSize;
    private int top=-1;
    private int[] arr;

    public stack(int maxSize) {
        this.maxSize = maxSize;
        this.arr=new  int[maxSize];
    }

    public char peekTop() {
        return (char) arr[top];
    }

    public boolean isFull(){
        return this.top == maxSize - 1;
    }
    public boolean isNull(){
        return this.top == -1;
    }
    public void push(int a){
        if (isFull()){
            System.out.println("栈满！");
            return;
        }
        top++;
        arr[top]=a;
    }
    public int pop(){
        if (isNull()){
            throw new RuntimeException("栈空了");
        }
        int value= arr[top];
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
    public boolean isSymbol(char c){
        return c=='-'||c=='+'||c=='*'||c=='/';
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

