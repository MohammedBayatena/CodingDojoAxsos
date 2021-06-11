package OOP.calculator;

public class CalculatorTesting {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setOperand1(10.5);
        calculator.setOperation('+'); // Please Enter Operation as Character between '' and not as a String !!
        calculator.setOperand2(5.2);
        calculator.performOperation();
        calculator.getResults();
    }


}
