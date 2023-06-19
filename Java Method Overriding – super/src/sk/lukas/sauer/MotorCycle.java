package sk.lukas.sauer;

public class MotorCycle extends Bicycle {
	
	
	public MotorCycle(){
        System.out.println("Hello I am a motorcycle, I am "+ defineMe());

        String temp= super.defineMe(); 

        System.out.println("My ancestor is a cycle who is "+ temp );
    }   
	
	public String defineMe(){
        return "a cycle with an engine.";
    }
}
