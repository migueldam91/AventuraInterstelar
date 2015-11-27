package com.example.miguel.viajeinterstelar;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class StoryActivity extends ActionBarActivity {
    private String nombreAventurero;
    private TextView textView;
    private ImageView imageView;
    private Story story = new Story();
    private Button btnContinue, btnInvestigate;
    private Drawable imagen;
    private Choice choice;
    private Page pagina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);


        nombreAventurero= getIntent().getStringExtra("Name");
        textView= (TextView) findViewById(R.id.tvAdventure);
        imageView=(ImageView)findViewById(R.id.imageView2);


        btnContinue = (Button) findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice=pagina.getChoice1();

                cargarPagina(choice.getNextId());

            }
        });

        btnInvestigate = (Button) findViewById(R.id.btnInvestigate);
        btnInvestigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choice=pagina.getChoice2();

                cargarPagina(choice.getNextId());
            }
        });
        pagina=cargarPagina(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_story, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public Page cargarPagina(int paginaArray){
        Page paginaActual= story.getPage(paginaArray);

        imagen=getResources().getDrawable(paginaActual.getImageId());
        imageView.setImageDrawable(imagen);

        if(paginaArray== 0 || paginaArray==4 || paginaArray==5)
            textView.setText(String.format(paginaActual.getText(), nombreAventurero));
        else
            textView.setText(paginaActual.getText());

        btnInvestigate.setText(paginaActual.getChoice1().getText());
        btnContinue.setText(paginaActual.getChoice2().getText());
        Log.v("Opcion Elegida A", paginaActual.getChoice1().getText());
        return paginaActual;


    }
}
