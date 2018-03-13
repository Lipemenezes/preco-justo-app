package com.example.aluno.app;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText editProduct;
    private EditText editValue;
    private EditText editQuantity;
    private EditText editInterest;
    private TextView viewProduct;
    private TextView viewInitialCost;
    private TextView viewInstallmentCost;
    private TextView viewTotalCost;
    private TextView viewTotalInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.init();
    }

    public void calculate(View view) {
        String productName = editProduct.getText().toString();
        Double productValue = Double.parseDouble(editValue.getText().toString());
        Integer quantity = Integer.parseInt(editQuantity.getText().toString());
        Double interest = Double.parseDouble(editInterest.getText().toString());

        Double installmentValue = productValue / quantity;
        Double installmentConsideringInterest = installmentValue * (1 + (interest / 100));
        Double totalValue = installmentConsideringInterest * quantity;
        Double totalConsideringInterest = totalValue - productValue;

        viewProduct.setText(productName);
        viewInitialCost.setText(productValue.toString());
        viewInstallmentCost.setText(installmentConsideringInterest.toString());
        viewTotalCost.setText(totalValue.toString());
        viewTotalInterest.setText(totalConsideringInterest.toString());
    }

    public void clear(View view) {
        editProduct.setText("");
        editValue.setText("");
        editQuantity.setText("");
        editInterest.setText("");
        viewProduct.setText("");
        viewInitialCost.setText("");
        viewInstallmentCost.setText("");
        viewTotalCost.setText("");
        viewTotalInterest.setText("");
    }

    private void init() {
        editProduct = findViewById(R.id.editProduct);
        editValue = findViewById(R.id.editValue);
        editQuantity = findViewById(R.id.editQuantity);
        editInterest = findViewById(R.id.editInterest);
        viewProduct = findViewById(R.id.viewProduct);
        viewInitialCost = findViewById(R.id.viewInitialCost);
        viewInstallmentCost = findViewById(R.id.viewInstallmentCost);
        viewTotalCost = findViewById(R.id.viewTotalCost);
        viewTotalInterest = findViewById(R.id.viewTotalInterest);
    }

}
