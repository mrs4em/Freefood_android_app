package my.example.Freefood_DB;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DisplayMessageActivity2 extends ListActivity {
int[] ct_id;
String[] ct_name = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        String result = null;
        InputStream is = null;
        StringBuilder sb=null;
        
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        //String cityName = intent.getStringExtra(Freefood_DBActivity.EXTRA_MESSAGE);
        String eventName = b.getString("message");//intent.getStringExtra(Freefood_DBActivity.EXTRA_MESSAGE);
        String eventDescription = b.getString("message2");//intent.getStringExtra(Freefood_DBActivity.EXTRA_Description);
        String eventDate = b.getString("message3");//intent.getStringExtra(Freefood_DBActivity.EXTRA_Date);
        String eventTime = b.getString("message4");//intent.getStringExtra(Freefood_DBActivity.EXTRA_Time);
        String eventLocation = b.getString("message5");//intent.getStringExtra(Freefood_DBActivity.EXTRA_Location);
        
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        nameValuePairs.add(new BasicNameValuePair("name",eventName));
        nameValuePairs.add(new BasicNameValuePair("description",eventDescription));
        nameValuePairs.add(new BasicNameValuePair("date",eventDate));
        nameValuePairs.add(new BasicNameValuePair("time",eventTime));
        nameValuePairs.add(new BasicNameValuePair("location",eventLocation));
      //http post
      try{
           HttpClient httpclient = new DefaultHttpClient();
           HttpPost httppost = new HttpPost("http://128.143.47.222/freefood_put.php");
           httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
           HttpResponse response = httpclient.execute(httppost);
           HttpEntity entity = response.getEntity();
           is = entity.getContent();
           }catch(Exception e){
               Log.e("log_tag", "Error in http connection"+e.toString());
          }
      //convert response to string
      try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
             sb = new StringBuilder();
             sb.append(reader.readLine() + "\n");
             String line="0";
             while ((line = reader.readLine()) != null) {
                            sb.append(line + "\n");
              }
              is.close();
              result=sb.toString();
              }catch(Exception e){
                    Log.e("log_tag", "Error converting result "+e.toString());
              }
//      //paring data      
//      
//      JSONArray jArray;
//      try{
//            jArray = new JSONArray(result);
//            JSONObject json_data=null;
//            ct_name=new String[jArray.length()];
//            ct_id=new int[jArray.length()];
//            
//            for(int i=0;i<jArray.length();i++){
//                   json_data = jArray.getJSONObject(i);
//                   ct_id[i]=json_data.getInt("CITY_ID");
//                   ct_name[i]=json_data.getString("CITY_NAME");               }
//            }
//            catch(JSONException e1){
//            Toast.makeText(getBaseContext(), "No City Found" ,Toast.LENGTH_LONG).show();
//            } catch (ParseException e1) {
//       e1.printStackTrace();
//}
//    setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, ct_name));
//    ListView lv;
//lv = getListView();
//lv.setTextFilterEnabled(true);
//lv.setOnItemClickListener(new OnItemClickListener() {
//public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//// When clicked, show a toast with the TextView text
////Toast.makeText(getApplicationContext(), ct_name[position]+", with id number "+ct_id[position]+", was Clicked", Toast.LENGTH_LONG).show();
	AlertDialog.Builder adb=new AlertDialog.Builder(DisplayMessageActivity2.this); 
    adb.setTitle("Event Information");
    adb.setMessage("Thank you for submitting event"); 
//    //adb.setPositiveButton("Book", new DialogInterface.OnClickListener() {
//       // public void onClick(DialogInterface dialog, int id) {
//           // Intent intent = new Intent(TaxiMain.this, Booking.class);
//           // intent.putExtra("booking",  taxiNames[selectedPosition]);
//           // intent.putExtra("address",  taxiAddresses[selectedPosition]);
//           // startActivity(intent);
//        //}
//    //});
    adb.setNegativeButton("Return to List", null); 
    adb.show();
////}
//
//}
//});
}
}
