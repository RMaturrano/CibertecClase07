package pe.cibertec.demo01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import pe.cibertec.demo01.entities.Person;

/**
 * Created by Android-SAB-PM on 21/05/2016.
 */
public class SecondActivity extends AppCompatActivity {

    private TextInputLayout tilSecondName, tilSecondLast, tilSecondDoc, tilSecondAge, tilSecondPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tilSecondName = (TextInputLayout) findViewById(R.id.tilSecondName);
        tilSecondLast = (TextInputLayout) findViewById(R.id.tilSecondLast);
        tilSecondDoc = (TextInputLayout) findViewById(R.id.tilSecondDoc);
        tilSecondAge = (TextInputLayout) findViewById(R.id.tilSecondAge);
        tilSecondPhone = (TextInputLayout) findViewById(R.id.tilSecondPhone);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.second_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Capturo el click de la flecha hacia atrás
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else  //Capturo el click del guardar
            if (item.getItemId() == R.id.abSecondSave) {
            save();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void save() {
        if (tilSecondName.getEditText().getText().toString().trim().isEmpty())
            showMessage("Ingrese su nombre");
        else if (tilSecondLast.getEditText().getText().toString().trim().isEmpty())
            showMessage("Ingrese su apellido");
        else if (tilSecondDoc.getEditText().getText().toString().trim().isEmpty())
            showMessage("Ingrese su documento");
        else if (tilSecondDoc.getEditText().getText().toString().trim().length() < 8)
            showMessage("Su documento debe ser de 8 dígitos");
        else if (tilSecondAge.getEditText().getText().toString().trim().isEmpty())
            showMessage("Ingrese su edad");
        else if (tilSecondPhone.getEditText().getText().toString().trim().isEmpty())
            showMessage("Ingrese su teléfono");
        else {
            Person person = new Person();
            person.setName(tilSecondName.getEditText().getText().toString().trim());
            person.setLastName(tilSecondLast.getEditText().getText().toString().trim());
            person.setDoc(tilSecondDoc.getEditText().getText().toString().trim());
            person.setAge(Integer.parseInt(tilSecondAge.getEditText().getText().toString().trim()));
            person.setPhone(tilSecondPhone.getEditText().getText().toString().trim());
            Intent intent = new Intent();
            intent.putExtra("person", person);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    private void showMessage(String message) {
        new AlertDialog.Builder(SecondActivity.this).setTitle(R.string.app_name).setMessage(message).setPositiveButton("Aceptar", null).show();
    }
}