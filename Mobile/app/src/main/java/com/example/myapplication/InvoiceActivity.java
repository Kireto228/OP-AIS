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

public class InvoiceActivity extends AppCompatActivity {

    private RecyclerView invoiceRecyclerView;
    private InvoiceAdapter invoiceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        invoiceRecyclerView = findViewById(R.id.invoiceRecyclerView);
        invoiceRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Заполните список счетов-фактур (можно использовать данные из базы данных)
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(1, "2023-03-08", 3500));
        invoices.add(new Invoice(2, "2023-03-10", 4000));
        invoices.add(new Invoice(3, "2023-03-12", 5500));
        invoices.add(new Invoice(4, "2023-03-14", 700));
        invoices.add(new Invoice(5, "2023-03-16", 9500));

        invoiceAdapter = new InvoiceAdapter(invoices);
        invoiceRecyclerView.setAdapter(invoiceAdapter);
    }

    // Класс модели для счета-фактуры
    private class Invoice {
        int id;

        String date;
        int total;

        public Invoice(int id, String date, int total) {
            this.id = id;
            this.date = date;
            this.total = total;
        }
    }

    // Адаптер для RecyclerView для счетов-фактур
    private static class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.ViewHolder> {

        private List<Invoice> invoices;

        public InvoiceAdapter(List<Invoice> invoices) {
            this.invoices = invoices;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.invoice_item, parent, false);
            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Invoice invoice = invoices.get(position);
            holder.idTextView.setText("ID: " + invoice.id);
            holder.dateTextView.setText("Дата: " + invoice.date);
            holder.totalTextView.setText("Сумма: " + invoice.total);
        }

        @Override
        public int getItemCount() {
            return invoices.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView idTextView;
            TextView numberTextView;
            TextView dateTextView;
            TextView totalTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                idTextView = itemView.findViewById(R.id.idTextView);
                dateTextView = itemView.findViewById(R.id.dateTextView);
                totalTextView = itemView.findViewById(R.id.totalTextView);
            }
        }
    }
}