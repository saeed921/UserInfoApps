package com.example.userinfoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth=FirebaseAuth.getInstance();

BottomNavigationView bnv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv=findViewById(R.id.bottomID);
        bnv.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull  MenuItem item) {

                switch (item.getItemId()){


                    case R.id.homeID:
                        Toast.makeText(MainActivity.this, "Home Id", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.insert:
                        Toast.makeText(MainActivity.this, "Inster", Toast.LENGTH_SHORT).show();
                   break;
                    case R.id.list:
                        ProgressDialog progressDialog;
                        progressDialog=new ProgressDialog(MainActivity.this);
                        progressDialog.setTitle("Show list");
                        progressDialog.setMessage("Showing List");
                        progressDialog.show();
                        progressDialog.show();
                        Toast.makeText(MainActivity.this, "list", Toast.LENGTH_SHORT).show();

                        break;


                }

            }
        });
    }








    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.logout: auth.signOut();
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case  R.id.about:
                Toast.makeText(this, "Setting Menu \n Under Maintanance", Toast.LENGTH_SHORT).show();




        }

        return true;
    }
}