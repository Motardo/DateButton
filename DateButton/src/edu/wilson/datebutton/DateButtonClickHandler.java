package edu.wilson.datebutton;

/**
 * interface that the activity will implement to do something when the date is changed
 * @author Nathan
 *
 */
public interface DateButtonClickHandler {
	/**
	 * the activity can provide a definition for this callback
	 * 
	 * @param milliseconds the date that the user picked in milliseconds since 1/1/1970
	 */
	public void onDateButtonClicked(long milliseconds); // implement this method
}
