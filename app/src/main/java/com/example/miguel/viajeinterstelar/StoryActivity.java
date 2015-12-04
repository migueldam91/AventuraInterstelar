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
    private Button btnArriba, btnAbajo;
    private Drawable imagen;
    private Page pagina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        btnArriba = (Button) findViewById(R.id.btnInvestigate);
        btnAbajo = (Button) findViewById(R.id.btnContinue);
        nombreAventurero= getIntent().getStringExtra("Name");
        textView= (TextView) findViewById(R.id.tvAdventure);
        imageView=(ImageView)findViewById(R.id.imageView2);

        cargarPagina(0);
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

    public void cargarPagina(int paginaArray){
        pagina= story.getPage(paginaArray);

        imagen=getResources().getDrawable(pagina.getImageId());
        imageView.setImageDrawable(imagen);
        textView.setText(String.format(pagina.getText(), nombreAventurero));



        if(pagina.isFinal()) {
            btnArriba.setVisibility(View.INVISIBLE);
            btnAbajo.setText("Play again");
            btnAbajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }else {
            btnArriba.setText(pagina.getChoice1().getText());
            btnAbajo.setText(pagina.getChoice2().getText());

            btnArriba.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cargarPagina(pagina.getChoice1().getNextId());
                }
            });

            btnAbajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cargarPagina(pagina.getChoice2().getNextId());
                }
            });
        }



    }
}
