import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSide {
	public String runSample(String line) {

		Socket cSocket = null;
		BufferedReader csInput = null;
		PrintWriter writer = null;
		BufferedReader reader = null;
		String send = null;

		try{
			//IPアドレスとポート番号を指定してクライアント側のソケットを作成
			cSocket = new Socket("127.0.0.1", 8765);

			//クライアント側での入力用
			csInput = new BufferedReader
					(new InputStreamReader(System.in));

			//クライアント側からサーバへの送信用
			writer = new PrintWriter
					(cSocket.getOutputStream(), true);

			//サーバ側からの受取用
			reader = new BufferedReader
					(new InputStreamReader
							(cSocket.getInputStream()));
				System.out.println("-------------------");
				System.out.println("偶数の数値を入力して下さい");
				System.out.println("-------------------");
				line = csInput.readLine();
				writer.println(line);


		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if (reader != null) {
					reader.close();
				}
				if (writer != null) {
					writer.close();
				}
				if (csInput != null) {
					csInput.close();
				}
				if (cSocket != null) {
					cSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
	        System.out.println("クライアント側終了です");

		}
		return send;

		}
}
