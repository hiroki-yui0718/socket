import java.util.Calendar;

public class MonthlyCalendar {
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month  = cal.get(Calendar.MONTH) + 1;
		System.out.println(year + "年" +month +"月");
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		// 月の初めの曜日を求めます。
		calendar.set(year, month - 1, 1);// 引数: 1月: 0, 2月: 1, ...
		int startDay = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(startDay);
		//月末の日付を求めます。
		calendar.add(Calendar.MONTH, 1);
		calendar.add(Calendar.DATE, -1);
		int lastDate = calendar.get(Calendar.DATE);
		System.out.println(lastDate);
		String[] week = {" ","日","月","火","水","木","金","土"};
		int i = 1;
		int j = startDay;
		loop: while(true) {
			while(j < week.length) {
				System.out.print(week[j]);
				System.out.print(" ");
				i++;
				j++;
				if(j == 8)j = 1;
				if(i > lastDate) {
					break loop;

				}

			}
		}
		System.out.println();
		for(j = 1;j < lastDate + 1;j++) {
			System.out.print(j);
			System.out.print(" ");

		}
	}


}

