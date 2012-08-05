package my.example.Freefood_DB;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

public class Freefood_DBActivity extends Activity {
	public final static String EXTRA_MESSAGE = "my.example.datab4.MESSAGE";
	Bundle b = new Bundle();
	public String stringDate = "";
	static final int DIALOG_DATE_ID = 0;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void sendMessage(View view) {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	//EditText editText = (EditText) findViewById(R.id.edit_message);
    	//String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, stringDate);
    	startActivity(intent);
    }
    
    public void sendMessage2(View view) {
    	Intent intent = new Intent(this, DisplayMessageActivity2.class);
    	EditText editText1 = (EditText) findViewById(R.id.edit_message2);
    	//String message = editText1.getText().toString();
    	b.putString("message", editText1.getText().toString());
    	//intent.putExtra(EXTRA_MESSAGE, message);
    	EditText editText2 = (EditText) findViewById(R.id.event_description);
    	//String message2 = editText2.getText().toString();
    	b.putString("message2", editText2.getText().toString());
    	//intent.putExtra(EXTRA_Description, message2);
    	EditText editText3 = (EditText) findViewById(R.id.event_date);
    	//String message3 = editText3.getText().toString();
    	b.putString("message3", editText3.getText().toString());
    	//intent.putExtra(EXTRA_Description, message3);
    	EditText editText4 = (EditText) findViewById(R.id.event_time);
    	//String message4 = editText4.getText().toString();
    	b.putString("message4", editText4.getText().toString());
    	//intent.putExtra(EXTRA_Description, message4);
    	EditText editText5 = (EditText) findViewById(R.id.event_location);
    	//String message5 = editText5.getText().toString();
    	b.putString("message5", editText5.getText().toString());
    	//intent.putExtra(EXTRA_MESSAGE, message);
    	intent.putExtras(b);
    	startActivity(intent);
    }
    public void datePick(View view) {
    	//Intent intent = new Intent(this, DisplayMessageActivity2.class);
    	//EditText editText = (EditText) findViewById(R.id.edit_message2);
    	//String message = editText.getText().toString();
    	//intent.putExtra(EXTRA_MESSAGE, message);
    	//startActivity(intent);
    	showDialog(DIALOG_DATE_ID);
    }
    protected Dialog onCreateDialog(int id){
    	switch(id){
    	case DIALOG_DATE_ID:
    		DatePickerDialog dateDlg = new DatePickerDialog(this, 
    		         new DatePickerDialog.OnDateSetListener() {
    		          
    		         public void onDateSet(DatePicker view, int year,
    		                                             int monthOfYear, int dayOfMonth) 
    		         {
    		                    Time chosenDate = new Time();        
    		                    chosenDate.set(dayOfMonth, monthOfYear, year);
    		                    long dtDob = chosenDate.toMillis(true);
    		                    CharSequence strDate = DateFormat.format("yyyy-MM-dd", dtDob);
    		                    stringDate = strDate.toString();
    		                    Toast.makeText(Freefood_DBActivity.this, 
    		                         "Date picked: " + strDate, Toast.LENGTH_SHORT).show();
    		        }}, 2011,0, 1);
    		//dateMessage = stringDate;
    		             
    		      dateDlg.setMessage("Choose Date");
    		      return dateDlg;
    	}
    	return null;
    	
    	
    }
    
    
}