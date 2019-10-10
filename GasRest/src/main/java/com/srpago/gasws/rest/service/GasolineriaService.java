package com.srpago.gasws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.srpago.gasws.rest.client.GasStationClient;
import com.srpago.gasws.rest.core.persistence.entities.DatosVenta;
import com.srpago.gasws.rest.core.persistence.operation.DbOperations;
import com.srpago.gasws.rest.model.InfoRQ;
import com.srpago.gasws.rest.model.Response;
import com.srpago.gasws.rest.model.Results;

@Path("/GasolineriaService")
public class GasolineriaService {

	@POST
	@Path("/validationData")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Response validationData(InfoRQ infoRQ) {
		Response response = new Response();
		Results rs = new Results();
		try {
			GasStationClient client = new GasStationClient();
			rs = client.consume(infoRQ.getGasStation());
			if (rs != null) {
				if (infoRQ.getGasStation() == null || infoRQ.getGasStation().isEmpty()
						|| infoRQ.getGasStation().equals("")) {
					response.setError("201");
					response.setMessage("GasStation es obligatorio");
					response.setSuccess(false);
					return response;
				}
				if (infoRQ.getAmount() == null || infoRQ.getAmount() <= 0) {
					response.setError("201");
					response.setMessage("El monto es obligatorio y debe ser igual o mayor a $1");
					response.setSuccess(false);
					return response;
				}
				if (infoRQ.getCardNumber() == null || infoRQ.getCardNumber().equals("")) {
					response.setError("201");
					response.setMessage("El número de tarjeta es obligatorio");
					response.setSuccess(false);
					return response;
				}
				if (infoRQ.getEmail() == null || infoRQ.getEmail().equals("")) {
					response.setError("201");
					response.setMessage("El e-mail es obligatorio");
					response.setSuccess(false);
					return response;
				}
				if ((infoRQ.getExpirationDateYear() != null) && infoRQ.getExpirationDateYear() < 2019) {
					response.setError("201");
					response.setMessage("La Fecha ha expirado");
					response.setSuccess(false);
					return response;
				} else if (infoRQ.getExpirationDateMonth() == null || infoRQ.getExpirationDateMonth().equals("")) {
					response.setError("201");
					response.setMessage("Los datos de la fecha son obligatorios");
					response.setSuccess(false);
					return response;
				}
				if ((infoRQ.getGasType() == null) || (infoRQ.getGasType() < 1 && infoRQ.getGasType() > 2)) {
					response.setError("201");
					response.setMessage("Tipo de Gaasolina Obligatorio");
					response.setSuccess(false);
					return response;
				}
				if ((infoRQ.getLastName() == null || infoRQ.getLastName().equals("")) && infoRQ.getName() == null
						|| infoRQ.getName().equals("")) {
					response.setError("201");
					response.setMessage("Nombre y apellidos son obligatorio");
					response.setSuccess(false);
					return response;
				}
				if (infoRQ.getSellerName() == null || infoRQ.getSellerName().equals("")) {
					response.setError("201");
					response.setMessage("El nombre del vendedor es obligatorio");
					response.setSuccess(false);
					return response;
				}
				
				DbOperations operations = new DbOperations();
				DatosVenta datos = new DatosVenta();
				datos.setCalleStation(rs.getCalle());
				datos.setCardNumber(infoRQ.getCardNumber());
				datos.setEmail(infoRQ.getEmail());
				datos.setGasStation(infoRQ.getGasStation());
				datos.setDato2(rs.getRazonsocial());
				datos.setDato3(rs.getRfc());
				Integer id_datos = operations.saveData(datos);
				if(id_datos != null || id_datos>0) {
					response.setError("200");
					response.setMessage("Success");
					response.setSuccess(true);
				}else {
					response.setError("201");
					response.setMessage("No se guardo la informacion en la base de datos");
					response.setSuccess(false);
					return response;
				}
				return response;
			} else {
				response.setError("201");
				response.setMessage("Identificador de Gasolinera invalido o nulo");
				response.setSuccess(false);
				return response;
			}
		} catch (Exception e) {
			return null;
		}
	}

}
