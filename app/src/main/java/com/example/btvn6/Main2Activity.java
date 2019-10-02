package com.example.btvn6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
TextView tvtime, tvdate, tvtags, tvweeks;
Button btntune;
EditText titte, descreption;
Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        titte = findViewById(R.id.tittles);
        descreption = findViewById(R.id.descrept);
        tvtime = findViewById(R.id.gio);
        tvdate = findViewById(R.id.ngay);
        tvtags = findViewById(R.id.tags);
        tvweeks = findViewById(R.id.weeks);
        spinner = findViewById(R.id.spinne);
        btntune = findViewById(R.id.tune);
        ArrayList<String> a = new ArrayList<>();
        a.add("work");
        a.add("home");
        a.add("love");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_spinner_item, a);
        spinner.setAdapter(arrayAdapter);
        tvtags.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                final String[] tagarray = {"Family", "Game", "VTC", "Android", "Friend"};
                final boolean[] checkedtagarray = {true, false, true, false, true};
                final List<String> taglist = Arrays.asList(tagarray);
                        builder.setTitle("Choise tags:");
                        builder.setIcon(R.drawable.nen);
                        builder.setMultiChoiceItems(tagarray, checkedtagarray, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which, boolean ischecked) {
                                checkedtagarray[which] = ischecked;
                                String currenItem = taglist.get(which);
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                tvtags.setText(" ");
                                for (int j = 0; j<checkedtagarray.length;j++){
                                    boolean checked = checkedtagarray[j];
                                    if (checked){
                                        tvtags.setText(tvtags.getText()+taglist.get(j)+", ");
                                    }
                                }
                                Toast.makeText(getBaseContext(),"OK",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("CANCLE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(),"CANCLE", Toast.LENGTH_LONG).show();
                            }
                        });
                        AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        tvweeks.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                String[] week = {"Monday", "Tuesday", "Thurday", "Wednesday", "Friday","Saturday","Sunday"};
                final boolean[] checkweek = {true, false, true, false, true, true, true};
                final List<String> weeklist = Arrays.asList(week);
                       builder.setTitle("Choise tags:")
                        .setMultiChoiceItems(week, checkweek, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                checkweek[i] = b;
                                String strweek = weeklist.get(i);
                            }
                        })
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                tvweeks.setText(" ");
                                for (int j = 0; j<checkweek.length;j++){
                                    boolean checked = checkweek[j];
                                    if (checked){
                                        tvweeks.setText(tvweeks.getText()+weeklist.get(j)+", ");
                                    }
                                }
                                Toast.makeText(getBaseContext(),"OK",Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("CANCLE", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getBaseContext(),"CANCLE", Toast.LENGTH_LONG).show();
                            }
                        });
                       AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    btntune.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            PopupMenu popupMenu = new PopupMenu(getBaseContext(), view);
            popupMenu.getMenuInflater().inflate(R.menu.menu_from, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case R.id.file:
                            Toast.makeText(getBaseContext(), "file",Toast.LENGTH_LONG).show();
                            break;
                        case R.id.defaul: {
                            String[] tunes = {"Nexus Tune", "Vinphone Tune", "Peep Tune", "Nokia Tune", "ESC"};
                            AlertDialog alertDialog = new AlertDialog.Builder(Main2Activity.this)
                                    .setSingleChoiceItems(tunes, 2, new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {

                                        }
                                    })
                                    .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Toast.makeText(getBaseContext(), "From Defaults Cancle", Toast.LENGTH_LONG).show();
                                        }
                                    })
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Toast.makeText(getBaseContext(), "From Defaults ok", Toast.LENGTH_LONG).show();
                                        }
                                    }).create();
                            alertDialog.show();
                        }
                        break;
                    }
                    return false;
                }
            });
        popupMenu.show();
        }
    });
    tvtime.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Calendar calendar = Calendar.getInstance();
            int gio = calendar.get(Calendar.HOUR_OF_DAY);
            int phut = calendar.get(Calendar.MINUTE);
            TimePickerDialog timePickerDialog = new TimePickerDialog(Main2Activity.this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
                    calendar.set(0, 0, 0, i, i1 );
                    tvtime.setText(simpleDateFormat.format(calendar.getTime()));
                }
            },gio, phut, true);
            timePickerDialog.show();
        }
    });
    tvdate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final Calendar calendar = Calendar.getInstance();
            int ngay = calendar.get(Calendar.DATE);
            int thang = calendar.get(Calendar.MONTH);
            int nam = calendar.get(Calendar.YEAR);
            DatePickerDialog datePickerDialog = new DatePickerDialog(Main2Activity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    calendar.set(i,i1,i2);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
                    tvdate.setText(simpleDateFormat.format(calendar.getTime()));
                }
            }, nam, thang, ngay);
            datePickerDialog.show();
        }
    });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_popup, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.saves:
                //{
//                Calendar cal = Calendar.getInstance();
//                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
//                tvdate.setText("27/04/1999");
//                tvtime.setText(simpleDateFormat.format(cal));
//                tvweeks.setText("null");
//                tvtags.setText("null");
//                titte.setText("Luong Huu Ngoc");
//                descreption.setText("My name is Ngoc, not Luong. OK!");
          //  }
                break;
            case R.id.can:
            {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
