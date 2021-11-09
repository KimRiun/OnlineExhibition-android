package com.example.onlineexhibitionplatform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.onlineexhibitionplatform.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private PoemAdapter poemAdapter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 바인딩
        binding = ActivityMainBinding.inflate(getLayoutInflater()); // 1

        initAdapter();

        setContentView(binding.getRoot()); // 2
//        setContentView(R.layout.activity_main);

        //플로팅 버튼
        binding.fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), CreateActivity.class); //그룹 만들기 화면으로 연결
                startActivity(intent); //액티비티 열기
            }
        });

    }

    private void initAdapter() {
        // recycler view


        ArrayList<UserData> list = new ArrayList<>();
        list.add(new UserData("그저께","새벽"));
        list.add(new UserData("어제","아침"));
        list.add(new UserData("오늘","점심"));
        list.add(new UserData("내일","저녁"));
        list.add(new UserData("모레","밤"));

        poemAdapter = new PoemAdapter(list);

        binding.rvPoem.setAdapter(poemAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.rvPoem.getContext(),
                new LinearLayoutManager(this).getOrientation());
        binding.rvPoem.addItemDecoration(dividerItemDecoration);

        poemAdapter.notifyDataSetChanged();

    }

}