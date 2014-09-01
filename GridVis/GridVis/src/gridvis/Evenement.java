package gridvis;

public class Evenement {
	
	private  
		int time;
	    int workersrc;
	    int workerdest;
	    
	
	public
	Evenement(int t,int src,int dest)
	{
		time=t;
		workersrc=src;
		workerdest=dest;
		
	} 
		
	int getTime(){
			return time;
	}
	
	int getWorkersrc(){
		return workersrc;
    }
	
	int getWorkerdest(){
		return workerdest;
    }
	
	void setTime(int t){
		time=t;
    }

    void setWorkersrc(int wsrc){
	    workersrc=wsrc;
    }

    void setWorkerdest(int wdst){
	    workerdest=wdst;
    }

}
