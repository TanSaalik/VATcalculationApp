package com.example.tan.vatcalculations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final double EstVAT = 0.2;

    EditText UnitPrice, NrOfUnits, ResultExclVAT, ResultVAT, ResultInclVAT;
    RadioButton Excl, Incl;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Excl = findViewById(R.id.radioButton1);
        Incl = findViewById(R.id.radioButton2);
        UnitPrice = findViewById(R.id.editText1);
        NrOfUnits = findViewById(R.id.editText2);
        ResultExclVAT = findViewById(R.id.editText3);
        ResultVAT = findViewById(R.id.editText4);
        ResultInclVAT = findViewById(R.id.editText5);

        ResultExclVAT.setKeyListener(null);
        ResultVAT.setKeyListener(null);
        ResultInclVAT.setKeyListener(null);
    }

    public static double VAT(double UnitPrice, double NrOfUnits){
        return UnitPrice * NrOfUnits * EstVAT;
    }

    public static double InclVAT(double UnitPrice, double NrOfUnits){
        return (UnitPrice * NrOfUnits * EstVAT) + (UnitPrice * NrOfUnits);
    }

    public static double ExclVAT(double UnitPrice, double NrOfUnits){
        return (UnitPrice * NrOfUnits);
    }

    public void onClick(View view){
        if(view.getId() == R.id.buttonCLR){
            UnitPrice.setText("");
            NrOfUnits.setText("");
            ResultExclVAT.setText("");
            ResultVAT.setText("");
            ResultInclVAT.setText("");
        }
        else if(view.getId() == R.id.buttonOK){
            if(UnitPrice.getText().length() == 0 || NrOfUnits.getText().length() == 0){
                Toast.makeText(this, "Please enter unit price and nr of units!", Toast.LENGTH_SHORT).show();
            }

            double UnitPriceX = Double.parseDouble(UnitPrice.getText().toString());
            double NrOfUnitsX = Double.parseDouble(NrOfUnits.getText().toString());

            if(Excl.isChecked()){
                ResultExclVAT.setText(String.valueOf(ExclVAT(UnitPriceX, NrOfUnitsX)));
                ResultVAT.setText(String.valueOf(VAT(UnitPriceX, NrOfUnitsX)));
            }
            
            else {
                ResultInclVAT.setText(String.valueOf(InclVAT(UnitPriceX, NrOfUnitsX)));
                ResultVAT.setText(String.valueOf(VAT(UnitPriceX, NrOfUnitsX)));
            }
        }
    }
}
