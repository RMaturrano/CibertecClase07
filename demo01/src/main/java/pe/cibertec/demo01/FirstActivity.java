package pe.cibertec.demo01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import pe.cibertec.demo01.adapter.recyclerview.RVFirstAdapter;
import pe.cibertec.demo01.entities.Person;

public class FirstActivity extends AppCompatActivity {

    private RVFirstAdapter mRVFirstAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        //Inflamos el toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //Lo asignamos como ActionBar
        setSupportActionBar(toolbar);

        //Línea para activar la flecha hacia atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);


        //Inflo el recycler y configuramos el Adapter
        RecyclerView rvFirst = (RecyclerView) findViewById(R.id.rvFirst);

        rvFirst.setLayoutManager(new LinearLayoutManager(FirstActivity.this));
        rvFirst.setHasFixedSize(true);

        mRVFirstAdapter = new RVFirstAdapter();
        rvFirst.setAdapter(mRVFirstAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 999 && resultCode == RESULT_OK) {
            mRVFirstAdapter.add((Person) data.getParcelableExtra("person"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflamos el menú que va a aparecer en el Toolbar
        getMenuInflater().inflate(R.menu.first_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Capturamos el click de cada item del menu
        if (item.getItemId() == R.id.abFirstAdd) {
            startActivityForResult(new Intent(FirstActivity.this, SecondActivity.class), 999);
            return true;
        }

        //Linea de respuesta por defecto
        return super.onOptionsItemSelected(item);
    }
}
