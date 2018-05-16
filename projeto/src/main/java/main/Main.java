package main;

import java.io.File;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException
	{
		String localArquivo = "C:\\Users\\edson.kazumi\\Desktop\\teste\\telaSAMSUNG.xml";
		File xmlExtrator = new File(localArquivo);
		ExtratorXML.extrair(xmlExtrator);
	}
}
