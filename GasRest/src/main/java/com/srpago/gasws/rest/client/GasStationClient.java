package com.srpago.gasws.rest.client;

import com.google.gson.Gson;
import com.srpago.gasws.rest.model.Results;
import com.srpago.gasws.rest.model.ListResults;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


public class GasStationClient {

	public Results consume(String id) {
		try {
			Client client = Client.create();
			Gson gson = new Gson();		
			WebResource webResource = client
			   .resource("https://api.datos.gob.mx/v1/precio.gasolina.publico");

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			String output = response.getEntity(String.class);
			
			ListResults listResults = gson.fromJson(output, ListResults.class);
			
			for ( Results rs : listResults.getResults() ) {
			    if ( id == null ? rs.get_id() == null : id.equals(rs.get_id()) ) {
			     System.out.println(rs.getCalle());
			     return rs;
			    }
			}
			
		  } catch (Exception e) {
			return null;
		  }
		return null;
	}
	
	/**
	public static void main(String []args ) {
		try {
			Client client = Client.create();
			Gson gson = new Gson();
			WebResource webResource = client
			   .resource("https://api.datos.gob.mx/v1/precio.gasolina.publico");

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}
			String output = response.getEntity(String.class);
			
			ListResults listResults = gson.fromJson(output, ListResults.class);
			
			for ( Results rs : listResults.getResults() ) {
			    if ( "" == null ? rs.get_id() == null : "587fbd68edfe99480a072f14".equals(rs.get_id()) ) {
			     System.out.println("correcto");
			     System.out.println(rs.getCalle());
			    }
			}
			
			System.out.println("Lista ok");
		  } catch (Exception e) {

			e.printStackTrace();

		  }

	}
	*/
	
}
