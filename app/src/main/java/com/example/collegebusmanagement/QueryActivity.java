package com.example.collegebusmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class QueryActivity extends AppCompatActivity {
    EditText editTextto,editTextsub,editTextmess;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_query);
        button = findViewById(R.id.sent);
        editTextsub = findViewById(R.id.subject);
        editTextto = findViewById(R.id.to_email);
        editTextmess = findViewById(R.id.content);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String subject, content, to_email;
               subject = editTextsub.getText().toString();
                content = editTextmess.getText().toString();
                to_email = editTextto.getText().toString();
                if(subject.equals("") && content.equals("") && to_email.equals("")){
                    Toast.makeText(QueryActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }
                else{
                    sendEmail(subject, content,to_email);
                }
            }
        });
    }
    public void sendEmail(String subject, String content, String to_email){
        Intent intent =new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to_email});
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,content);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "choose email client"));
    }
}