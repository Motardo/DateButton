DateButton
==========

<<<<<<< HEAD
A date picker button widget for Android. <br />
A DateButton is a Button that displays a date. When the user clicks the button, 
a DatePickerDialog is started allowing the user to select a new date. The project consists
of the DateButton class and DatePickedCallback interface.
<br /><br />
The DateButton class: <br />
A DateButton can be instantiated in the same way as a regular Button, either
programmatically via it's constructors, or by including it in the .xml like this:
<br />
```xml
<edu.wilson.datebutton.DateButton
    android:id="@+id/myDateButton"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:textSize="30sp" />
```
The date is set to the current date when the DateButton is first created. You can change the
date with setDate(), and you can change the display format of the date with setDateFormat()
<br /><br />
The DatePickedCallback interface: <br />
The activity can be notified whenever the user sets the date by defining a callback 
function and setting it to the DateButton like this:
```java
DatePickedCallback myCallback = new DatePickedCallback() {
	public void onDatePicked(long milliseconds) {
		// do something here
	}
};

((DateButton) findViewById(R.id.myDateButton)).setDatePickedCallback(myCallback);
```
=======
A date picker button widget for Android
>>>>>>> refs/remotes/upstream/master
