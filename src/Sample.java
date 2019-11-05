import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Sample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		LocalDateTime t1 = LocalDateTime.now();
		LocalDateTime t2 = LocalDateTime.of(2019,11,5,18,22,41,604);
		Duration d = Duration.between(t2, t1);
		int sec = 1500;
        int hour = sec / 3600;
        int min = (sec%3600) / 60;
        sec = sec % 60;
        LocalTime t3 = LocalTime.of(hour,min,sec);
		System.out.println(t3.toString());
	}

}
