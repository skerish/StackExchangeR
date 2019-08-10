package com.example.androidcore_paging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // Synchronously send the request and returns its response.
//        Call<StackApiResponse> call = RetrofitClient.getInstance().getAPI()
//                .getAnswers(1,50,  "stackoverflow");
//
//        call.enqueue(new Callback<StackApiResponse>() {
//            @Override
//            public void onResponse(Call<StackApiResponse> call, Response<StackApiResponse> response) {
//                StackApiResponse stackApiResponse = response.body();
//                Toast.makeText(MainActivity.this, String.valueOf(stackApiResponse.myItems.size()),
//                        Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<StackApiResponse> call, Throwable t) {
//            }
//        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ItemViewModel itemViewModel = ViewModelProviders.of(this).get(ItemViewModel.class);

        final ItemAdapter adapter = new ItemAdapter(this);

        itemViewModel.itemPagedList.observe(this, new Observer<PagedList<Items>>() {
            @Override
            public void onChanged(PagedList<Items> items) {
                adapter.submitList(items);
            }
        });

        recyclerView.setAdapter(adapter);
    }
}
