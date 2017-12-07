import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.print("Iveskite du skaicius: ");

        
        double pirmas = reader.nextDouble();
        double antras = reader.nextDouble();

        System.out.print("Enter an operator (+, -, *, /, V(saknis), ^): ");
        char veiksmas = reader.next().charAt(0);
        reader.close();

        double rezultatas;

        switch(veiksmas)
        {
            case '+':
                rezultatas = pirmas + antras;
                break;

            case '-':
            	rezultatas = pirmas - antras;
                break;

            case '*':
                rezultatas = pirmas * antras;
                break;

            case '/':
            	rezultatas = pirmas / antras;
                break;
             
            case 'V':
            	rezultatas =  Math.pow(antras, 1/pirmas);
            	 break;
            	 
            case '^':
            	rezultatas = Math.pow(pirmas, antras);
            	break;

            // operator doesn't match any case constant (+, -, *, /)
            default:
                System.out.print("Error! operator is not correct");
                return;
                
        }

        System.out.print(+ pirmas +" "+ " "+veiksmas+" "+ antras+" "+"="+" "+ rezultatas);
        
        System.out.println( "Yes");
        System.out.println( "No");
    }
}

