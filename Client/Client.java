package Clientt;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Library.ClientThread;
import Library.MainLib;
import Library.Method;

public class Client {

	public static void main(String[] args) {
		
		
		MainLib.Create("key1", "value1");
		MainLib.Create("key2", "value2");
		MainLib.Create("key3", "value3",9000);
		MainLib.Create("key1", "value1");  //Duplicates will give Error -"saying key is duplicate"
		MainLib.Read("key1");
	    MainLib.Delete("key3");           //will delete key3 
		MainLib.SearchAll();             // json with {"key1":"value1" ,"key2":"value2" , "key4":"value4$$9000"} 
	
		
		//MainLib.DeleteAll(); To envoked at last if you want to clear the file;
		//MainLib.Modify("key1","value5");
		//as multithreading concept as been used for accesing file for different operation performing all operation
		// at once will be giving clear error as bject key will be still in use if envoked on same method by two th
		//-threads simultaneouly
	
	
	}

}
