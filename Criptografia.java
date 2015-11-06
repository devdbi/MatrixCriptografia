
import java.util.*;

public class Criptografia extends MSG{

	/**
	* Metodo principal
	*/
	public static void main (String [] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("Informe o texto a ser criptografado: ");
		String txt = scan.nextLine();

		System.out.println("Informe a palavra chave: ");
		String key = scan.nextLine();

		MSG msg = new MSG(txt, key); 

		//Mensagem final
		System.out.println("msg = "+msg.get());
	}
}