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

public class PartsActivity extends AppCompatActivity {

    private RecyclerView partsRecyclerView;
    private PartsAdapter partsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parts);

        partsRecyclerView = findViewById(R.id.partsRecyclerView);
        partsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Заполните список запчастей (можно использовать данные из базы данных)
        List<Part> parts = new ArrayList<>();
        parts.add(new Part(1, "Тормозные колодки", "Комплект тормозных колодок для передних колес", 1000));
        parts.add(new Part(2, "Масляный фильтр", "Фильтр для очистки моторного масла", 200));
        parts.add(new Part(3, "Воздушный фильтр", "Фильтр для очистки поступающего в двигатель воздуха", 300));
        parts.add(new Part(4, "Свеча зажигания", "устройство для воспламенения топливно-воздушной смеси в самых разнообразных тепловых двигателях", 800));
        parts.add(new Part(5, "Автомобильный аккумулятор", "аккумулятор", 5800));

        partsAdapter = new PartsAdapter(parts);
        partsRecyclerView.setAdapter(partsAdapter);
    }

    // Класс модели для запчасти
    private class Part {
        int id;
        String name;
        String description;
        int price;

        public Part(int id, String name, String description, int price) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
        }
    }

    // Адаптер для RecyclerView для запчастей
    private static class PartsAdapter extends RecyclerView.Adapter<PartsAdapter.ViewHolder> {

        private List<Part> parts;

        public PartsAdapter(List<Part> parts) {
            this.parts = parts;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.part_item, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Part part = parts.get(position);
            holder.idTextView.setText("ID: " + part.id);
            holder.nameTextView.setText("Название: " + part.name);
            holder.descriptionTextView.setText("Описание: " + part.description);
            holder.priceTextView.setText("Цена: " + part.price);
        }

        @Override
        public int getItemCount() {
            return parts.size();
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
