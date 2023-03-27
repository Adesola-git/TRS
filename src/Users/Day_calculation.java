package Users;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Day_calculation {
    public static void d() {
        GregorianCalendar date;
        String date_selection = "260323";//Date Entry
        int dd, mm, yy, day;
        try {
            Integer.valueOf(date_selection);
        }catch (NumberFormatException e){
            return;
        }
        dd = Integer.valueOf(date_selection.substring(0, 2));
        mm = Integer.valueOf(date_selection.substring(2, 4)) - 1;
        yy = Integer.valueOf(date_selection.substring(4, 6));
        date = new GregorianCalendar(yy + 2000, mm, dd);
        System.out.println(date.get(Calendar.DAY_OF_WEEK));
    }
}
