package jp.wadap.addressbook.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class SubmitActivity extends ActionBarActivity {

    public static final String key_email = "email";
    public static final String key_name  = "name";
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        // intentからデータ取得
        Intent intent = this.getIntent();
        TextView name_view  = (TextView) findViewById(R.id.name);
        TextView email_view = (TextView) findViewById(R.id.email);
        name_view.setText(intent.getStringExtra("name"));
        email_view.setText(intent.getStringExtra("email"));

        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        saveUserData(intent.getStringExtra("name"), intent.getStringExtra("email"));
    }

    public void saveUserData(String name, String email) {
        Editor edit = sharedPref.edit();
        edit.putString(key_email, name);
        edit.putString(key_name, email);
        edit.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.submit, menu);
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
        finish();
    }

}
