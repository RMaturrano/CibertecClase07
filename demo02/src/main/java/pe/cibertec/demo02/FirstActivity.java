package pe.cibertec.demo02;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    private DrawerLayout dlMenu;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private TextView tvMenuFirst, tvMenuSecond, tvMenuMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dlMenu = (DrawerLayout) findViewById(R.id.dlMenu);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(FirstActivity.this, dlMenu, R.string.app_name, R.string.app_name);

        dlMenu.addDrawerListener(mActionBarDrawerToggle);

        tvMenuFirst = (TextView) findViewById(R.id.tvMenuFirst);
        tvMenuSecond = (TextView) findViewById(R.id.tvMenuSecond);
        tvMenuMain = (TextView) findViewById(R.id.tvMenuMain);

        tvMenuFirst.setOnClickListener(tvMenuOnClickListener);
        tvMenuSecond.setOnClickListener(tvMenuOnClickListener);
        tvMenuMain.setOnClickListener(tvMenuOnClickListener);
    }

    View.OnClickListener tvMenuOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.tvMenuSecond)
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            else if (v.getId() == R.id.tvMenuMain)
                startActivity(new Intent(FirstActivity.this, MainActivity.class));
            else
                dlMenu.closeDrawer(GravityCompat.START);
        }
    };

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mActionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mActionBarDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}
