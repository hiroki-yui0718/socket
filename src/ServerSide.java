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

class Sample1 {
	public void runSample() {

		ServerSocket sSocket = null;
		Socket socket = null;
		BufferedReader reader = null;
		PrintWriter writer = null;

		try{
			//IPアドレスとポート番号を指定してサーバー側のソケットを作成
			sSocket = new ServerSocket();
			sSocket.bind(new InetSocketAddress
					("192.168.3.7",8765));

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
				Sample1 s1 = new Sample1();
				s1.runSample();
			}
		};
		timer.schedule(task, 0, 1000);
	}
}
