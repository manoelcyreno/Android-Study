package com.manoelcyreno.ipbalevents;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.content.Context;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by manoelcyreno on 23/02/2018.
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private TextView churchAcronym;
    private TextView churchName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNavigationDrawer();
        initNavigationDrawerHeader();
        initDrawerListener(savedInstanceState);
        getNextEvent();
    }

    private void getNextEvent()
    {
        List<String> eventDates = Arrays.asList("01.20", "02.17", "03.10", "04.01", "04.14", "05.12", "05.13", "06.09",
                "07.14", "07.28", "08.11", "08.12", "09.22", "10.14", "10.27", "11.10", "11.24", "12.08");
        List<String> eventTopics = Arrays.asList("Palestra: “Memorizando os Salmos” (em CAETÉS 1)",
                "Evangelismo no Sinal + Cinemada", "Acústico UMP + Sorvetada", "Peça da Páscoa", "Estudo Direcionado",
                "Dia de Lazer", "Homenagem às Mães", "Jantar dos Namorados", "Sopão", "Confraternização do Semestre",
                "Roda Viva", "Homenagem aos Pais", "Culto de Gratidão da UMP", "EBD das Crianças",
                "Visita a Instituição de Crianças", "Eleição UMP", "Palestra: Tema a Definir",
                "Confraternização do Semestre");

        Date currentDate = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("MM.dd");
        double currentDateFormated = Double.parseDouble(formatDate.format(currentDate));

        for (int i = 0; i < eventDates.size(); i++) {
            if (currentDateFormated <= Double.parseDouble(eventDates.get(i).toString())) {
                String preFormatedDate = eventDates.get(i).toString();
                String monthEvent = preFormatedDate.substring(0, 2);
                String dayEvent = preFormatedDate.substring(3, 5);
                sendNotification(dayEvent, monthEvent, eventTopics.get(i).toString());
                break;
            }
        }

    }

    private void sendNotification(String dayEvent, String monthEvent, String eventName)
    {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        Intent intent = new Intent(this, ExecuteNotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.drawable.ic_event);
        mBuilder.setContentTitle("Próxima Programação da IPBAL");
        mBuilder.setContentText(dayEvent + "/" + monthEvent + " - " + eventName);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(10001, mBuilder.build());
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
        churchAcronym = (TextView) header.findViewById(R.id.churchname);
        churchName = (TextView) header.findViewById(R.id.churchsite);

        setupUserInformations();
    }

    private void setupUserInformations()
    {
        churchAcronym.setText(R.string.church);
        churchName.setText(R.string.church_site);
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