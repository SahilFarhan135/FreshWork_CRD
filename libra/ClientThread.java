package Library;

import org.json.simple.JSONObject;

public class ClientThread extends Thread{



	private Thread threadss;
	private String key ;
	private String value;
	private String method;
	//private String value1;
	private int timeToLive;

	
//
	
	
	//

	
	//Time paramter constructor


	
	// serach and delete consructor
	public ClientThread(Thread thread, String method, String key, String value) {
		// TODO Auto-generated constructor stub
		this.threadss=thread;
		this.key=key;
		this.value=value;
		this.method=method;
		
	}

	

	public ClientThread(Thread thread, String method, String key, String value, int timeToLive) {
		// TODO Auto-generated constructor stub
		this.threadss=thread;
		this.key=key;
		this.value=value;
		this.method=method;
		this.timeToLive=timeToLive;
	}



	public void run() {
		if(method.equals("Create")) {
		Method.Create(key,value);
		}
		
		if(method.equals("Delete")){
			Method.Delete(key);
		}
		
		
		if(method.equals("Read")) {
			Method.Read(key);
		}
		if(method.equals("Modify")) {
			Method.Modify(key,value);
		}
		
		if(method.equals("DeleteAll")) {
			Method.DeleteAll();
		}
		if(method.equals("SearchALL")) {
			Method.SearchALL();
		}
		if(method.equals("Create1")) {
			Method_timeToLive.Create(key,value,timeToLive);
		}
		
		
	}

}



