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

public class VehiclesActivity extends AppCompatActivity {

    private RecyclerView vehiclesRecyclerView;
    private VehiclesAdapter vehiclesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);

        vehiclesRecyclerView = findViewById(R.id.vehiclesRecyclerView);
        vehiclesRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Заполните список транспортных средств (можно использовать данные из базы данных)
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(1, "Volvo", "S60", 2003));
        vehicles.add(new Vehicle(2, "Audi", "A4", 1997));
        vehicles.add(new Vehicle(3, "Man", "TGS 41.500", 2018));
        vehicles.add(new Vehicle(4, "LADA", "Priora", 2012));
        vehicles.add(new Vehicle(5, "BMW", "E39", 1998));

        vehiclesAdapter = new VehiclesAdapter(vehicles);
        vehiclesRecyclerView.setAdapter(vehiclesAdapter);
    }

    // Класс модели для транспортного средства
    private class Vehicle {
        int id;
        String make;
        String model;
        int year;

        public Vehicle(int id, String make, String model, int year) {
            this.id = id;
            this.make = make;
            this.model = model;
            this.year = year;
        }
    }

    // Адаптер для RecyclerView для транспортных средств
    private static class VehiclesAdapter extends RecyclerView.Adapter<VehiclesAdapter.ViewHolder> { // Обратите внимание на "static"

        private List<Vehicle> vehicles;

        public VehiclesAdapter(List<Vehicle> vehicles) {
            this.vehicles = vehicles;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.vehicle_item, parent, false); // Замените 'vehicle_item' на имя вашего макета для элемента списка
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Vehicle vehicle = vehicles.get(position);
            holder.idTextView.setText("ID: " + vehicle.id);
            holder.makeTextView.setText("Марка: " + vehicle.make);
            holder.modelTextView.setText("Модель: " + vehicle.model);
            holder.yearTextView.setText("Год: " + vehicle.year);
        }

        @Override
        public int getItemCount() {
            return vehicles.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder { // Обратите внимание на "static"
            TextView idTextView;
            TextView makeTextView;
            TextView modelTextView;
            TextView yearTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                idTextView = itemView.findViewById(R.id.idTextView);
                makeTextView = itemView.findViewById(R.id.makeTextView);
                modelTextView = itemView.findViewById(R.id.modelTextView);
                yearTextView = itemView.findViewById(R.id.yearTextView);
            }
        }
    }
}