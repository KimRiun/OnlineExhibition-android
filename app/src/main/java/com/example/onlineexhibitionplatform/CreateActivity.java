package com.example.onlineexhibitionplatform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineexhibitionplatform.databinding.ActivityCreateBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CreateActivity extends AppCompatActivity {

    private ActivityCreateBinding binding;


    Boolean title_boolean = false;
    Boolean author_boolean = false;
    Boolean content_boolean = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 바인딩
        binding = ActivityCreateBinding.inflate(getLayoutInflater()); // 1
        setContentView(binding.getRoot()); // 2
//        setContentView(R.layout.activity_create);
        setSupportActionBar(binding.toolbar);

        //Toolbar의 왼쪽에 버튼을 추가하고 버튼의 아이콘을 바꾼다.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24); // X 아이콘

        //해당 액티비티의 툴바에 있는 타이틀을 공백으로 처리
        getSupportActionBar().setTitle("");


        binding.titleEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    title_boolean = true;
                } else {
                    title_boolean = false;
                }
            }
        });

        binding.authorEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    author_boolean = true;
                } else {
                    author_boolean = false;
                }
            }
        });

        binding.contentEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    content_boolean = true;
                } else {
                    content_boolean = false;
                }
            }
        });

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Toolbar Button Clicked!", Toast.LENGTH_SHORT).show();
                if(title_boolean && author_boolean && content_boolean){
                    /* 저장하기 Logic*/
                    Toast.makeText(getApplicationContext(), "저장하였습니다.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(CreateActivity.this, ReadOneActivity.class);

                    intent.putExtra("contact_title", binding.titleEditText.getText().toString());
                    intent.putExtra("contact_author", binding.authorEditText.getText().toString());
                    intent.putExtra("contact_content", binding.contentEditText.getText().toString());

                    startActivity(intent); // ReadOneActivity 시작

                    // CreateAcitivity 종료
                    // ReadOneActivity에서 백스탭하면 MainActivity로 이동
                    finish();

                }
                else{
                    if (!title_boolean) {
                        Toast.makeText(getApplicationContext(), "제목을 작성하여주세요.", Toast.LENGTH_SHORT).show();
                    }
                    else if (!author_boolean) {
                        Toast.makeText(getApplicationContext(), "글쓴이를 작성하여주세요.", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "내용을 작성하여주세요.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }

    // X 아이콘 클릭시
    @Override
    public boolean onSupportNavigateUp() {
        finish(); // close this activity as oppose to navigating up

        return false;
    }



//
//    //추가된 소스, ToolBar에 menu.xml을 인플레이트함
//    public boolean onCreateOptionsMenu(Menu menu) {
//        //return super.onCreateOptionsMenu(menu);
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.save_menu, menu);
//        return true;
//    }
//
//    //추가된 소스, ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId()) {
//            case R.id.action_update:
//
//                Toast.makeText(getApplicationContext(), "수정하기", Toast.LENGTH_LONG).show();
//                // return true
//            case R.id.action_delete:
//
//                Toast.makeText(getApplicationContext(), "삭제하기", Toast.LENGTH_LONG).show();
//
//
//        }
//
//        return super.onOptionsItemSelected(item);
//    }



}