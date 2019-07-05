package com.quetz.app.util;

import java.util.ArrayList;
import java.util.List;

public class ListaPunteo {

	private List<Punteo> punteos = new ArrayList<>();
	
	public ListaPunteo() {
		llenar();
	}
	
	private void llenar() {
		punteos.add(new Punteo(1, "1 - Pésimo"));
		punteos.add(new Punteo(2, "2 - Muy Malo"));
		punteos.add(new Punteo(3, "3 - Malo"));
		punteos.add(new Punteo(4, "4 - Bueno"));
		punteos.add(new Punteo(5, "5 - Muy Bueno"));
		punteos.add(new Punteo(6, "6 - Excelente"));
	}

	public List<Punteo> getPunteos() {
		return punteos;
	}

	public void setPunteos(List<Punteo> punteos) {
		this.punteos = punteos;
	}
}
