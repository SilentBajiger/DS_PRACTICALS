import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class C1 {
    public static void main(String[] args) {
        try {
            
            URL obj = new URL("http://localhost:8080/add?a=10&b=50");
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK){
                BufferedReader in  = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inline;
                StringBuilder response = new StringBuilder();
                while((inline = in.readLine()) != null) response.append(inline);
                in.close();
                System.out.println("Response : " + response);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
