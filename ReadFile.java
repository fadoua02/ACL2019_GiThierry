import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ReadFile {

	public static int[] read(String fichier){
		int[] lab = new int[15*15];
		String adressedufichier = System.getProperty("user.dir") + "/" + "Ressources" + "/";
		try{
			InputStream ips=new FileInputStream(adressedufichier+fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			int j=0;
			while ((ligne=br.readLine())!=null){
				for (int i=0; i<15; i++) {
					lab[i+j]=Integer.parseInt(ligne.split(", ")[i]);
				}
				j+=15;
			}
			br.close(); 
		}  
		catch (Exception e){
			System.out.println(e.toString());
		}
		return lab;
	}
}