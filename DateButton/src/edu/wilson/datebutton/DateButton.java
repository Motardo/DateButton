package edu.wilson.datebutton;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

/**
 * The DateButton widget is a button that, when clicked, displays a {@link DatePickerDialog}.
 * The button text is set to the date selected.
 * <p>
 * A DateButton can be created in the same way as a {@link Button}, either programmatically
 * via it's constructors, or by including it in the .xml like this:
 * <pre>
&lt;edu.wilson.datebutton.DateButton
    android:id="@+id/myDateButton"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:textSize="30sp" /&gt;
 </pre>
 * The date is set to the current date when the DateButton is first created. You can change
 * the date with setDate(), and you can change the display format of the date with setDateFormat()
 * <p>
 * The activity can be notified whenever the user sets the date by defining a callback 
 * function and setting it to the DateButton like this: <br>
 * <pre>
DatePickedCallback myCallback = new DatePickedCallback() {
	public void onDatePicked(long milliseconds) {
		// do something here
	}
};
	
((DateButton) findViewById(R.id.myDateButton)).setDatePickedCallback(myCallback);

 * @author Nathan
 *
 */
public class DateButton extends Button {
	private DatePickedCallback callback = null;
	private Calendar calendar = Calendar.getInstance();
	private SimpleDateFormat sdf = new SimpleDateFormat("E, dd-MMM", Locale.US);
	private final DatePickerDialog.OnDateSetListener dateSetListener =
			new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, 
				int monthOfYear, int dayOfMonth) {
			calendar.set(year, monthOfYear, dayOfMonth, 0, 0, 0);
			updateButtonText();
			if (callback != null) {
				callback.onDatePicked(calendar.getTimeInMillis());
			}
		}
	};
	
	public DateButton(Context context) {
		super(context);
		initialize();
	}

	public DateButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		initialize();
	}

	public DateButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initialize();
	}
	
	/**
	 * use this method to bind a callback method in the activity that will run
	 * when the date is set in the {@link DatePickerDialog}
	 * 
	 * @param callback a method defined in your activity to be called when the user sets the date
	 */
	public void setDatePickedCallback(DatePickedCallback callback) {
		this.callback = callback;
	}

	/**
	 * sets the internal date of the DateButton and it's display text
	 * 
	 * @param milliseconds the date to set in milliseconds since 1/1/1970
	 */
	public void setDate(long milliseconds) {
		this.calendar.setTimeInMillis(milliseconds);
		updateButtonText();
	}
	
	/**
	 * sets the display format for the date in the button text
	 * 
	 * @param sdf an object describing the new date format string
	 */
	public void setDateFormat(SimpleDateFormat sdf) {
		this.sdf = (SimpleDateFormat) sdf.clone();
		updateButtonText();
	}
	
	private final void initialize() {
	    setOnClickListener(new View.OnClickListener() {
	        public void onClick(View view) {
	            // Perform action on click
	        	DatePickerDialog dialog = new DatePickerDialog(view.getContext(), dateSetListener, 
	    				calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
	    				calendar.get(Calendar.DAY_OF_MONTH));
	        	dialog.show();	        	
	        }
	    });
		updateButtonText();
	}
		
	private final void updateButtonText() {
		setText(sdf.format(calendar.getTimeInMillis()));
	}
}