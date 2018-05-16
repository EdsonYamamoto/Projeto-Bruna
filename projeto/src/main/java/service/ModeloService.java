package service;

import java.util.ArrayList;
import java.util.List;

import modelo.Modelo;


public class ModeloService {

	private static List<Modelo> listaModelo = new ArrayList<Modelo>();
	private static List<Modelo> listaBancoModelo = new ArrayList<Modelo>();
	private static Modelo Modelo = new Modelo();
	
	public static List<Modelo> getListaBancoModelo() {
		return listaBancoModelo;
	}
	public static void setListaBancoModelo(List<Modelo> listaBancoModelo) {
		ModeloService.listaBancoModelo = listaBancoModelo;
	}
	public static List<Modelo> getListaModelo() {
		return listaModelo;
	}
	public static void setListaModelo(List<Modelo> listaModelo) {
		ModeloService.listaModelo = listaModelo;
	}
	public static Modelo getModelo() {
		return Modelo;
	}
	public static void setModelo(Modelo Modelo) {
		ModeloService.Modelo = Modelo;
	}
	public static void salvaModelo(Modelo Modelo) {
		listaModelo.add(Modelo);
		ModeloService.Modelo = new Modelo();
	}
}
