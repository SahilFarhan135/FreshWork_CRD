package Library;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class Method   {
	
	
	 public static final String RED_BRIGHT = "\033[0;91m";    // RED
	 public static final String RESET = "\u001B[0m";
	
	
	 

	
	//create method starts
		public static synchronized void Create(String key, String value ) {

			//creating a file;
			   File file = new File("D:\\new folder\\inout.json");
				 try {
				   if (!file.exists()){
					   file.createNewFile();
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
			//Checking condition for file size and key length to be capped at 32;
				 if(file.getTotalSpace()>1024*1024*1024 && key.length()<32) {
				 				 
			//reading from file whether key exist or not;
				 
					 JSONParser jp = new JSONParser();
					 	try {
					 		FileReader fr = new FileReader(file);
					 		Object obj = jp.parse(fr);
					 		JSONObject jobject  = (JSONObject) obj;
					    
			//putting all objects from json into hashmap; 		    
		 @SuppressWarnings("unchecked")
		HashMap<String, String> map = new Gson().fromJson(jobject.toString(), HashMap.class);
		   
		 //iterating through hashmap to get key from hashmap to search duplicates;        
	             
		 			if(map.containsKey(key)) {
		 					System.out.println( " ERROR : -key cannot be duplicated"  );
		 				}
		 			else {
	            	 map.put(key, value);
		             JSONObject json = new JSONObject();
		      	     json.putAll( map );
		      	    
		      	 
		      	  try {
		 	         FileWriter fw = new FileWriter(file.getAbsolutePath());
		 	         fw.write(json.toString());
		 	         fw.close();
		 	         System.out.println(key+"Key-value pair inserted Successfully");
		 	          } catch (IOException e) {
		 	         
		 	         e.printStackTrace();
		 	          }
	                  }
		      	  //JSONParser catch block  from line : 54;
					 }
				catch (IOException | ParseException e) 
					 	{
			        e.printStackTrace();
	 					System.out.println(" ERROR : cannot retreive data from file"  );
					 	}
			}//if condition closed for file size key char size;
		else {
			System.out.println("Error : File Size limit exceeded || value size exceeded || key length exceeded ");
		}				
	}
		

		
	
	
//delete method

	public static synchronized void Delete(String key) {
			
		 File file = new File("D:\\new folder\\inout.json");
		 try {
		   if (file.createNewFile()){
		    System.out.println("File is created!");}
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 
		 if(file.length() == 0) {
			 JSONObject objj= new JSONObject();
			 objj.put("000", "000");
			 try {
	 	         FileWriter fw = new FileWriter(file.getAbsolutePath());
	 	         fw.write(objj.toString());
	 	         fw.close();
	 	          }
			 catch (IOException e) {  
	 	         e.printStackTrace();
					System.out.println(RED_BRIGHT+ " ERROR : cannot retreive data from file"+ RESET  );
	 	          }				
			 }
		 
	 
		 if(file.getTotalSpace()>1024*1024*1024 && key.length()<32) {
			 
		 JSONParser jp = new JSONParser();
		 try {
			 FileReader fr = new FileReader(file);
			 Object obj = jp.parse(fr);
			 JSONObject searchObj = (JSONObject)obj;			 		 
			 HashMap<String,String> hm = new Gson().fromJson(searchObj.toString(),HashMap.class);
			 
			 if(hm.containsKey(key)) {
				 hm.remove(key);
				 JSONObject obj1=new JSONObject();
				 obj1.putAll(hm);
				  try {
			 	         FileWriter fw = new FileWriter(file.getAbsolutePath());
			 	         fw.write(obj1.toString());
			 	         fw.close();
			 	         System.out.println(key+"Key-value pair inserted Successfully");
			 	          } catch (IOException e) {
			 	         
			 	         e.printStackTrace();
			 	          }						 						
			 }
			 else {
				 System.out.println("key not found during delete operation :- " + key);
			 }		 
		 }catch(IOException  |ParseException e ) {
			 e.printStackTrace();
				System.out.println(RED_BRIGHT+ " ERROR : cannot retreive data from file"+ RESET  );
		 }
		 }else {
				System.out.println("Error : File Size limit exceeded ||  key length exceeded ");
			}
			 }
	//delete method ends


// search method starts
	public static synchronized void Read(String key) {

		   File file = new File("D:\\new folder\\inout.json");
			 try {
			   if (file.createNewFile()){
			    System.out.println(RED_BRIGHT+"File is created!"+RESET);}
			  } catch (IOException e) {
			   e.printStackTrace();
			  }
			 
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
				 
			 JSONParser jp = new JSONParser();
			 try {
				 FileReader fr = new FileReader(file);
				 Object obj = jp.parse(fr);
				 JSONObject searchObj = (JSONObject)obj;				 
				 HashMap<String,String> hm = new Gson().fromJson(searchObj.toString(),HashMap.class);
				 if(hm.containsKey(key)) {
				//	hm.values();
					
		        		
		        		//System.out.println("The value of "+key +":" + hm );
		        		

					 
				        for (Map.Entry<String,String> entry : hm.entrySet())  {
				        	String check = entry.getKey();
				        	if(check.equals(key)) {
				        		JSONObject jsonsearch = new JSONObject();
				        		jsonsearch.put(entry.getKey(),entry.getValue());
				        		if(entry.getValue().length()<=16*1000) {
				        		System.out.println("The value of "+key +":" +"\""+entry.getValue() + "\"");
				        		break;				        		
				        		}else {
					        		System.out.println("value limit exceeded");
				        		}
				        	}
				  }
				 }
				 else {System.out.println("key is not present during Search operation");
				 System.out.println(hm);
				 }
			 }catch(IOException  |ParseException e ) {
				 e.printStackTrace();
					System.out.println(" ERROR : cannot retreive data from file" );
			 }
			 }
			 else {
					System.out.println("Error : File Size limit exceeded || key length exceeded ");
				
				 }
		
	}
	
//search methods ends

	
	public static synchronized void Modify(String key , String value) {
		//String value=value.toString();
		
		File file = new File("D:\\new folder\\inout.json");
		try {
			if(file.createNewFile()) {
				System.out.println("File is created");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
		
	if(file.length()==0) {
		JSONObject jput = new JSONObject();
		jput.put("000", "000");
		
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(jput.toString());
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
		
		JSONParser jp = new JSONParser();
		try {
			FileReader fr = new FileReader(file);
			Object obj=jp.parse(fr);
			JSONObject json = (JSONObject) obj;
			
			HashMap<String , String> hm =new Gson().fromJson(json.toString(),HashMap.class);
			if(hm.containsKey(key)) {
				
				hm.remove(key);
				if(hm.containsKey(key)) {
					hm.remove(key);
				
				}else {
					hm.put(key, value);
					JSONObject jb=new JSONObject();
					jb.putAll(hm);
					
					  try {
				 	         FileWriter fw = new FileWriter(file.getAbsolutePath());
				 	         fw.write(jb.toString());
				 	         fw.close();
				 	         System.out.println(key+"Key-value pair inserted Successfully");
				 	          } catch (IOException e) {
				 	         
				 	         e.printStackTrace();
				 	          }
					
				}
				
				/*
				 Iterator it=hm.entrySet().iterator();
				 int threshold;
				 while(it.hasNext()){
				     Map.Entry<String,String> item=(Map.Entry<String,String>)it.next();
				    
				     String check = item.getKey();
			        	if(check.equals(key)) {
				        hm.replace(key, value);
				   System.out.println("key modified successfuly " + key);
				   break;

				     }*/
			       
    	 	// System.out.println("key not found during delete operation :-" );
			  
			 }else {
				 System.out.println("Value cannot be found as Key is absent : " + key );
			 }
			
			
			
			
		}catch(IOException | ParseException e) {
			e.printStackTrace();
				System.out.println(RED_BRIGHT+ " ERROR : cannot retreive data from file"+ RESET  );

		}
   		
		
	}
	
	
	//
	
	
	
	
	public static void DeleteAll() {
		
		File file = new File("D:\\new folder\\inout.json");
		try {
			if(file.createNewFile()) {
				System.out.println("File is created");
			}
			
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
		
		
	
			if(file.length()==0) {
				System.out.println("File empty");
				JSONObject jp = new JSONObject();
				jp.put("000","000");
				
				try {
					FileWriter fw = new FileWriter(file);
					fw.write(jp.toString());
					fw.close();
				
				}catch(IOException e) {
					e.printStackTrace();
				}
			}else {
				
				// RandomAccessFile raf = new RandomAccessFile(file, "rw");
				    try {
						 RandomAccessFile raf = new RandomAccessFile(file, "rw");

						raf.setLength(0);
						System.out.println(file.toString());

						if(file.length()==0) {
							System.out.println("File is empty");
							
							
							}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
	 					System.out.println(RED_BRIGHT+ " ERROR : cannot retreive data from file"+ RESET  );

					}
			}
				    
				    
			}
			




	public static void SearchALL() {
		
		
		File file = new File("D:\\new folder\\inout.json");
		try {
			if(file.createNewFile()) {
				System.out.println("File is created");
			}			
		}catch(IOException e) {
			e.printStackTrace();			
		}
		

			if(file.length()==0) {
				System.out.println("File empty");
			}
			else {
			JSONParser jp = new JSONParser();
			try {
				FileReader fr = new FileReader(file);
				Object obj=jp.parse(fr);
				JSONObject json = (JSONObject) obj;
	/*
				HashMap<String,String> hm = new Gson().fromJson(json.toString(),HashMap.class);
				JSONObject js = new JSONObject();
				js.putAll(hm);
				FileWriter fw = new FileWriter(file);
				fw.write(js.toString());
				fw.close();
				fr.close();*/
			System.out.println("JSON : " +json );
				
				
			}catch(IOException|ParseException e) {
				//e.printStackTrace();
				System.out.println("cannot retrieve data from file");
				e.printStackTrace();
			}
			}
}
	
}




