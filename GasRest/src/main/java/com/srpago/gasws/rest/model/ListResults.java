package com.srpago.gasws.rest.model;

import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class ListResults {

	 @SerializedName("results")
	private Results[] results;
	 @SerializedName("pagination")
	private Pagination paginacion;
	public Results[] getResults() {
		return results;
	}
	public void setResults(Results[] results) {
		this.results = results;
	}
	public Pagination getPaginacion() {
		return paginacion;
	}
	public void setPaginacion(Pagination paginacion) {
		this.paginacion = paginacion;
	}

	
	
}
