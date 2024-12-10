# Paso 1 crear un nuevo proyecto de Android
Añadimos el mainActivity y la activity7.
Añadimos la nueva actividad al AndroidManifest
```XML
        <activity android:name=".Activity3">
            
        </activity>
```

## 1. Corrección de los campos de usuario y contraseña
Creo un campo para el username y otro para la password en vez de usar el mismo para las dos cosas ya que no tiene sentido:
```java
String username = ((EditText) findViewById(R.id.inputUsuario)).getText().toString();  // Para el nombre de usuario
String password = ((EditText) findViewById(R.id.inputPassword)).getText().toString();  // Para la contraseña
```
De esta forma, los valores se obtienen correctamente de los campos correspondientes.

## 2. Eliminación del OnClickListener innecesario
En el código original, estaba utilizando un setOnClickListener dentro de onCreate(), pero esto era innecesario para el botón de login ya que estoy llamando a dologin() desde el XML.

Eliminé el bloque innecesario de código:

```java
findViewById(R.id.inputPassword).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Lógica de validación
    }
});
```
Y ahora, el método doLogin() es el que se encarga de la validación de las credenciales y de hacer la navegación a la siguiente actividad.

## 3. Añadir la validación de las credenciales
En el código original, no se realizaba una validación clara para comprobar si el nombre de usuario y la contraseña eran correctos. Así que añadí una verificación para asegurarme de que los campos no estuvieran vacíos y que las credenciales fueran correctas.

```java
if (username.isEmpty() || password.isEmpty()) {
    Toast.makeText(getApplicationContext(), "El nombre de usuario y la contraseña no deben estar vacíos", Toast.LENGTH_SHORT).show();
} else {
    if (username.equals("Berto") && password.equals("bakar")) {
        Intent intent = new Intent(this, Activity3.class);  // Si las credenciales son correctas
        intent.putExtra("username", username);
        startActivity(intent);  // Navegar a Activity3
    } else {
        Toast.makeText(getApplicationContext(), "Credenciales incorrectas", Toast.LENGTH_SHORT).show();  // Si son incorrectas
    }
}
```

Aquí primero verifico si los campos están vacíos. Si no lo están, entonces compruebo si las credenciales coinciden con las correctas. Si son correctas, paso a Activity3 con un Intent; si no, muestro un Toast para informar que las credenciales son incorrectas.

## 4. Mostrar un mensaje de error si las credenciales son incorrectas
Si el nombre de usuario o la contraseña son incorrectos:
```java
Toast.makeText(getApplicationContext(), "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
```
Este Toast aparece cuando las credenciales no coinciden con los valores predefinidos.


## Resultado final del Main Activity:
```java
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

```

## 5. Activity7
Renombro Activity7 a Activity3
Cuando las credenciales son correctas, la aplicación debe llevar al usuario a Activity3. El código que añadí para navegar a Activity3 es este:
```java
Intent intent = new Intent(this, Activity3.class);
intent.putExtra("username", username);  // Pasar el nombre de usuario a Activity3
startActivity(intent);  // Iniciar Activity3
```
Aquí, paso el nombre de usuario a la siguiente actividad a través de un extra en el Intent, para que pueda ser utilizado allí si es necesario.

## Resultado del Activity3
```java
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        Toast.makeText(getApplicationContext(), "Login Correcto!", Toast.LENGTH_SHORT).show();
    }

    public void doExit(View view) {
        setContentView(R.layout.activity_main);
    }
}

```

# Cambios En el backend del login
Se cambia la lógica para permitir el acceso, por ejemplo si el nombre del usuario comienza con “A”

En la verificación cambiamos en el MainActivity
```java
if (username.equals("Berto") && password.equals("bakar")) {
```

Y escribimos
```java
if (if (username.charAt(0) == 'A')) {
```
