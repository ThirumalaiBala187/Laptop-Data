package Products;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDB {
	public static void main(String[] args) {
		String filePath=System.getProperty("user.home") + "/Downloads/image_urls.txt";	
		try(BufferedReader reader=new BufferedReader(new FileReader(filePath)); Connection connection=DatabaseConnection.getConnection()){
			String line;
			int i=1;
			while((line=reader.readLine()) != null) {
				String query="Update Products set Img_Url = ? where Product_Id = ?";
				PreparedStatement statement=connection.prepareStatement(query);
				statement.setString(1, line);
				statement.setInt(2, i);
				int rowsAffected=statement.executeUpdate();
				if(rowsAffected > 0) {
					System.out.println("Image URl added Successfully. " + i);
				}
				i++;
			}
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}