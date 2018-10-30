package com.example.ashwinb.myapplication;
//This is the Home Screen
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
//import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.*;
import com.google.firebase.firestore.EventListener;

import org.w3c.dom.Text;

import java.security.acl.Group;
import java.util.Calendar;

public class home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        String[] names={"Grocery","Pharmacy","Stationary","Condiments"};
        String[] choices={"Grocery","Pharmacy","Stationary","Condiments"};
        String[] description={"Grocery items","All medicines","Photocopy and Scanning","All home appliances"};
        String[] tasknames=new String[1000];
        static String ch;
        int i=0;
    Group group;
    Database mydb;

    //FirebaseAuth mAuth;
    //FirebaseAuth.AuthStateListener mAuthListener;
    /*private FirebaseFirestore db=FirebaseFirestore.getInstance();
    CollectionReference tasks=db.collection("com.example.ashwinb.myapplication.task");*/
    //DocumentReference taskref=db.document("com.example.ashwinb.myapplication.task");
    TextView t1;

   /* @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        try {
            FirebaseApp.initializeApp(this);
        }
        catch (Exception e) {
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        t1=(TextView)findViewById(R.id.t1);
        FloatingActionButton btn=(FloatingActionButton)findViewById(R.id.floatingActionButton4);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.parseColor("#80000000"));
        toolbar.setBackgroundResource(R.color.dark_color);
        toolbar.setLogo(R.drawable.picture1);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        ListView listview=(ListView)findViewById(R.id.ListView);
        CustomAdapter cm=new CustomAdapter();
        listview.setAdapter(cm);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(home.this,task_display.class);
                intent.putExtra("tname",names[i]);
                startActivity(intent);
            }
        });
        /*tasks.whereEqualTo("uid",1).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for(QueryDocumentSnapshot documentSnapshot:queryDocumentSnapshots){
                            task task1  = documentSnapshot.toObject(task.class);
                            task1.setDocumentId(documentSnapshot.getId());
                            String tname=task1.getName();
                            tasknames[i]=tname;
                        }
                    }
                });*/
        /*mAuth=FirebaseAuth.getInstance();
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    if(firebaseAuth.getCurrentUser()==null){
                        startActivity(new Intent(home.this,Login_screen.class));
                    }
            }
        };*/
        mydb=new Database(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_mail) {
            // Handle the camera action
        } else if (id == R.id.nav_Call_Us) {

        } else if (id == R.id.nav_about) {
            }
            else if(id==R.id.logout){
            //mAuth.signOut();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void TaskEntry(View view) {
        Intent i1=new Intent(this,TaskEntry.class);
        startActivity(i1);
    }

    public void setAlarm(View view) {
        //Toast.makeText(getApplicationContext(),"Notification set",Toast.LENGTH_LONG).show();
        final AlertDialog.Builder alertdialog=new AlertDialog.Builder(this);
        alertdialog.setTitle("Choose a task");
        alertdialog.setSingleChoiceItems(choices, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ch=choices[i];
                Toast.makeText(home.this,"notification set for"+choices[i],Toast.LENGTH_LONG).show();
                Calendar calender=Calendar.getInstance();
                Intent intent=new Intent(getApplicationContext(), Notification_reciever.class);
                intent.putExtra("choices",choices[i]);
                PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calender.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
                calender.set(Calendar.DATE,23);
                calender.set(Calendar.HOUR_OF_DAY,23);
                calender.set(Calendar.MINUTE,31);
            }
        });
        //View row=getLayoutInflater().inflate(R.layout.row_lists,null);
        /*ListView l1=new ListView(this);
        ArrayAdapter<String> arr=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,choices);
        l1.setAdapter(arr);
       final int day;

        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ViewGroup vg=(ViewGroup)view;
              TextView txt=(TextView)vg.findViewById(R.id.list1);
                Toast.makeText(home.this,txt.getText().toString(),Toast.LENGTH_LONG).show();
                System.out.println(txt.getText().toString());

            }
        });*/

        /*alertdialog.setCancelable(true);
        alertdialog.setPositiveButton("Ok",null);*/
        alertdialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog mdialog=alertdialog.create();
        mdialog.show();

        /*arr.notifyDataSetChanged();
        alertdialog.setView(l1);
        AlertDialog dialog=alertdialog.create();
        dialog.show();*/

    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view=getLayoutInflater().inflate(R.layout.customlist,null);

            TextView text1=(TextView)view.findViewById(R.id.t1);
           // t1.setText(tasknames[i]);
            text1.setText(names[i]);
           // .setText(description[i]);

            return view;
        }
    }
}

