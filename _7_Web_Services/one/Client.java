import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.ws.http.HTTPException;

public class Client {
    public static void main(String[] args) {
        try {
            
            URL obj = new URL("http://localhost:8080/add?a=4&b=5");

            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if(responseCode == 200){
                BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
                );
                String inline;
                StringBuilder response = new StringBuilder();
                while((inline = in.readLine()) != null ){
                    response.append(inline);
                }
                in.close();
                System.out.println("REsponse: " +response);
            }
            else{
                System.out.println("falide");
            }
            

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
