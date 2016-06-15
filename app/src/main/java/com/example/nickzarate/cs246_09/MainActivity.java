package com.example.nickzarate.cs246_09;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences preferenceSettings;
    private SharedPreferences.Editor preferenceEditor;
    private static final int PREFERENCE_MODE_PRIVATE = 0;
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();
        TextView t = (TextView) findViewById(R.id.counter);
        preferenceSettings = getPreferences(PREFERENCE_MODE_PRIVATE);
        preferenceEditor = preferenceSettings.edit();
        count = preferenceSettings.getInt("counter", count);
        t.setText(Integer.toString(count));
    }

    public void addOne(View view) {
//        Log.e("count", Integer.toString(count));
        TextView t = (TextView) findViewById(R.id.counter);
        t.setText(Integer.toString(++count));
    }

    public void saveCount(View view) {
        TextView t = (TextView) findViewById(R.id.counter);
        preferenceSettings = getPreferences(PREFERENCE_MODE_PRIVATE);
        preferenceEditor = preferenceSettings.edit();
        preferenceEditor.putInt("counter", Integer.parseInt(t.getText().toString()));
        preferenceEditor.commit();
    }
}
