import java.time.Duration;
import java.time.LocalDateTime;

public class Sample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		LocalDateTime t1 = LocalDateTime.now();
		LocalDateTime t2 = LocalDateTime.of(2019,11,5,18,22,41,604);
		Duration d = Duration.between(t2, t1);
//		int sec = 30;
//      int hour = sec / 3600;
//      int min = (sec%3600) / 60;
//      sec = sec % 60;
		int sec = 30;
		int hour = 120;
		int min = 21;
        String date = hour + ":" + min + ":" + sec;
        System.out.println(sumTime(date,30));
		System.out.println(t1.getYear());
		System.out.println(t1.getMonthValue());
		System.out.println(t1.getDayOfMonth());
		System.out.println("勤務時間" + date);
	}
	public static String monthTime(int sec) {
		int hour = sec / 3600;
		int min = (sec%3600) / 60;
		sec = sec % 60;
		String str = hour + ":" + min +":" +sec;
		return str;
	}
	public static String sumTime(String monthTime,int sec) {
		String[] time = new String[3];
		time = monthTime.split(":", 0);
		int sum = Integer.parseInt(time[0]) * 3600;
		sum += Integer.parseInt(time[1]) * 60;
		sum += Integer.parseInt(time[2]);
		sum += sec;
		String str = monthTime(sum);
		return str;
	}

}
