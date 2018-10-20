package sample.android.com.navigationdrawerexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    // long fastTime, lastTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // addFragment(new FragmentOne());

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();




        // getSupportFragmentManager().beginTransaction()
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place, new FragmentOne()).commit();
            navigationView.setCheckedItem(R.id.frag1);
        }
    }
 /*   private void addFragment(FragmentOne fragmentOne) {
    }*/

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
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.aboutUs) {

                Toast.makeText(this, "You clicked about us", Toast.LENGTH_SHORT).show();
                return true;
            }
            if (id == R.id.setting) {

                Toast.makeText(this, "You clicked Setting", Toast.LENGTH_SHORT).show();
                return true;
            }
            if (id == R.id.exitId) {

                Toast.makeText(this, "You clicked Exit", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            }

            return super.onOptionsItemSelected(item);
        }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected (MenuItem item){
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.nav_sign_in) {
                // Handle the camera action
                // Toast.makeText(this, "You Click Sign in", Toast.LENGTH_SHORT).show();
                // addFragment(new FragmentOne());
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place, new FragmentOne()).commit();
            } else if (id == R.id.nav_sign_up) {

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place, new FragmentTwo()).commit();


               // Toast.makeText(this, "You clicked Sign Up", Toast.LENGTH_SHORT).show();

            } else if (id == R.id.nav_profile) {

              //  Toast.makeText(this, "You clicked Profile", Toast.LENGTH_SHORT).show();
               getSupportFragmentManager().beginTransaction().replace(R.id.fragment_place, new FragmentThree()).commit();


            }

           DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
//fragment :

   /* public void selectFragment(View view) {

        switch (view.getId()) {

            case R.id.frag1:
                // --- select button one
                //Toast.makeText(this, "Button One", Toast.LENGTH_SHORT).show();
                addFragment(new FragmentOne());

                break;

            case R.id.frag2:
                // --- select button two
                // Toast.makeText(this, "Button 2", Toast.LENGTH_SHORT).show();
                addFragment(new FragmentTwo());
                break;

            case R.id.frag3:
                // --- select button three
                // Toast.makeText(this, "Button 3", Toast.LENGTH_SHORT).show();
                addFragment(new FragmentThree());
                break;

        }

    }


    public void addFragment(Fragment fragment) {

        FragmentManager manager = getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();


        transaction.replace(R.id.fragment_place, fragment);
        transaction.commit();
        }

*/
    }





