package com.example.jerryminotta.registro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre, et_correo, et_pass;
    Button btn_reg;
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db= FirebaseDatabase.getInstance();

        et_nombre= findViewById(R.id.et_nombre);
        et_correo= findViewById(R.id.et_correo);
        et_pass= findViewById(R.id.et_pass);
        btn_reg= findViewById(R.id.btn_reg);


        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario= new Usuario(et_nombre.getText().toString(), et_correo.getText().toString(), et_pass.getText().toString());
                db.getReference().child("usuarios").setValue(usuario);
            }
        });

    }
}
