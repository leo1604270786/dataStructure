package com.zys.test;

import org.junit.Test;

import java.util.*;

/**
 * @program: dataStructure
 * @description: 逆波兰表达式(后缀表达式)
 * @author: Leo
 * @create: 2019-07-28 16:54
 **/
public class ReversePolishNotation {

    /**
     * 计算逆波兰表达式结果
     * 思路：从左至右扫描
     *       1.遇到数字，直接入栈
     *       2.遇到操作符，弹出两个操作数，计算结果，并将结果入栈
     *       3.全部扫描完后，栈中只剩下计算结果，弹出即可
     */
    @Test
    public void calculateExpression(){
        //逆波兰表达式(数字、符号之间用空格隔开)
        String expression = "30 4 + 5 * 6 -";
        //得到表达式中的操作数和操作符列表
        List<String> numsAndOpts = getExpressionList(expression);
        System.out.println("表达式中操作数和操作符：");
        System.out.println(numsAndOpts);

        int result = calculate(numsAndOpts);
        System.out.println("表达式结果=" + result);
    }

    /**
     * 将表达式中的操作数和操作符放入list中
     * @param expression
     * @return
     */
    public List<String> getExpressionList(String expression){
        return Arrays.asList(expression.split(" "));
    }

    /**
     * 计算逆波兰表达式(后缀表达式)的结果
     * @param list
     * @return
     */
    public int calculate(List<String> list){
        //创建一个栈
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        //遍历
        for (String str : list) {
            //判断是数还是操作符
            //数
            if (str.matches("\\d+")){
                //入栈
                stack.push(Integer.parseInt(str));
            }
            //操作符
            else {
                //出栈两个操作数,并计算结果
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (str.charAt(0)) {
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
                        throw new RuntimeException("运算符不合法！");
                }
                //将结果入栈
                stack.push(result);
            }
        }
        return stack.pop();
    }

    /**
     * 将中缀表达式转为后缀表达式
     */
    @Test
    public void infix2reversePolishNotation(){
        //中缀表达式
        String infix = "1+((2+3)*4)-5";
        //后缀表达式 结果为 1 2 3 + 4 * + 5 -
        List<String> list = getInfixNotationList(infix);
        System.out.println("中缀表达式序列：");
        System.out.println(list);
        //定义栈和队列
        Deque<String> stack = new ArrayDeque<>();
        Queue<String> queue = new ArrayDeque<>();
        //遍历中缀表达式列表
        for (String str : list) {
            //如果是一个数，加入队列
            if (str.matches("\\d+")){
                queue.offer(str);
            }
            //如果是左括号
            else if (str.equals("(")){
                stack.push(str);
            }
            //如果是右括号
            else if (str.equals(")")){
                //依次弹出栈中符号，并放入队列，直到遇到左括号
                while (!stack.peekFirst().equals("(")){
                    queue.offer(stack.pop());
                }
                //弹出符号栈中的左括号
                stack.pop();
            }
            //如果是运算符
            else {
                //当str优先级 <= 符号栈顶(可能是左括号)的优先级时，弹出栈顶元素加入到队列中，再次与新栈顶比较优先级
                while (!stack.isEmpty() && priority(str.charAt(0)) <= priority(stack.peekFirst().charAt(0))){
                    queue.offer(stack.pop());
                }
                //将当前符号压入栈中
                stack.push(str);
            }
        }
        //将栈中剩余元素加入到队列中
        while (!stack.isEmpty()){
            queue.offer(stack.pop());
        }
        System.out.println("后缀表达式序列：");
        //队列中的结果即为 后缀表达式（逆波兰表达式）序列
        System.out.println(queue);
        //通过后缀表达式序列求值
        int result = calculate(new ArrayList<>(queue));
        System.out.println("值为：" + result);
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
            //约定只有 + - * / 四种运算符以及()括号
            return -1;
        }
    }

    /**
     * 将中缀表达式转成list返回
     * @param exp
     * @return
     */
    public List<String> getInfixNotationList(String exp){
        List<String> list = new ArrayList<>();
        int len = exp.length();
        char ch = ' ';
        StringBuilder numStr = new StringBuilder();
        for (int i = 0; i < len; i++){
            ch = exp.charAt(i);
            //非数字
            if (ch < 48 || ch > 57){
                list.add(ch+"");
            }
            //数字
            else {
                //连接
                numStr.append(ch);
                //最后一位
                if (i == len -1){
                    list.add(numStr.toString());
                }else {
                    //下一位是否是数字
                    char next = exp.charAt(i+1);
                    //不是数字
                    if (next < 48 || next > 57){
                        list.add(numStr.toString());
                        numStr.setLength(0);
                    }
                }
            }
        }
        return list;
    }
}