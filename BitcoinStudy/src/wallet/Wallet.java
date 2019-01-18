package wallet;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
	static List<String> privateKeyList = new ArrayList<String>();
	//기본키, 개인키를 txt파일로 출력
	public Wallet(){
		this.privateKeyList = privateKeyList;
	}
	public Wallet(List<String> privateKeyList){
		this.privateKeyList = privateKeyList;
	}

	public static void Create(String fileName) {
		 try{
	            
	            FileOutputStream file = new FileOutputStream("C:\\Users\\BASE_LAB\\Desktop\\test.txt");
	            BufferedOutputStream bufferedWriter = new BufferedOutputStream(file);
	            ObjectOutputStream ooutput = new ObjectOutputStream(bufferedWriter);
	            
	            ooutput.writeObject(privateKeyList);
	         	bufferedWriter.close();
	           
	        }catch (IOException e) {
	            System.out.println(e);
	        }

	}
	
	public static void Load(String fileName){
		 try{
	            File file = new File("C:\\Users\\BASE_LAB\\Desktop\\test.txt");
	            FileReader filereader = new FileReader(file);
	           
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String line = "";
	            
	            while((line = bufReader.readLine()) != null) {
	            	privateKeyList.add(line);
	            }          
	            
	            bufReader.close();
	        }catch (FileNotFoundException e) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }

	}
	
	public static List<String> getPrivateKeyList(){
		return privateKeyList;
	}
}
