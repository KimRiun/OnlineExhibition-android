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
/*
시 작성할 데이터 입력하기
툴바 기능
    1. 화면 닫기
    2. 저장하기
*/
public class CreateActivity extends AppCompatActivity {

    private ActivityCreateBinding binding;

    // editText에 내용이 작성됐는지 확인하는 변수
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

        // Toolbar 붙이기
        setSupportActionBar(binding.toolbar);

        //Toolbar의 왼쪽에 버튼을 추가하고 버튼의 아이콘을 바꾼다.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_24); // X 아이콘

        //해당 액티비티의 툴바에 있는 타이틀을 공백으로 처리
        getSupportActionBar().setTitle("");


        // 제목 editText에 내용 작성됐는지 확인
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

        // 글쓴이 editText에 내용 작성됐는지 확인
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

        // 내용 editText에 내용 작성됐는지 확인
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

        // 저장 버튼 클릭시 이벤트 발생
        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Toolbar Button Clicked!", Toast.LENGTH_SHORT).show();
                // 모든 editText에 내용이 작성됐을 경우
                if(title_boolean && author_boolean && content_boolean){
                    /* 저장하기 Logic*/
                    Toast.makeText(getApplicationContext(), "저장하였습니다.", Toast.LENGTH_SHORT).show();

                    // 버튼 클릭시 열리는 화면(ReadOneActivity.class)
                    Intent intent = new Intent(CreateActivity.this, ReadOneActivity.class);

                    // 다른 액티비티에 데이터 전달하기
                    // 데이터를 받는 쪽에서는 intent.getStringExtra("contact_title")처럼 변수명으로 데이터를 가져옴
                    intent.putExtra("contact_title", binding.titleEditText.getText().toString());
                    intent.putExtra("contact_author", binding.authorEditText.getText().toString());
                    intent.putExtra("contact_content", binding.contentEditText.getText().toString());

                    // ReadOneActivity.class 시작
                    startActivity(intent);

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

    }// onCreate() 끝

    // X 아이콘 클릭시
    @Override
    public boolean onSupportNavigateUp() {
        finish(); // close this activity as oppose to navigating up

        return false;
    }

}