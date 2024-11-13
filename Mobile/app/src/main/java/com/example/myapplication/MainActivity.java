package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Замените 'activity_main' на имя вашего макета

        // Находим кнопки в макете
        Button vehiclesButton = findViewById(R.id.vehiclesButton);
        Button serviceTypeButton = findViewById(R.id.serviceTypeButton);
        Button partsButton = findViewById(R.id.partsButton);
        Button workButton = findViewById(R.id.workButton);
        Button invoiceButton = findViewById(R.id.invoiceButton);

        // Устанавливаем обработчики кликов для кнопок
        vehiclesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем намерение для перехода на активити "Транспорт"
                Intent intent = new Intent(MainActivity.this, VehiclesActivity.class);
                startActivity(intent);
            }
        });

        serviceTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем намерение для перехода на активити "Тип услуги"
                Intent intent = new Intent(MainActivity.this, ServiceTypeActivity.class);
                startActivity(intent);
            }
        });

        partsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем намерение для перехода на активити "Запчасти"
                Intent intent = new Intent(MainActivity.this, PartsActivity.class);
                startActivity(intent);
            }
        });

        workButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем намерение для перехода на активити "Работа"
                Intent intent = new Intent(MainActivity.this, WorkActivity.class);
                startActivity(intent);
            }
        });

        invoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем намерение для перехода на активити "Счет-фактура"
                Intent intent = new Intent(MainActivity.this, InvoiceActivity.class);
                startActivity(intent);
            }
        });
    }
}



