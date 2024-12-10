package com.ruben.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // No es necesario usar un OnClickListener dentro del onCreate para los campos
        // de usuario y contraseña, ya que el método doLogin() se invoca desde un botón.
    }

    // Método de login que se invoca desde un botón en el layout
    public void doLogin(View view) {
        // Usar los campos correctos para el nombre de usuario y la contraseña
        String username = ((EditText) findViewById(R.id.inputUsuario)).getText().toString();  // Campo para el nombre de usuario
        String password = ((EditText) findViewById(R.id.inputPassword)).getText().toString();  // Campo para la contraseña

        // Verificar que los campos no estén vacíos
        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "El nombre de usuario y la contraseña no deben estar vacíos", Toast.LENGTH_SHORT).show();
        } else {
            // Verificar las credenciales
            if (username.equals("Berto") && password.equals("bakar")) {
                Intent intent = new Intent(this, Activity3.class);  // Si las credenciales son correctas
                intent.putExtra("username", username);
                startActivity(intent);  // Iniciar Activity3
            } else {
                Toast.makeText(getApplicationContext(), "Credenciales incorrectas", Toast.LENGTH_SHORT).show();  // Si las credenciales son incorrectas
            }
        }
    }

    // Método para cerrar la actividad
    public void doExit(View view) {
        finish();  // Cierra la actividad actual
    }
}
