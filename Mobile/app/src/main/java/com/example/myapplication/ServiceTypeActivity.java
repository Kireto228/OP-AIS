package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ServiceTypeActivity extends AppCompatActivity {

    private RecyclerView serviceTypeRecyclerView;
    private ServiceTypeAdapter serviceTypeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_type);

        serviceTypeRecyclerView = findViewById(R.id.serviceTypeRecyclerView);
        serviceTypeRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Заполните список типов услуг (можно использовать данные из базы данных)
        List<ServiceType> serviceTypes = new ArrayList<>();
        serviceTypes.add(new ServiceType(1, "Диагностика", "Проверка технического состояния автомобиля", 1000));
        serviceTypes.add(new ServiceType(2, "Замена масла", "Замена моторного масла и масляного фильтра", 500));
        serviceTypes.add(new ServiceType(3, "Шиномонтаж", "Снятие и установка колес, балансировка", 700));
        serviceTypes.add(new ServiceType(4, "Мойка", "Очистка машины внешняя и внутреняя", 800));
        serviceTypes.add(new ServiceType(5, "Покраска", "Снятие, покраска и полировка кузова", 7600));

        serviceTypeAdapter = new ServiceTypeAdapter(serviceTypes);
        serviceTypeRecyclerView.setAdapter(serviceTypeAdapter);
    }

    // Класс модели для типа услуги
    private class ServiceType {
        int id;
        String name;
        String description;
        int price;

        public ServiceType(int id, String name, String description, int price) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
        }
    }

    // Адаптер для RecyclerView для типов услуг
    private static class ServiceTypeAdapter extends RecyclerView.Adapter<ServiceTypeAdapter.ViewHolder> {

        private List<ServiceType> serviceTypes;

        public ServiceTypeAdapter(List<ServiceType> serviceTypes) {
            this.serviceTypes = serviceTypes;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.service_type_item, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            ServiceType serviceType = serviceTypes.get(position);
            holder.idTextView.setText("ID: " + serviceType.id);
            holder.nameTextView.setText("Название: " + serviceType.name);
            holder.descriptionTextView.setText("Описание: " + serviceType.description);
            holder.priceTextView.setText("Цена: " + serviceType.price);
        }

        @Override
        public int getItemCount() {
            return serviceTypes.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView idTextView;
            TextView nameTextView;
            TextView descriptionTextView;
            TextView priceTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                idTextView = itemView.findViewById(R.id.idTextView);
                nameTextView = itemView.findViewById(R.id.nameTextView);
                descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
                priceTextView = itemView.findViewById(R.id.priceTextView);
            }
        }
    }
}