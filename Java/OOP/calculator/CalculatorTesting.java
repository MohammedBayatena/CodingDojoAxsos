package OOP.calculator;

public class CalculatorTesting {

    public static void main(String[] args) {

        //Simple Calculator I
        Calculator calculator = new Calculator();
        calculator.setOperand1(10.5);
        calculator.setOperation('+'); // Please Enter Operation as Character between '' and not as a String !!
        calculator.setOperand2(5.2);
        calculator.performOperation();
        calculator.getResults();

        //Simple Calculator II
        //Test1
        Calculator calculator2 = new Calculator();
        calculator2.performOperation(10.5);
        calculator2.performOperation('+'); // Please Enter Operation as Character between '' and not as a String !!
        calculator2.performOperation(5.2);
        calculator2.performOperation('*');
        calculator2.performOperation(10);
        calculator2.performOperation('=');
        calculator2.getResults();
        //Test2
        calculator2.performOperation(10.5);
        calculator2.performOperation('+'); // Please Enter Operation as Character between '' and not as a String !!
        calculator2.performOperation(5.2);
        calculator2.performOperation('+');
        calculator2.performOperation(10);
        calculator2.performOperation('*');
        calculator2.performOperation(20);
        calculator2.performOperation('/');
        calculator2.performOperation(5);
        calculator2.performOperation('=');
        calculator2.getResults();
    }


}
