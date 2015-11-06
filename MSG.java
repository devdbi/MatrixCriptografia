import java.util.*;

public class MSG
{
	private String msg = "";
	private String keyWord = "";
	private int [][] code = null;
	private char [][] matrix = null;
	private int [][] matrixInt = null;
	private int [][] mc = null;

	public MSG (){}

	/**
	*	Contrutor da classe MSG
	*	@param String txt
	* 	@param String keyWord
	*/
	public MSG (String txt, String keyWord) {
		this.set(txt, keyWord);
	}

	/**
	*	Setter menseger
	*/
	protected void set(String txt, String keyWord)
	{
		this.msg = ""+txt;
		this.keyWord = ""+keyWord;
		// cria uma copia da mensagem na matriz
		this.toMatrix();
		// cria um codigo para a matriz
		this.generateCode();
		// preenche matriz MC
		this.setMC(matrixInt,code);
		// gera mensagem criptografada
		encrypted(mc);
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
	 	this.toInt(this.matrix);
	 	} // end if
 	 }

 	 /**
 	 *	Metodo para criar uma matriz com valores inteiros que representam a matriz com a mensagem 
 	 *	@param char[][] matrix
 	 */
 	 private void toInt(char[][] matrix) {
 	 	int lin = matrix.length,
 	 		col = matrix[0].length,
 	 		x, y;
 	 		this.matrixInt = new int [lin][col];
 	 	for (x = 0; x < lin; x = x + 1) {
 	 		for (y = 0; y < col; y = y + 1) {
 	 			this.matrixInt[x][y] = (int)this.matrix[x][y];
 	 		}
 	 	}
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

 	 /**
 	 *	Metodo para gerar uma matriz codigo
 	 */
 	 protected void generateCode() 
 	 {
 	 	// se a matriz com a mensagem não for nula cria outra matriz com o codigo a ser gerado
 	 	if (this.matrix != null) {

 	 		String keyWord = this.keyWord;
 	 		// nova matriz para armazernar o codigo
 	 		int lin = this.matrix.length,
 	 			col = this.matrix[0].length;
 	 		this.code = new int [lin][col];

 	 		// variaveis de controle
 	 		int x, i, j, 
 	 			length = keyWord.length();

 	 		// variavel para incrementacao
 	 		int c = 0, cont = 0;

 	 		// laco para preencher a matriz com o codigo
 	 		for (i = 0; i < lin; i = i + 1) {
 	 			for (j = 0; j < col; j = j + 1) {
 	 			 	c = (int)keyWord.charAt(cont);
 	 			 	cont = cont + 1;

 	 			 	if (cont == length)
 	 			 		cont = 0;

 	 			 	this.code[i][j] = c;
 	 			}
 	 		}
 	 	}
 	 }

 	 /**
 	 *	funcao para multiplicacao de matrizas
 	 *  @param int[][] matrix1 
 	 *  @param int[][] matrix2
 	 *  @return int[][] matMC
 	 */
 	 private int[][] multiply (int[][] matrix1, int[][]matrix2) 
 	 {
 	 	int lin1 = matrix1.length,
 	 		col1 = matrix1[0].length,
 	 		lin2 = matrix2.length,
 	 		col2 = matrix2[0].length,
 	 		i, j, k, soma = 0;
 	 	int [][] matMC = new int [lin1][col1];
 	 	// verifica se as duas matrizes sao quadradas
 	 	if (matrix1 != null && lin1 == lin2 && lin1 == col2 && col1 == col2 ) {
 	 		// varre as duas matrizes
 	 		for (i = 0; i < lin1; i = i + 1) {
 	 			for (j = 0; j < col1; j = j + 1) {
 	 				// multiplica
 	 				soma = 0;
 	 				for (k = 0; k < col1; k = k + 1) {
 	 					soma = soma + matrix1[i][k] * matrix2[k][j];
 	 				}
 	 				matMC[i][j] = soma;
 	 			}
 	 		}
 	 	}
 	 	return matMC;
 	 }

 	 /**
 	 *	metodo para gerar matriz MC
 	 *	@param int[][] matrix
 	 *	@param int[][] code
 	 */
 	 private void setMC (int[][] matrix, int[][] code) 
 	 {
 	 	this.mc = this.multiply(matrix,code);
 	 }

 	 /**
 	 *	Metodo para gerar String com mensagem criptografada
 	 *	@param int[][] mc
 	 */
 	 private void encrypted (int[][] mc) 
 	 {
 	 	this.msg = "";
 	 	int x, y,
 	 		lin = mc.length,
 	 		col = mc[0].length;
 	 	for (x = 0;  x < lin; x = x + 1) {
 	 		for (y = 0; y < col; y = y + 1) {
 	 			this.msg = "" + this.msg + mc[x][y];
 	 		}
 	 	}
 	 	this.get();
 	 }
}
