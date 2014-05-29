package org.riyaz.man;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.lang.Enum;
import java.math.BigInteger;

import static org.elasticsearch.common.xcontent.XContentFactory.*;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.riyaz.man.dao.HibernateDaoImpl;
import org.riyaz.man.dao.JdbcDaoImpl;
import org.riyaz.man.model.Drive_geotag_history;
import org.riyaz.man.model.Tweet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;

import static org.elasticsearch.common.xcontent.XContentFactory.*;
import static org.elasticsearch.node.NodeBuilder.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JdbcDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Hi man");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		HibernateDaoImpl dao =ctx.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		
		int count=dao.getDriveGeotagHistoryCount(),i=0;
		System.out.println("BLA BLA");
		
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		DateFormat myDateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		System.out.println(count);
		Drive_geotag_history a = null;
		PrintWriter writer = new PrintWriter("D:/Stuff/ElasticSearch/elasticsearch-1.1.1/DriveGeotagHistory.json");
		writer.close();
		PrintWriter out;
		if(count < 25)
		{
			String data = new String();
			String str,temp;
			for(i=1;i<=count;i++)
			{
				a= dao.getDriveGeotagHistory(i);
				out = new PrintWriter(new BufferedWriter(new FileWriter("D:/Stuff/ElasticSearch/elasticsearch-1.1.1/DriveGeotagHistory.json", true)));
				str = "{\"index\":{\"_index\":\"drive\",\"_type\":\"drive_geotag_history\",\"_id\":"+i+"}}";
				temp = mapper.writeValueAsString(a);
				System.out.println(temp);
				data=data + str + "\n" + temp + "\n";
				out.println(str);
				out.close();
				mapper.writeValue(new FileWriter("D:/Stuff/ElasticSearch/elasticsearch-1.1.1/DriveGeotagHistory.json",true), a);
				out = new PrintWriter(new BufferedWriter(new FileWriter("D:/Stuff/ElasticSearch/elasticsearch-1.1.1/DriveGeotagHistory.json", true)));
			    out.println();
			    out.close();
			}
			out = new PrintWriter(new BufferedWriter(new FileWriter("D:/Stuff/ElasticSearch/elasticsearch-1.1.1/DriveGeotagHistory.json", true)));
		    out.println();
		    out.close();
			/*----------------------------------------------------------------------------------------------------------------*/
			/*HTTP Request part*/
			
			HttpClient client =HttpClients.createDefault();
			
			HttpPut putMethod =new HttpPut("http://localhost:9200/_bulk");
			putMethod.setEntity(new StringEntity(data));
			putMethod.setHeader("Content-Type", "application/json");
			
			HttpResponse response= client.execute(putMethod);
			System.out.println("Status code: " + response.getStatusLine().getStatusCode());
			System.out.println("Error : " + response.getStatusLine().getReasonPhrase());
		}
		else
		{
			int number = 0;
			while(count>=number)
			{
				String data = new String();
				String str,temp;
				int flag=0;
				for(i=1;i<=25;i++)
				{
					number++;
					if(number>count)
					{
						flag=1;
						break;
					}
					a= dao.getDriveGeotagHistory(number);
					out = new PrintWriter(new BufferedWriter(new FileWriter("D:/Stuff/ElasticSearch/elasticsearch-1.1.1/DriveGeotagHistory.json", true)));
					str = "{\"index\":{\"_index\":\"drive\",\"_type\":\"drive_geotag_history\",\"_id\":"+number+"}}";
					temp = mapper.writeValueAsString(a);
					System.out.println(temp);
					data=data + str + "\n" + temp + "\n";
					out.println(str);
					out.close();
					mapper.writeValue(new FileWriter("D:/Stuff/ElasticSearch/elasticsearch-1.1.1/DriveGeotagHistory.json",true), a);
					out = new PrintWriter(new BufferedWriter(new FileWriter("D:/Stuff/ElasticSearch/elasticsearch-1.1.1/DriveGeotagHistory.json", true)));
				    out.println();
				    out.close();
				}
				/*----------------------------------------------------------------------------------------------------------------*/
				/*HTTP Request part*/
				HttpClient client =HttpClients.createDefault();
				
				HttpPut putMethod =new HttpPut("http://localhost:9200/_bulk");
				putMethod.setEntity(new StringEntity(data));
				putMethod.setHeader("Content-Type", "application/json");
				
				HttpResponse response= client.execute(putMethod);
				System.out.println("Status code: " + response.getStatusLine().getStatusCode());
				System.out.println("Error : " + response.getStatusLine().getReasonPhrase());
				if(flag==1)
				{
					break;
				}				
			}

			out = new PrintWriter(new BufferedWriter(new FileWriter("D:/Stuff/ElasticSearch/elasticsearch-1.1.1/DriveGeotagHistory.json", true)));
		    out.println();
		    out.close();
		}
		System.out.println("Written to database successfully");
	}
}
