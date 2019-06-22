package com.mkyong.rest;
 
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

 
@Path("/hello")
public class HelloWorldService {
 
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
	@Path("/score")
	@Produces("application/json")
	public String getScore() {
	   String pattern = 
	      "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
	   return String.format(pattern,  "2", "3", "4" );   
	}

	@POST
	@Path("/filesavedownload")
	  @Consumes("application/json")
	public Response sayPlainTextHello(FileProperty fileproperty){
		 URL website = null;
		 ReadableByteChannel rbc = null;
		 FileOutputStream fos =  null;
		try {
            website = new URL(fileproperty.getFileurl());
            rbc = Channels.newChannel(website.openStream());
            fos = new FileOutputStream(fileproperty.getFilename());
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return Response.status(200).entity("Success").build();
		/*
		BufferedInputStream in = null;
		FileOutputStream fout = null;
		try{
			in = new BufferedInputStream(new URL(fileproperty.getFileurl()).openStream());
			fout = new FileOutputStream(fileproperty.getFilename());

			byte data[] = new byte[1024];
			int count;
			while ((count = in.read(data, 0, 1024)) != -1) {
				fout.write(data, 0, count);
			}

		}catch(Exception e){
			return Response.status(300).entity("Fail").build();
		}
		finally {
			if (in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}}
			if (fout != null){
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}}
		}
		
		return Response.status(200).entity("Success").build();
	*/
		
	}
	
	@PUT
	@Path("/fileupload")
	@Produces("application/json")
	public String update(@QueryParam("fileName") String fileName, 
	                        @QueryParam("fileUrl") String fileUrl) {
	   
	   String pattern = 
	      "{ \"status\":\"%s\"}";
	   BufferedInputStream in = null;
	   FileOutputStream fout = null;
	   try{
		   in = new BufferedInputStream(new URL(fileUrl).openStream());
			 fout = new FileOutputStream(fileName);
			 
			byte data[] = new byte[1024];
			 int count;
			 while ((count = in.read(data, 0, 1024)) != -1) {
			 fout.write(data, 0, count);
			 }
		   
	   }catch(Exception e){
		   return String.format(pattern, "Fail");
	   }
	   finally {
			 if (in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}}
			 if (fout != null){
				try {
					fout.close();
				} catch (IOException e) {
					e.printStackTrace();
				}}
			 }
	   return String.format(pattern, "Success");   
	}
	
 
}