package com.example.onlineexhibitionplatform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.onlineexhibitionplatform.databinding.ActivityCreateBinding;
import com.example.onlineexhibitionplatform.databinding.ActivityReadOneBinding;

public class ReadOneActivity extends AppCompatActivity {

    private ActivityReadOneBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 바인딩
        binding = ActivityReadOneBinding.inflate(getLayoutInflater()); // 1
        setContentView(binding.getRoot()); // 2
//        setContentView(R.layout.activity_read_one);
        setSupportActionBar(binding.toolbar);

//        //Toolbar의 왼쪽에 버튼을 추가하고 버튼의 아이콘을 바꾼다.
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24); // X 아이콘

        //해당 액티비티의 툴바에 있는 타이틀을 공백으로 처리
        getSupportActionBar().setTitle("");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24); // <- 아이콘

        Intent intent = getIntent();



        binding.textViewTitle.setText(intent.getStringExtra("contact_title"));
        binding.textViewAuthor.setText(intent.getStringExtra("contact_author"));
        binding.textViewContent.setText(intent.getStringExtra("contact_content"));
    }




    //추가된 소스, ToolBar에 menu.xml을 인플레이트함
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.update_delete_menu, menu);
        return true;
    }

    //추가된 소스, ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_update:
                Toast.makeText(getApplicationContext(), "수정하기", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_delete:
                Toast.makeText(getApplicationContext(), "삭제하기", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}