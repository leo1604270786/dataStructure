package com.zys.test;

import com.zys.stack.arraystack.MyArrayStack;
import com.zys.stack.MyStack;
import org.junit.Before;
import org.junit.Test;

/**
 * @program: dataStructure
 * @description: 顺序栈测试类
 * @author: Leo
 * @create: 2019-05-15 20:41
 **/
public class MyArrayStackTest {
    private MyStack stack;

    @Before
    public void creatStack() {
        stack = new MyArrayStack();
    }

    @Test
    public void testEmpty() {
        System.out.println("栈是否为空：" + stack.isEmpty());
    }

    @Test
    public void testPush() {
        stack.push(22);
        stack.push(29);
        stack.push(74);
        stack.push(51);
        System.out.println("栈是否为空：" + stack.isEmpty());
        System.out.println("栈中元素的个数：" + stack.size());
        printMyStack();
        System.out.println("栈是否为空：" + stack.isEmpty());
    }

    public void printMyStack() {
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }

    @Test
    public void testPeek() {
        stack.push(22);
        stack.push(29);
        System.out.println("栈顶元素为：" + stack.peek());
        stack.pop();
        System.out.println("栈顶元素为：" + stack.peek());
    }

    /**
     * 实现进制的转换 利用栈
     */
    @Test
    public void numberConvertor() {
        //十进制数
        int num = 79;
        //目标进制 2 , 8 , 16
        int target = 16;
        //除数
        int div = num;
        //存储将要入栈的数据
        String dataStr = "0123456789ABCDEF";
        //用栈存储转换后的数据
        while (div != 0) {
            //除target取余
            int mod = div % target;
            //将余数入栈
            stack.push(dataStr.charAt(mod));
            //除数 除target
            div /= target;
        }
        System.out.print(String.format("10 进制数 %s 转化为 %s 进制数：", num, target));
        printMyStack();
    }

    @Test
    public void calculateExpression() {
        String expression = "7*2*2-5+1-5+3-4";
        //定义一个操作数栈
        MyArrayStack numStack = new MyArrayStack();
        //定义一个符号栈
        MyArrayStack optStack = new MyArrayStack();
        //解析表达式
        int len = expression.length();
        int num1 = 0;
        int num2 = 0;
        char opt = ' ';
        int result = 0;
        StringBuilder numStr = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char ch = expression.charAt(i);
            //判断是操作数还是操作符
            boolean operation = isOperation(ch);
            //操作符
            if (operation) {
                //判断符号栈是否为空
                //不为空
                if (!optStack.isEmpty()) {
                    //比较当前符号的优先级和栈顶符号优先级
                    //当前符号优先级较低
                    if (priority(ch) <= priority((Character) optStack.peek())) {
                        num1 = (Integer) numStack.pop();
                        num2 = (Integer) numStack.pop();
                        opt = (Character) optStack.pop();
                        //计算
                        result = calculate(num1, num2, opt);
                        //将计算结果入栈
                        numStack.push(result);
                        //将当前符号入栈
                        optStack.push(ch);
                    }
                    //当前符号优先级较高
                    else {
                        //直接入栈
                        optStack.push(ch);
                    }
                }
                //为空,直接入栈
                else {
                    optStack.push(ch);
                }
            }
            //操作数
            else {
                numStr.append(ch);
                //如果是最后一个数
                if (i == len - 1){
                    numStack.push(Integer.parseInt(numStr.toString()));
                }
                //不是最后一个数
                else {
                    //判断下一个字符是否为数字
                    if (isOperation(expression.charAt(i+1))){
                        numStack.push(Integer.parseInt(numStr.toString()));
                        //清空
                        numStr.setLength(0);
                    }
                }
            }
        }
        //扫描完字符串，根据操作数栈和操作符栈计算结果
        while (!optStack.isEmpty()){
            num1 = (Integer) numStack.pop();
            num2 = (Integer) numStack.pop();
            opt = (Character) optStack.pop();
            //计算
            result = calculate(num1, num2, opt);
            //将计算结果入栈
            numStack.push(result);
        }
        System.out.println("表达式 " + expression + " 结果为：" + numStack.pop());
    }

    /**
     * 返回操作符优先级
     *
     * @param opt 操作符
     * @return
     */
    public int priority(char opt) {
        if ('*' == opt || '/' == opt) {
            return 1;
        } else if ('+' == opt || '-' == opt) {
            return 0;
        } else {
            //约定只有 + - * / 四种运算符
            return -1;
        }
    }

    /**
     * 判断是否为运算符
     *
     * @param val
     * @return
     */
    public boolean isOperation(char val) {
        if ('*' == val || '/' == val || '+' == val || '-' == val) {
            return true;
        }
        return false;
    }

    /**
     * 计算结果
     *
     * @param num1 第一个操作数
     * @param num2 第二个操作数
     * @param opt  运算符
     * @return
     */
    public int calculate(int num1, int num2, char opt) {
        int result = 0;
        switch (opt) {
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num2 / num1;
                break;
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            default:
                break;
        }
        return result;
    }
}