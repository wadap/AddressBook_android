package jp.wadap.addressbook.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import org.w3c.dom.Text;

public class MainActivity extends ActionBarActivity {

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view){
        Intent i = new Intent(this, SubmitActivity.class);

        TextView name  = (TextView)findViewById(R.id.editText);
        TextView email = (TextView)findViewById(R.id.editText2);

        i.putExtra("email", email.getText().toString());
        i.putExtra("name",  name.getText().toString());
        startActivity(i);
    }

    public void showData(View view){
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        String email = sharedPref.getString(SubmitActivity.key_email, "").toString();
        String name  = sharedPref.getString(SubmitActivity.key_name, "").toString();

        TextView email_view = (TextView)findViewById(R.id.email_view);
        TextView name_view  = (TextView)findViewById(R.id.name_view);

        email_view.setText(email);
        name_view.setText(name);
    }

    public void clear(View view){
        TextView name  = (TextView)findViewById(R.id.editText);
        TextView email = (TextView)findViewById(R.id.editText2);

        name.setText("");
        email.setText("");
    }
}
