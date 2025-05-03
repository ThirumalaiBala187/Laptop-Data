package BackendAssignment004;

import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

public class StackSample {

    private int capacity = 10;
    
    private List<WordProcessor> stateOfTheWord = new ArrayList<>();
    
    private int top = 0;

    public StackSample() {
    
    }

    public WordProcessor pop() {
       
    	if (top > 0) {
    
    		return this.stateOfTheWord.remove(--top);
        
    	}
        
    	return null;
    
    }

    public void push(WordProcessor wp) {
        
    	if (checkCapacity()) {
           
            this.stateOfTheWord.add(new WordProcessor(wp.word)); 
        
            top++; 
        
    	}
    	
    	else {
        
    		System.out.println("Limited capacity");
        
    	}
    
    }

    public boolean checkCapacity() {

    	return this.top < this.capacity; 
    
    }

    
    public static void main(String[] args) {
    
    	StackSample stackObj = new StackSample();
        
    	Scanner userInput = new Scanner(System.in);
    	
    	List<WordProcessor> redoList = new ArrayList<>();
        
    	System.out.println("Hello User.\nPlease Enter the word:");
        
    	String word = userInput.nextLine();
        
    	WordProcessor wp = new WordProcessor(word);
        
    	stackObj.push(wp); 

        while (true) {
        
        	System.out.println("Enter the action (bold / italic / underline / undo / stop):What do you want to do?\nPress '1' to 'Bold'.\nPress '2' to 'Italic'.\nPress '3' to 'Underline'.\nPress '4' to 'Undo'.\nPress '5' to 'Redo'.\nPress '6' to 'Stop'.");
        	
        	int choice = userInput.nextInt();
            
        	if (choice == 6) {
        		
        		System.out.println("Thank you for visiting.");
            
        		break;
            
        	}
        	
            switch (choice) {
            
	            case 1: {
	            	
	            	if(!redoList.isEmpty()) {
	            		
	            		redoList.clear();
	            		
	            	}
	            
	            	wp.doBold();
	                
	            	stackObj.push(wp); 
	                
	            	break;
	                
	            }
	                
	            case 2: {
	            	
	            	if(!redoList.isEmpty()) {
	            		
	            		redoList.clear();
	            		
	            	}	
	            
	            	wp.doItalic();
	                
	            	stackObj.push(wp); 
	                
	            	break;
	                
	            }
            
	            case 3: {
	            	
	            	if(!redoList.isEmpty()) {
	            		
	            		redoList.clear();
	            		
	            	}
	            	
	            	wp.doUnderline();
	                
	            	stackObj.push(wp);
	                
	            	break;
	                
	            }
	            
	            case 4: {            

	            	WordProcessor wd1 = stackObj.pop();
	                
	            	if (wd1 != null) {
	            		
	            		redoList.add(wd1);
	                
	            		wp.word = stackObj.stateOfTheWord.get(stackObj.stateOfTheWord.size()-1).toString(); 
	                    
	            		System.out.println("Action Undo: " + wd1.word);
	                    
	            	}
	                
	            	break;
	                
	            }
            
	            case 5: {
	            	
	            	if(!redoList.isEmpty()) {
	    	            
		            	WordProcessor redoWord = redoList.get(redoList.size()-1);

		            	stackObj.push(redoWord);
		                    
		            	System.out.println("Action Redo: " + redoWord);
		                    
		            }
	                
	            	break;
	            	
	            	}
	            
	            default:
	            
	            	break;
	            }
            
            
            System.out.println("\nCurrent State: " + wp.word);
            
            System.out.println("\nState of the List is " + stackObj.stateOfTheWord +"\n");
        
        }        
        
        userInput.close();
    
    }
    
}