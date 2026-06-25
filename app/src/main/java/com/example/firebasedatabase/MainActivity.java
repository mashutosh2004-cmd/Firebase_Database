package com.example.firebasedatabase;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    ProgressBar p1;
    Button b1;
    FirebaseAuth fa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editTextText);
        e2=findViewById(R.id.editTextText2);
        p1=findViewById(R.id.progressBar);
        b1=findViewById(R.id.button);
        fa=FirebaseAuth.getInstance();
        e2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString().trim();
                String s2=e1.getText().toString();
                if(s1.isEmpty())
                {
                    e1.setError("enter your email");
                    return;

                }
                else
                {
                    if(s2.isEmpty())
                    {
                        e2.setError("enter your password");
                        return;
                    }
                    else
                    {
                        p1.setVisibility(View.VISIBLE);
                        p1.setVisibility(View.VISIBLE);
                        fa.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    p1.setVisibility(View.INVISIBLE);
                                    Toast.makeText(MainActivity.this, "updated", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    p1.setVisibility(View.INVISIBLE);
                                    Toast.makeText(MainActivity.this, "not updated", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                }
            }
        });

    }
}