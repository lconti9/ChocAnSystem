import java.io.IOException;
import java.util.Calendar;

//@author Luca Conti

public class Timer {
	
	//Function to check if it is midnight on Friday and then run main accounting procedure
	public static void runMainAccountingProcedure() throws IOException {
		//Creates instance of Date and Time
		Calendar cal = Calendar.getInstance();
		//Checks if Date is a Friday and if Time is 0 (Midnight)
		//if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY && cal.getTimeInMillis() == 0) {
			ReportController.runMainAccountingProcedure();		
		//}
	}
}