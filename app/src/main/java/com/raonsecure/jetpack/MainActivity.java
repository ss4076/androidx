package com.raonsecure.jetpack;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "AndroidX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MainActivity");
        setContentView(R.layout.activity_main);
//        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host);
//        NavGraph graph = navController.getNavInflater().inflate(R.navigation.nav_graph);
//        navController.setGraph(graph);
    }


}