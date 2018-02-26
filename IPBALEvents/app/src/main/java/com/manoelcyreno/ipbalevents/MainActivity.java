package com.manoelcyreno.ipbalevents;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by manoelcyreno on 23/02/2018.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private TextView churchName;
    private TextView churchSite;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNavigationDrawer();
        initNavigationDrawerHeader();
        initDrawerListener(savedInstanceState);
    }

    private void initNavigationDrawer()
    {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        if (navigationView != null)
        {
            navigationView.setNavigationItemSelectedListener(this);
        }
    }

    private void initNavigationDrawerHeader()
    {
        View header = navigationView.getHeaderView(0);
        churchName = (TextView) header.findViewById(R.id.churchname);
        churchSite = (TextView) header.findViewById(R.id.churchsite);

        setupUserInformations();
    }

    private void setupUserInformations()
    {
        churchName.setText(R.string.church);
        churchSite.setText(R.string.church_site);
    }

    private void initDrawerListener(Bundle savedInstanceState)
    {
        if (savedInstanceState == null)
        {
            MenuItem item = navigationView.getMenu().getItem(0);
            onNavigationItemSelected(item);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        if (isNavigationDrawerOpen())
        {
            closeNavigationDrawer();
        }
        else
        {
            super.onBackPressed();
        }
    }

    protected boolean isNavigationDrawerOpen()
    {
        return drawerLayout != null && drawerLayout.isDrawerOpen(GravityCompat.START);
    }

    protected void closeNavigationDrawer()
    {
        if (drawerLayout != null)
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        item.setChecked(true);
        drawerLayout.closeDrawers();
        selectDrawerItem(item);

        return true;
    }

    public void selectDrawerItem(MenuItem menuItem)
    {
        Fragment fragment = null;

        switch (menuItem.getItemId())
        {
            case R.id.pagehome:
                fragment = new PageHome();
                break;

            case R.id.pageipalsemanal:
                fragment = new PageIpalSemanal();
                break;

            case R.id.pageump:
                fragment = new PageUMP();
                break;

            case R.id.pageuph:
                fragment = new PageUPH();
                break;

            case R.id.pagesaf:
                fragment = new PageSAF();
                break;

            case R.id.pagesobre:
                fragment = new PageSobre();
                break;

            default:
                break;
        }

        if(fragment != null)
        {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.drawer_content, fragment).commit();

            setTitle(menuItem.getTitle());
        }
    }
}