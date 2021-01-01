package Library;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class MainLib extends Thread{
	static Thread thread = new Thread();
	
public static void main(String [] args) {
	
				
		System.out.println(" Welcome to library");

}



public static void Create(String key,String value) {	
	final String CREATE = "Create";
	ClientThread cl1 = new ClientThread( thread,CREATE,key,value);
		cl1.start();
}



public static void Modify(String key,String value) {	
	final String MODIFY = "Modify";
	ClientThread cl1 = new ClientThread( thread,MODIFY,key,value);
	cl1.start();
}


public static void Delete(String key) {
	final String DELETE = "Delete";
	ClientThread cl1 = new ClientThread( thread,DELETE,key,"000");
	cl1.start();
}



public static void DeleteAll() {
	final String DELETEALL = "DeleteAll";
	ClientThread cl1 = new ClientThread( thread,DELETEALL,"000","000");
	cl1.start();
	System.out.println(cl1.getName());
}



public static void SearchAll() {
	final String SEARCHALL = "SearchALL";
	ClientThread cl1 = new ClientThread( thread,SEARCHALL,"000","000");
	cl1.start();
	System.out.println(cl1.getName());
}




public static void Create(String key,String value,int timeToLive) {
	final String CREATE = "Create1";		
		ClientThread cl1 = new ClientThread( thread,CREATE,key,value,timeToLive);
		cl1.start();
}



public static void Read(String key) {
	final String READ = "Read";	
	ClientThread cl1 = new ClientThread( thread,READ,key, "000");
	cl1.start();	
}



}
