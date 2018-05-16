package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import dao.ModeloDAO;
import modelo.Modelo;
import service.ModeloService;


public class ExtratorXML {
	public static void extrair(File xmlExtrator) throws IOException
	{
		String saida="";
		byte[] bytes = new byte[10];
		String linhaLida =new String(bytes, Charset.forName("UTF-8"));
		String[] vetString;
		BufferedReader br = null;
		
		
		String espaco;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(xmlExtrator), "UTF-8"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		}
		while ((linhaLida = br.readLine()) != null) {
			int count=0;
			boolean condi=false;
			espaco = linhaLida;
			for( int i=0; i<linhaLida.length(); i++ ) {
				if( linhaLida.charAt(i) == ' ' && !condi)
				{
				    count++;
				}
				else
					condi=true;
				    
			}
			vetString = linhaLida.split("\"");
			if (vetString.length>1 && count>0) {
				saida+= repeat("#",count/2)+"\t(("+vetString[1]+vetString[3]+"|"+vetString[1]+"))\t\n";
			}
		}
		ModeloService.getModelo().modelo = saida;
		System.out.println(ModeloService.getModelo().modelo);
		ModeloDAO a = new ModeloDAO();
		a.save(ModeloService.getModelo());
	}
	public static String repeat(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }
}
