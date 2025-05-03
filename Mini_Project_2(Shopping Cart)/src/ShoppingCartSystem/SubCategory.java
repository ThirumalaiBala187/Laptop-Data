package ShoppingCartSystem;

public class SubCategory {
	
	private int subCategoryId;
	
	private String subCategoryName;

	public SubCategory(int subCategoryId, String subCategoryName) {
		
		this.subCategoryId = subCategoryId;
		
		this.subCategoryName = subCategoryName;
	}

	public int getSubCategoryId() {
		
		return subCategoryId;
	
	}

	public void setSubCategoryId(int subCategoryId) {
	
		this.subCategoryId = subCategoryId;
	
	}

	public String getSubCategoryName() {
	
		return subCategoryName;
	
	}

	public void setCategoryName(String subCategoryName) {
	
		this.subCategoryName = subCategoryName;
	
	}	

}
