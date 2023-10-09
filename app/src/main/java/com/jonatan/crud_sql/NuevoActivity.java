package com.jonatan.crud_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jonatan.crud_sql.db.DbContacts;

public class NuevoActivity extends AppCompatActivity {
    EditText txtName, txtPhone, txtEmail;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtEmail = findViewById(R.id.txtEmail);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener(){

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                DbContacts dbContacts = new DbContacts(NuevoActivity.this);
                long id = dbContacts.insertContact(txtName.getText().toString(), txtPhone.getText().toString(),
                        txtEmail.getText().toString());
                if (id>0){
                    Toast.makeText(NuevoActivity.this, "Register Saved.", Toast.LENGTH_LONG);
                }else{
                    Toast.makeText(NuevoActivity.this, "Error when save this register.", Toast.LENGTH_LONG);
                }
            }
        });
    }

    private void clear(){
        txtName.setText(' ');
        txtPhone.setText(' ');
        txtEmail.setText(' ');
    }
}