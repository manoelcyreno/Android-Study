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
        getNextEventIPBAL();
        getNextEventUPH();
        getNextEventUMP();
        getNextEventSAF();
    }

    private void getNextEventIPBAL()
    {
        List<String> eventDates = Arrays.asList("01.01", "01.08", "01.07", "01.21", "02.04", "02.11", "03.05", "03.10",
                "03.11", "03.27", "04.02", "04.04", "05.13", "05.20", "06.08", "06.12", "07.01", "07.09", "07.22",
                "07.31", "08.05", "08.12", "09.08", "09.16", "10.01", "10.11", "10.12", "10.31", "11.01", "11.05",
                "11.11", "11.15", "11.22", "11.30", "12.08", "12.09", "12.17", "12.25");
        List<String> eventTopics = Arrays.asList("Dia Mundial da Paz e Inicio da Semana Universal de Oração",
                "Fim da Semana Universal de Oração", "Dia da liberdade de cultos", "Dia Mundial da Religião",
                "Dia do Homem Presbiteriano", "Dia da Mulher Presbiteriana", "Dia Mundial da Oração",
                "Primeiro culto protestante no Brasil", "Dia da educação cristã", "Dia da Casa Editora Presbiteriana",
                "Paixão de Cristo", "Páscoa", "Dia das Mães", "Dia Nacional do Jovem Presbiteriano",
                "Aniversário do Jornal Brasil Presbiteriano", "Instalada a Sociedade Bíblica no Brasil",
                "Inicio do Mês dos pastores jubilados e viúvas de pastores", "Dia do Diácono",
                "Dia Nacional do Adolescente Presbiteriano", "Fim do Mês dos pastores jubilados e viúvas de pastores",
                "Dia do Presbítero", "Dia do Presbiterianismo Nacional, Dia das Missões e Dia dos pais",
                "Dia dos seminários e seminaristas", "Dia da Escola Dominical", "Dia Nacional e internacional do Idoso",
                "Dia da SAF em Revista", "Dia das crianças e dia nacional da criança presbiteriana",
                "Dia da Reforma Protestante", "Dia do Evangélico",
                "Circula pela primeira vez o Imprensa Evangélica, primeiro jornal religioso do País",
                "Dia Nacional da SAF", "Dia da proclamação da República", "Dia Nacional de Ações de Graças",
                "Dia do Teólogo", "Dia Nacional da Família", "Dia da Bíblia e da Mulher de Pastor", "Dia do Pastor",
                "Natal");

        Date currentDate = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("MM.dd");
        double currentDateFormated = Double.parseDouble(formatDate.format(currentDate));

        for (int i = 0; i < eventDates.size(); i++) {
            if (currentDateFormated <= Double.parseDouble(eventDates.get(i).toString())) {
                String preFormatedDate = eventDates.get(i).toString();
                String monthEvent = preFormatedDate.substring(0, 2);
                String dayEvent = preFormatedDate.substring(3, 5);
                sendNotification(dayEvent, monthEvent, eventTopics.get(i).toString(), 10001, "Datas Comemorativas IPB");
                break;
            }
        }
    }

    private void getNextEventUPH()
    {
        List<String> eventDates = Arrays.asList("01.02", "02.18", "03.11", "03.18", "03.23", "04.15", "05.20", "05.21",
                "05.25", "06.30", "07.15", "08.25", "10.19");
        List<String> eventTopics = Arrays.asList("Semana Universal de Oração com a direção da UPH",
                "Comemorar o dia da mulher presbiteriana", "Comemorar o dia internacional da mulher",
                "Comemorar o aniversário da igreja e do grupo mensageiros de Cristo",
                "Reunião Plenária da UPH, às 19:30", "Comemorar o aniversário do pastor", "Comemorar o dia da mocidade",
                "Inicio da semana de oração pela família", "Fim da semana de oração pela família",
                "Reunião Plenária da UPH, às 19", "Comemorar dia do diácono",
                "Intercâmbio com a UPH da 1ª. IPB de Paulista",
                "Reunião extraordinária da UPH, para eleição da nova diretoria");

        Date currentDate = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("MM.dd");
        double currentDateFormated = Double.parseDouble(formatDate.format(currentDate));

        for (int i = 0; i < eventDates.size(); i++) {
            if (currentDateFormated <= Double.parseDouble(eventDates.get(i).toString())) {
                String preFormatedDate = eventDates.get(i).toString();
                String monthEvent = preFormatedDate.substring(0, 2);
                String dayEvent = preFormatedDate.substring(3, 5);
                sendNotification(dayEvent, monthEvent, eventTopics.get(i).toString(), "UPH", 10002);
                break;
            }
        }
    }

    private void getNextEventUMP()
    {
        List<String> eventDates = Arrays.asList("01.20", "02.17", "03.10", "04.01", "04.14", "05.05", "05.13", "06.09",
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
                sendNotification(dayEvent, monthEvent, eventTopics.get(i).toString(), "UMP", 10003);
                break;
            }
        }
    }

    private void getNextEventSAF()
    {
        List<String> eventDates = Arrays.asList("01.03", "01.13", "01.30", "02.03", "02.04", "02.05", "02.11", "03.02",
                "03.05", "03.08", "03.24", "04.02", "04.14", "04.24", "04.28", "05.05", "05.07", "05.19", "06.02",
                "06.04", "06.16", "06.26", "07.02", "07.07", "07.21", "07.31", "08.05", "08.06", "08.28", "09.03",
                "09.25", "10.01", "10.30", "11.05", "11.10", "11.27");
        List<String> eventTopics = Arrays.asList("Inicio da Semana Universal de Oração",
                "Fim da Semana Universal de Oração", "Reunião departamental", "Culto de Jejum e Oração",
                "Dia do Homem Presbiteriano", "Ensaio conjunto SAF", "Dia da mulher Presbiteriana",
                "Dia de Oração das SAFs", "Ensaio conjunto SAF", "Dia da mulher", "Vista da SAF", "Ensaio conjunto SAF",
                "Aniversario do pastor", "Reunião Plenária", "Atividade da Sinodal cuidando da boa idade",
                "Aniversário da SAF", "Ensaio conjunto SAF",
                "Atividade Federação. Manhã de oração. Igreja de Jardim Paulista",
                "Atividade da Sinodal. Inspirativa ( tarde cultural Colégio Agnes )", "Ensaio conjunto SAF",
                "Evangelismo parque das Paineiras", "Reunião Plenária", "Ensaio conjunto SAF", "Gincana", "Gincana",
                "Reunião Plenária", "Dia so Presbítero. (Jogral)", "Ensaio conjunto SAF", "Reunião Plenária",
                "Ensaio conjunto SAF", "Reunião Plenária", "Ensaio conjunto SAF",
                "Reunião Plenária e Eleição da nova diretória", "Ensaio conjunto SAF", "Congresso da Federação",
                "Reunião Plenária");

        Date currentDate = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("MM.dd");
        double currentDateFormated = Double.parseDouble(formatDate.format(currentDate));

        for (int i = 0; i < eventDates.size(); i++) {
            if (currentDateFormated <= Double.parseDouble(eventDates.get(i).toString())) {
                String preFormatedDate = eventDates.get(i).toString();
                String monthEvent = preFormatedDate.substring(0, 2);
                String dayEvent = preFormatedDate.substring(3, 5);
                sendNotification(dayEvent, monthEvent, eventTopics.get(i).toString(), "SAF", 10004);
                break;
            }
        }
    }

    private void sendNotification(String dayEvent, String monthEvent, String eventName, String society, int ID)
    {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        Intent intent = new Intent(this, ExecuteNotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.drawable.ic_event);
        mBuilder.setContentTitle("Próxima Programação");
        mBuilder.setContentText(dayEvent + "/" + monthEvent + " - " + society + " - " + eventName);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(ID, mBuilder.build());
    }

    private void sendNotification(String dayEvent, String monthEvent, String eventName, int ID, String eventTitle)
    {
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);

        Intent intent = new Intent(this, ExecuteNotificationActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

        mBuilder.setContentIntent(pendingIntent);
        mBuilder.setSmallIcon(R.drawable.ic_event);
        mBuilder.setContentTitle(eventTitle);
        mBuilder.setContentText(dayEvent + "/" + monthEvent + " - " + eventName);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(ID, mBuilder.build());
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

            case R.id.pageipalanual:
                fragment = new PageIpalAnual();
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