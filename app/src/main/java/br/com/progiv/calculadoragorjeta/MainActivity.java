package br.com.progiv.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    //objetos formatadores de moeda:
    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();


    private double vrConta = 0.0; // valor da conta inserido pelo usuario
    private double percent = 0.015; // porcentagem inicial da gorjeta
    private TextView valorContaTextView; // mostra o valor da conta
    private TextView valorTotalTextView; // mostra o valor da conta calculada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //obter referencias para o TextView manipulados via programação
        valorContaTextView = (TextView)findViewById(R.id.valorConta);
        valorTotalTextView = (TextView)findViewById(R.id.valorTotal);
        valorTotalTextView.setText(currencyFormat.format(0));


        //configura o receptor TextWatcher de valorContaEditText
        EditText valorContaEditText = (EditText)findViewById(R.id.valorConta):
        valorContaEditText.addTextChangedListener(valorContaEditWatcher);
    }
    private final TextWatcher valorContaEditWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
           try{
               vrConta = Double.parseDouble(s.toString());
               valorTotalTextView.setText(currencyFormat.format(vrConta));
           }catch (Exception ex){
               String y = ex.getMessage();
           }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}