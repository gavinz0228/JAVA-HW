import java.util.*;
public class Calculator
{
    public Calculator()
    {}
    public static void main(String [] args)
    {
        Scanner input=new Scanner(System.in);
        double first=0;
        double second=0;
        String firstArg=null;
        String secondArg=null;
        String operator=null;
        try{
            if (args.length<3)
                throw new NotEnoughNumbersException("You need to at least provide 3 arguments(separated by space).");
            firstArg=args[0];
            secondArg=args[2];
            operator=args[1];
        }
        catch(NotEnoughNumbersException ex)
        {
            if(args.length==2)
            {
                System.out.println("Please type in the third argument(number).");
                secondArg=input.nextLine();
                
            }
            else
            {
                System.exit(0);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        boolean validInput=false;
        while(!validInput)
        {
            try{
                first=validateNumber(firstArg);
                validInput=true;
            }
            catch(NotANumberException ex)
            {
                System.out.println("Error:"+ex.getMessage()+" Please type in argument 1 again.");
                firstArg=input.nextLine();
            }
        }
        validInput=false;
        while(!validInput)
        {
            try{
                second=validateNumber(secondArg);
                validInput=true;
            }
            catch(NotANumberException ex)
            {
                System.out.println("Error:"+ex.getMessage()+" Please type in argument 3 again.");
                secondArg=input.nextLine();
            }
        }
        Calculator cal=new Calculator();
        if (args.length<=3)
        {
            validInput=false;
            while(!validInput)
            {
                try{
                    double result=cal.calculate(first,second,operator);
                    System.out.println(result);
                    validInput=true;
                }
                catch(IllegalOperationException ex)
                {
                    System.out.println(ex.getMessage()+" Please type in a operator again.");
                    operator=input.nextLine();
                }
                catch(ArithmeticException ex)
                {
                    System.out.println("Fatal Error:"+ex.getMessage());
                    System.exit(0);
                }
                catch(Exception ex)
                {
                    System.out.println("Unknown Error:"+ex.getMessage());
                    System.exit(0);
                }
            }
        }
        else
        {
            System.out.println(cal.evaluateLong(args));
        }
        
    }
    public static double validateNumber(String number)
    {
        try{
            double validNumber=Double.valueOf(number);
            return validNumber;
        }
        catch(Exception ex)
        {
            throw new NotANumberException("It's not a valid number.");
        }
    }
    public static boolean isNumber(String str)
    {
        try
        {
            validateNumber(str);
            return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
    //first calculate * and / 
    //then caculate + and -
    public double evaluateLong(String input[])
    {
        //for * and /
        ArrayList<String> higher=new ArrayList<String>();
        ArrayList<String> lower=new ArrayList<String>();
        //if the flag is true, the string will be bring to the higer queue
        for(int i=0;i<input.length;i++)
        {
            //System.out.println("-"+input[i]+"-");
            if(input[i].equals("*")||input[i].equals("/"))
            {
                higher.clear();
                //don't forget the number before it
                higher.add(lower.get(lower.size()-1));
                lower.remove(lower.size()-1);
                higher.add(input[i]);
                higher.add(input[i+1]);
                
                String[] lastArray=new String[higher.size()];
                higher.toArray(lastArray);
                //System.out.print(lastArray[0]+lastArray[1]+lastArray[2]+"--");
                
                double num=evaluate(lastArray);
                //System.out.println(num);
                lower.add(String.valueOf(num));
                i++;
                //flag=true;
            }
            else
            {
                lower.add(input[i]);

            }
        }
        String[] inputArray=new String[lower.size()];
        lower.toArray(inputArray);

        double output=evaluate(inputArray);
        return output;
        
    }
    //use a stack , make it look like a reverse polish notation format
    //but only from left to right
    public double evaluate(String input[])
    {
        
        Stack<String> opStack=new Stack<String>();
        Stack<Double> numStack=new Stack<Double>();
        for(int i=input.length-1;i>=0;i--)
        {
            if(isNumber(input[i]))
            {
                double num=validateNumber(input[i]);
                numStack.push(new Double(num));
            }
            else
            {   //System.out.print(input[i]);
                opStack.push(input[i]);
            }
        }
        //System.out.println("=========");
        //System.out.println(opStack.size());
        while(!opStack.empty())
        {
            Double num1=numStack.pop();
            Double num2=numStack.pop();
            String op=opStack.pop();
            double result=calculate(num1,num2,op);
            numStack.push(new Double(result));
        }
        Double output=numStack.pop();
        return output.doubleValue();
    }
    
    //for basic operation
    //can throw arythmitic exception
    public double calculate(double first, double second,String operator)
    {
        //System.out.println("opppppppp:"+operator);
        
        double result;
        switch(operator)
        {
            case "+":
                result=add(first,second);
                break;
            case "-":
                result= sub(first,second);
                break;
            case "*":
                result=mul(first,second);
                break;
            case "/":
                result=div(first,second);
                break;
            case "%":
                result=mod(first,second);
                break;
            default:
                throw new IllegalOperationException("Operator "+operator+" is not supported.");
        }
        return result;
    }
    public double add(double a,double b)
    {
        return a+b;
    }
    public double sub(double a,double b)
    {
        return a-b;
    }
    
    public double mul(double a,double b)
    {
        return a*b;
    }
    public double div(double a,double b) throws ArithmeticException
    {
        return a/b;
    }
    public double mod(double a,double b)
    {
        return a%b;
    }
    
}
class NotANumberException extends IllegalArgumentException
{
    public NotANumberException(String msg)
    {
        super(msg);
    }
}
class IllegalOperationException extends IllegalArgumentException
{
    public IllegalOperationException(String msg)
    {
        super(msg);
    }
}
class NotEnoughNumbersException extends IllegalArgumentException
{
    public NotEnoughNumbersException(String msg)
    {
        super(msg);
    }
}