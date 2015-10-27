public class Array
{
	public static char [] newArray (String msg)
	{
		int x,length;
		char [] arrayMsg = null;
		length = msg.length();
		if (length != 0){
			arrayMsg = new char [length];
			for (x = 0; x < length; x = x + 1){
				arrayMsg[x] = msg.charAt(x);
			} 
		} 
		return(arrayMsg);
	}
}