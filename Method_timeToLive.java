package Library;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class Method_timeToLive {
	
	
	public static synchronized void Create(String key, String value,
			int timeToLive) {
	 
	// String value=jvalue.toString();
	

	   File file = new File("D:\\new folder\\inout.json");
		 try {
		   if (file.createNewFile()){
		    System.out.println("File is created!");}
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 
		
 	//file creation done;
		
		 if(file.length() == 0) {
			 
		
		 JSONObject objj= new JSONObject();
		 objj.put("000", "000");
		
			
		   
		 try {
 	         FileWriter fw = new FileWriter(file.getAbsolutePath());
 	         fw.write(objj.toString());
 	         fw.close();
 	          } catch (IOException e) {
 	         
 	         e.printStackTrace();
 	          }
			
		 
		 }
		 
		 
		 
		 if(file.getTotalSpace()>1024*1024*1024 && key.length()<32) {
			 
			 
				//reading from file whether key exist or not;
					 
						 JSONParser jp = new JSONParser();
						 	try {
						 		FileReader fr = new FileReader(file);
						 		Object obj = jp.parse(fr);
						 		JSONObject jobject  = (JSONObject) obj;
						    
				//putting all objects from json into hashmap; 		    
			 @SuppressWarnings("unchecked")
			 HashMap <String  ,String > map = new Gson().fromJson(jobject.toString(), HashMap.class);
			 
			   
			 //iterating through hashmap to get key from hashmap to search duplicates;        
		             
			 			if(map.containsKey(key)) {
			 					System.out.println( " ERROR : -key cannot be duplicated"  );
			 				}
			 			else {
		            	 //map.put(key, value);
			 				String value1=value+"$$"+timeToLive;
			 			
			 				
			 				
			 				//HashMap <String  ,JSONArray > k = new Gson().fromJson(jr.toString(), HashMap.class);
			 				 map.put(key, value1);
			 				 JSONObject objj= new JSONObject();
			 				 objj.putAll(map);
			 				
			 				
			 			
			      	 
			      	 System.out.println("time to live in : " + objj );
			      	    
			      	    
			      	   //  System.out.printf( "JSON: %s", json.toString() + "\n");
			      	    
			      	    
			      	  try {
			 	         FileWriter fw = new FileWriter(file.getAbsolutePath());
			 	         fw.write(objj.toString());
			 	      // System.out.println("time to live in : " + jr);
			 	         fw.close();
			 	          } catch (IOException e) {
			 	         
			 	         e.printStackTrace();
			 	          }
		                  }
			      	  //JSONParser catch block  from line : 54;
						 }
					catch (IOException | ParseException e) 
						 	{
				        e.printStackTrace();
		 					System.out.println("ERROR : cannot retreive data from file"  );

						 	}
						
						
		     	
					 
				}//if condition closed for file size key char size;
			else {
				System.out.println("Error : File Size limit exceeded || value size exceeded || key length exceeded ");
			}
					 }
	 
			
			/*long currentDateTimeMillis = new Date().getTime();
			if (file.getTimeToLive() > 0
					&& (currentDateTimeMillis - data
							.getCreationDateTimeMillis()) >= (data
							.getTimeToLive() * Constants.MILLISECONDS)) {
				// the object is expired, So remove from datastore
				dataMap.remove(key);
				fileOutputStream = new FileOutputStream(file);
				objectOutputStream = new ObjectOutputStream(
						fileOutputStream);
				objectOutputStream.writeObject(dataMap);
				fileOutputStream.close();
				objectOutputStream.close();

				// Since object is removed the key is available for storage
				isKeyExists = false;
			}
		}*/
	

}
