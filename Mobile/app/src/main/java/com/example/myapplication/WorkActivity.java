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

public class WorkActivity extends AppCompatActivity {

    private RecyclerView workRecyclerView;
    private WorkAdapter workAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        workRecyclerView = findViewById(R.id.workRecyclerView);
        workRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Заполните список работ (можно использовать данные из базы данных)
        List<Work> works = new ArrayList<>();
        works.add(new Work(1, "Диагностика двигателя", "Проверка работы и состояния двигателя", 1200));
        works.add(new Work(2, "Замена ремня ГРМ", "Замена ремня газораспределительного механизма", 2000));
        works.add(new Work(3, "Ремонт подвески", "Замена амортизаторов, рычагов, сайлентблоков", 1800));
        works.add(new Work(4, "Замена генератора", "Замена генератора", 2100));
        works.add(new Work(5, "Сварка кузова", "Сварка элементов кузова и кузова", 4000));

        workAdapter = new WorkAdapter(works);
        workRecyclerView.setAdapter(workAdapter);
    }

    // Класс модели для работы
    private class Work {
        int id;
        String name;
        String description;
        int price;

        public Work(int id, String name, String description, int price) {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
        }
    }

    // Адаптер для RecyclerView для работ
    private static class WorkAdapter extends RecyclerView.Adapter<WorkAdapter.ViewHolder> {

        private List<Work> works;

        public WorkAdapter(List<Work> works) {
            this.works = works;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.work_item, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Work work = works.get(position);
            holder.idTextView.setText("ID: " + work.id);
            holder.nameTextView.setText("Название: " + work.name);
            holder.descriptionTextView.setText("Описание: " + work.description);
            holder.priceTextView.setText("Цена: " + work.price);
        }

        @Override
        public int getItemCount() {
            return works.size();
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