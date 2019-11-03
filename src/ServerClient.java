import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;

class Server implements Runnable{
	public void run() {

		ServerSocket sSocket = null;
		Socket socket = null;
		BufferedReader reader = null;
		PrintWriter writer = null;

		try{
			Thread.sleep(1000);
			//IPアドレスとポート番号を指定してサーバー側のソケットを作成
			sSocket = new ServerSocket();
			sSocket.bind(new InetSocketAddress
					("127.0.0.1",8765));

			System.out.println("クライアントからの入力待ち状態");

			//クライアントからの要求を待ち続けます
			socket = sSocket.accept();

			//クライアントからの受取用
			reader = new BufferedReader(
					new InputStreamReader
					(socket.getInputStream()));

			//サーバーからクライアントへの送信用
			writer = new PrintWriter(
					socket.getOutputStream(), true);

			//無限ループ　byeの入力でループを抜ける
			String line = null;

			line = reader.readLine();
			
			System.out.println("クライアントで入力された文字＝" + line);


		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if (reader!=null){
					reader.close();
				}
				if (writer!=null){
					writer.close();
				}
				if (socket!=null){
					socket.close();
				}
				if (sSocket!=null){
					sSocket.close();
				}
				System.out.println("サーバー側終了です");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws ParseException {
		Timer timer = new Timer(false);
		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				Server s1 = new Server();
				Thread thread = new Thread(s1);
				thread.start();

				try {
					Thread.sleep(1000);
					Client s2 = new Client();
					s2.runSample();
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		};

		timer.schedule(task, 0, 1000);


	}
}
class Client {
	public void runSample() {

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
			String line = csInput.readLine();
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

	}



}
