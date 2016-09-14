package com.jesusalvizo.partialexam1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText numero1;
    private EditText numero2;
    private TextView error;
    private TextView comparacion;
    private TextView suma;
    private TextView resta;
    private TextView producto;
    private Button calcBtn;
    private Button clrButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeApp();
    }

    private void initializeApp(){
        numero1 = (EditText) findViewById(R.id.txtBox1);
        numero2 = (EditText) findViewById(R.id.txtBox2);
        comparacion = (TextView) findViewById(R.id.compAns);
        suma = (TextView) findViewById(R.id.addAns);
        resta = (TextView) findViewById(R.id.susAns);
        producto = (TextView) findViewById(R.id.prodAns);
        error = (TextView) findViewById(R.id.msgError);
        calcBtn = (Button) findViewById(R.id.calcButton);
        clrButton = (Button) findViewById(R.id.clrButton);
        clrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            limpiar();
        }
    });
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });
    }

    public int evalua(String d){
        if (d == ""){
            return 0;
        }else{
            return Integer.parseInt(d);
        }
    }

    public void calcular(){
        int n1,n2,s,r,p,m;
        if (numero1.getText().toString()!="" && numero2.getText().toString() !=""){
            n1 = Integer.parseInt(numero1.getText().toString());
            n2 = Integer.parseInt(numero2.getText().toString());

            if (difZero(n2)) {
                bloquear();
                s = suma(n1, n2);
                r = resta(n1, n2);
                p = producto(n1, n2);
                m = mayor(n1, n2);
                mostrar(s, r, p, m);

            } else {
                //Aqui va el codigo para enviar el mensaje de error
                error.setText("ERROR");
            }

            clrButton.setEnabled(true);
            clrButton.setVisibility(View.VISIBLE);
        }
    }
    public int suma(int num1, int num2){
        return num1 + num2;
    }

    public int resta(int num1, int num2){
        return num1 - num2;
    }

    public int producto(int num1, int num2){
        return num1 * num2;
    }

    public int mayor(int num1, int num2){
        if (num1 > num2){
            return num1;
        }else{
            return num2;
        }
    }

    public void mostrar(int s,int r,int p,int m){
        comparacion.setText(Integer.toString(m));
        suma.setText(Integer.toString(s));
        resta.setText(Integer.toString(r));
        producto.setText(Integer.toString(p));

    }

    public void limpiar() {

        clrButton.setEnabled(false);
        clrButton.setVisibility(View.INVISIBLE);
        comparacion.setText("");
        suma.setText("");
        resta.setText("");
        producto.setText("");
        numero2.setText("");
        numero1.setText("");
        numero1.setEnabled(true);
        numero2.setEnabled(true);
        error.setText("");

    }

    public void bloquear(){
        //Aqui va el codigo para bloquear los campos
        numero1.setEnabled(false);
        numero2.setEnabled(false);
    }

    public boolean difZero(int num){
        if (num != 0){
            return true;
        }else{
            return false;
        }
    }
}