package com.action.library;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;  
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.commons.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Entity;

 public class PostInfoAction { 
  public static boolean Login(String UserName, String Password) {
  // TODO Auto-generated method stub
	  boolean  a = false;
	  CloseableHttpClient httpclient = HttpClients.createDefault();
 

	  HttpGet getMethod = new HttpGet("http://202.115.47.141/login.jsp");

	  HttpPost postMethod = new HttpPost("http://202.115.47.141/loginAction.do");

	  try{
		  CloseableHttpResponse response = httpclient.execute(getMethod);
		  
		  try {
		      HttpEntity entity = response.getEntity();
		      if (entity != null) {
	     
		    	  ArrayList<NameValuePair> formparams = new ArrayList<NameValuePair>();
		          formparams.add(new BasicNameValuePair("zjh", UserName));
		          formparams.add(new BasicNameValuePair("mm", Password));
		          
		          UrlEncodedFormEntity entity1 = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
		          postMethod.setEntity(entity1);
		          response = httpclient.execute(postMethod);
		       
		          entity = response.getEntity();
		          String l = EntityUtils.toString(entity);
		          int length = l.length();
		          if (length < 500)
		          {
		        	  a = true;
		        	  
		          }
		      
		          
		      }
		  } finally {
		      response.close();
		  }
	  }
	  catch (IOException e) {
	   // TODO: handle exception
	   System.out.println("the line is wrong!");
	   e.printStackTrace();
	  }finally{
	   getMethod.releaseConnection();
	   postMethod.releaseConnection();
	  }
	  return a;
 }
 
 }
 