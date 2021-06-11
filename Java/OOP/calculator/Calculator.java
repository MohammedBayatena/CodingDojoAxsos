package OOP.calculator;

import java.util.Stack;

public class Calculator {
    private char operation;
    private double operand1, operand2;
    private double result;
    private Stack<Object> numberStack = new Stack<>();
    private Stack<Object> operatorStack = new Stack<>();

    public double getResult() {
        return result;
    }

    public Calculator() {
        this.result = 0;
    }

    public char getOperation() {
        return operation;
    }

    public void setOperation(char operation) {
        this.operation = operation;
    }

    public double getOperand1() {
        return operand1;
    }

    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    public double getOperand2() {
        return operand2;
    }

    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }


    public void performOperation() {
        switch (operation) {
            case '+':
                result = getOperand1() + getOperand2();
                break;
            case '-':
                result = getOperand1() - getOperand2();
                break;
            case '*':
                result = getOperand1() * getOperand2();
                break;
            case '/':
                result = getOperand1() / getOperand2();
                break;
            default:
                System.out.println("Incorrect Operation Entered or Operation Unsupported Yet!");
        }
    }


    public void performOperation(char operation) {
        switch (operation) {
            case '+':
                operatorStack.push(operation);
                break;
            case '-':
                operatorStack.push(operation);
                break;
            case '*':
                operatorStack.push(operation);
                break;
            case '/':
                operatorStack.push(operation);
                break;
            case '=':
                result = doOperations();
                break;
            default:
                System.out.println("Incorrect Operation Entered or Operation Unsupported Yet!");
        }
    }

    public void performOperation(double operand) {
        numberStack.push((Double) operand);
    }

    private double doOperations() {
        while (!operatorStack.isEmpty()) {
            if (numberStack.size() >= 2) {
                operand2 = (double) numberStack.pop();
                operand1 = (double) numberStack.pop();
                operation = (char) operatorStack.pop();
                performOperation();
                numberStack.push(getResult());
            }
        }
        return result;
    }


    public void getResults() {
        System.out.println("Result is: " + getResult());
    }


}
