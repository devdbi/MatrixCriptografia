
import java.util.*;

public class Criptografia extends MSG{

	/**
	* Metodo principal
	*/
	public static void main (String [] args)
	{
		MSG msg = new MSG(); 
		Scanner scan = new Scanner(System.in);

		System.out.println("Informe o texto a ser criptografado: ");
		String txt = scan.nextLine();

		msg.set(txt);

		msg.toMatrix();

		//Mensagem final
		System.out.println("msg = "+msg.get());

		msg.showMatrix();
	}
}