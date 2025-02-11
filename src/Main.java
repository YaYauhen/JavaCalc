import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanIn = new Scanner(System.in);
        System.out.println("Введите вычисляемое выражение в формате <arg1> <oper> <arg2>");
        System.out.println("где <arg1> и <arg2> - целые числа от 1 до 10, а <oper> - знак арифметической операции:");
        String inStr = scanIn.nextLine();

        try
        {
            System.out.println(calc(inStr));
        }
        catch(Exception e)
        {
            String msg = e.getMessage();
            if (msg.isEmpty())
                System.out.println(e.getStackTrace());
            else
                System.out.println(msg);
        }

        scanIn.close();
    }

    public static String calc(String input) throws Exception
    {
        int res = 0;
        String [] args = input.split(" ");

        if (args.length != 3)
            throw new Exception("Не верное число аргументов во входной строке");

        int arg1, arg2;
        try
        {
            arg1 = Integer.parseInt(args[0]);
            arg2 = Integer.parseInt(args[2]);
            if ((arg1 < 1) || (arg1 > 10) || (arg2 < 1) || (arg2 > 10))
                throw new Exception("Параметры <arg1> и <arg2> должны быть в пределах от 1 до 10");
        }
        catch(NumberFormatException e)
        {
            throw new Exception("Параметры <arg1> и <arg2> должны быть целыми числами");
        }

        switch(args[1])
        {
            case "+": res = arg1 + arg2; break;
            case "-": res = arg1 - arg2; break;
            case "*": res = arg1 * arg2; break;
            case "/": res = arg1 / arg2; break;
            default: throw new Exception("Параметр <oper> не является знаком арифметической операции");
        }

        return input + " = " + res;
    }
}
