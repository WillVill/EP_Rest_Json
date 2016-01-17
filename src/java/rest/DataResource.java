/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dataGenerator.DataGenerator;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author bechw
 */
@Path("data")
public class DataResource {

    @Context
    private UriInfo context;

    DataGenerator dg = new DataGenerator();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public DataResource() {
    }

    @GET
    @Path("{amount}/{parameters}")
    @Produces("application/json")
    public Response getJson(@PathParam("amount")int amount, @PathParam("parameters")String parameters) {
        return Response.ok(gson.toJson(dg.getData(amount, parameters)))
                 .header("Access-Control-Allow-Origin", "*")
                 .header("Access-Control-Allow-Methods", "GET")
                 .build();
    }

}
