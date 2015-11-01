
public class MSG
{
	private String msg = "";
	private char [][] matrix = null;
	public MSG () {}

	/**
	*	Setter menseger
	*/
	protected void set(String txt)
	{
		this.msg = ""+txt;
	}

	/**
	* 	Getter menseger
	*	@return msg
	*/
	protected String get()
	{
 		return this.msg;
 	}

 	 /**
 	 *	Metodo para colocar mensagem em matriz
 	 */
 	 protected void toMatrix ()
 	 {
 	 	int tamanho = msg.length(), lin, col, x, y,count = 0;
 	 	double sqrt = Math.sqrt(tamanho);

 	 	if (this.msg.length() != 0) {
	 	 	// se a raiz quadrada do tamanho da cadeia de caracteres NAO for um numero do tipo int entra nessa condicao 
	 	 	if (sqrt - (int)sqrt != 0){
	 	 		lin = ((int)sqrt) + 1;
	 	 		col = ((int)sqrt) + 1;
	 	 		// define tamanho da matrix com espacos em branco no final
	 	 		this.matrix = new char [lin][col];

	 	 		// percorre toda a matriz adicionando nas posicoes dela cada caractere da mensagem
	 	 		for (x = 0; x < lin; x = x + 1) { 
	 	 			for (y = 0; y < col; y = y +1) {
	 	 				if (count >= tamanho)
	 	 					this.matrix[x][y] = ' ';
	 	 				else 
	 	 					this.matrix[x][y] = msg.charAt(count);
	 	 				count = count + 1;
	 	 			} // end for
	 	 		} // end for

	 	 	} // end if
	 	 	// se a raiz quadrada do tamanho da cadeia de caracteres for um numero do tipo int entra nessa condicao
	 	 	else {
	 	 		lin = (int)sqrt;
	 	 		col = (int)sqrt;
	 	 		// define tamanho da matrix sem espacos em branco no final
	 	 		this.matrix = new char [lin][col];

	 	 		// percorre toda a matriz adicionanto nas posicoes dela cada caractere da mensagem
	 	 		for (x = 0; x < lin; x = x + 1) { 
	 	 			for (y = 0; y < col; y = y +1) {
	 	 				this.matrix[x][y] = msg.charAt(count);
	 	 				count = count + 1;
	 	 			} // end for
	 	 		} // end for 
	 	 	}
	 	} // end if
 	 }

 	 /**
 	 * 	Metodo para exibir os caracteres que foram armazenados em uma matriz
 	 */
 	 protected void showMatrix () 
 	 {
 	 	int lin = matrix.length,
 	 		col = matrix[0].length,
 	 		x,y;

 	 	if (lin != 0 && col != 0 && this.matrix != null) {
 	 		for (x = 0; x < lin; x = x + 1) {
 	 			for (y = 0; y < col; y = y + 1) {
 	 				System.out.print(matrix[x][y]+" ");
 	 			}
 	 			System.out.println();
 	 		}
 	 	}
 	 }
}
