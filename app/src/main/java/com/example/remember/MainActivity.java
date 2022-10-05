package com.example.remember;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnXacnhan;
    EditText edtUsername,edtPassword;
    CheckBox cbRemember;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();

        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);

        edtUsername.setText(sharedPreferences.getString("tk", ""));
        edtPassword.setText(sharedPreferences.getString("mk", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));
        btnXacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username= edtUsername.getText().toString();
                String password= edtPassword.getText().toString();

                if (username.equals("sylinh") && password.equals("123")){
                    Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();

                    if (cbRemember.isChecked()){
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("tk",username);
                        editor.putString("mk",password);
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }else{
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.remove("tk");
                        editor.remove("mk");
                        editor.remove("checked");
                        editor.commit();
                    }
                }
            }
        });
    }

    private void AnhXa(){
        btnXacnhan= (Button) findViewById(R.id.buttonXacnhan);
        edtUsername= (EditText) findViewById(R.id.edittextUsername);
        edtPassword=(EditText) findViewById(R.id.edittextPassword);
        cbRemember= (CheckBox) findViewById(R.id.checkboxRemember);
    }
}