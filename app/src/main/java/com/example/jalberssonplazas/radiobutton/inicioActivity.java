package com.example.jalberssonplazas.radiobutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class inicioActivity extends AppCompatActivity
{

    TextView txtPrecio, txtDescuento, txtTotal;
    RadioGroup rgPrincipal;
    RadioButton rbTv, rbRadio;
    CheckBox chbDescuento;
    Button btnCalcular;
    double precio=0;
    double descuento=0;
    double total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        txtDescuento=(TextView) findViewById(R.id.txtDescuento);
        txtPrecio=(TextView) findViewById(R.id.txtPrecio);
        txtTotal=(TextView) findViewById(R.id.txtTotal);
        rgPrincipal=(RadioGroup) findViewById(R.id.rgPrincipal);
        rbRadio=(RadioButton) findViewById(R.id.rbRadio);
        rbTv=(RadioButton) findViewById(R.id.rbTv);
        chbDescuento=(CheckBox) findViewById(R.id.chbDescuento);
        btnCalcular=(Button) findViewById(R.id.btnCalcular);

        rgPrincipal.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.rbTv:
                        precio=100000;
                        descuento=0;
                        txtPrecio.setText(precio+"");
                        txtDescuento.setText("");
                        chbDescuento.setChecked(false);
                        break;

                    case R.id.rbRadio:
                        precio=120000;
                        descuento=0;
                        txtPrecio.setText(precio+"");
                        txtDescuento.setText("");
                        chbDescuento.setChecked(false);
                        break;
                }
            }
        });
        chbDescuento.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if(isChecked)
                {
                    descuento=precio*0.1;
                    txtDescuento.setText(descuento+"");
                }
                else
                {
                    txtDescuento.setText("");
                }
            }
        });
        btnCalcular.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(precio!=0)
                {
                    total=precio-descuento;
                    txtTotal.setText(total+"");
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Debe escoger primero un artículo",Toast.LENGTH_SHORT);
                }
            }
        });
    }
}
