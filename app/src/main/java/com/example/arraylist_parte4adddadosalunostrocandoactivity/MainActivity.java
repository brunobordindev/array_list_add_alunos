package com.example.arraylist_parte4adddadosalunostrocandoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private TextInputEditText campName, campAddress, campEmail;
    private Button btnAdd;
    ArrayList<User> listAluno;
    ArrayAdapter<User> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        campName = findViewById(R.id.editName);
        campAddress = findViewById(R.id.editAddress);
        campEmail = findViewById(R.id.editEmail);
        btnAdd = findViewById(R.id.btnAdd);

        listAluno = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                listAluno
        );
        listView.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = campName.getText().toString();
                String address = campAddress.getText().toString();
                String email = campEmail.getText().toString();

                if (!name.isEmpty()){
                    if (!address.isEmpty()){
                        if (!email.isEmpty()){

                            User user = new User(name, address, email);
                            listAluno.add(user);
                            adapter.notifyDataSetChanged();

                            campName.setText("");
                            campAddress.setText("");
                            campEmail.setText("");


                        }else{
                            Toast.makeText(MainActivity.this,
                                    "Preencher o e-mail",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(MainActivity.this,
                                "Preencher o endereço",
                                Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this,
                            "Preencher o nome",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Toast.makeText(getApplicationContext(),
                        "Sucesso ao clicar " + listAluno.get(i).toString(),
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", listAluno.get(i).getName());
                intent.putExtra("address", listAluno.get(i).getAddress());
                intent.putExtra("email", listAluno.get(i).getEmail());
                startActivity(intent);
            }
        });

    }
}