package interpreter;

import java.util.Stack;

public class Interpreter implements Expression{
    Expression evaluate;

    public Interpreter(String expression){
        Stack<Expression> expressions = new Stack<>();
        String expressionRevert = new StringBuilder(expression).reverse().toString();

        for (String s : expressionRevert.split("\\D")) {
            expressions.push(new NumberExpression(Integer.parseInt(s)));
        }

        for (String s : expression.split("\\d")){
            if (s.equals("+")){
                expressions.push(new OpertationExpression(expressions.pop(), expressions.pop(), '+'));
            } else if (s.equals("-")) {
                expressions.push(new OpertationExpression(expressions.pop(), expressions.pop(), '-'));
            }
        }
        evaluate = expressions.pop();
    }

    @Override
    public int interpret() {
        return evaluate.interpret();
    }
}
