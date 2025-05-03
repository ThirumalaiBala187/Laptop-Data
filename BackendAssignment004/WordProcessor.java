package BackendAssignment004;



public class WordProcessor {
    
	String word;
    
	public WordProcessor(String word) {
    
		this.word = word;
    
	}
    
	public void doBold() {
    
		this.word = "<b>" + this.word + "</b>";
    
	}

    public void doItalic() {
     
    	this.word = "<i>" + this.word + "</i>";
    
    }

    public void doUnderline() {
    
    	this.word = "<u>" + this.word + "</u>";
    
    }

    @Override
    public String toString() {
    
    	return this.word;
    
    }

}