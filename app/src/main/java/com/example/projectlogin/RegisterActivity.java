package com.example.projectlogin;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.File;
import java.io.FileOutputStream;

public class RegisterActivity extends AppCompatActivity {

    EditText editUsername, editPassword, editEmail, editNamaLengkap
            , editAsalSekolah, editAlamat;
    Button btnSimpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setTitle("Register");
        editUsername    = findViewById(R.id.editUsername);
        editPassword    = findViewById(R.id.editPassword);
        editNamaLengkap = findViewById(R.id.editNamaLengkap);
        editEmail       = findViewById(R.id.editEmail);
        editAsalSekolah = findViewById(R.id.editAsalSekolah);
        editAlamat      = findViewById(R.id.editAlamat);
        btnSimpan       = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidation()){
                    simpanFileData();

                }else {
                    Toast.makeText(RegisterActivity.this, "Mohon Lengkapi datanya", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    boolean isValidation(){
        if(editUsername.getText().toString().equals("") || editPassword.getText().toString().equals("") ||
        editNamaLengkap.getText().toString().equals("") || editEmail.getText().toString().equals("") ||
        editAsalSekolah.getText().toString().equals("") || editAlamat.getText().toString().equals("")){
            return false;
        }else {
            return true;
        }
    }

    void simpanFileData(){
        String isiFile = editUsername.getText().toString() + ";" + editPassword.getText().toString() + ";" + editNamaLengkap.getText().toString() + ";" +
                editEmail.getText().toString() + ";" + editAsalSekolah.getText().toString() + ";" + editAlamat.getText().toString();
        File file = new File(getFilesDir(), editUsername.getText().toString());
        try{
            file.createNewFile();
            outputStream = new FileOutputStream(file,false);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        Toast.makeText(this, "Registerasi Berhasil", Toast.LENGTH_SHORT).show();
        onBackPressed();
    }
}