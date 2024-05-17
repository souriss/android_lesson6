package ru.mirea.lednevadd.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ru.mirea.lednevadd.lesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private String group;
    private Integer number;
    private String film;
    private EditText editTextGroup;
    private EditText editTextNumber;
    private EditText editTextFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences = getSharedPreferences("mirea_settings", Context.MODE_PRIVATE);
        String group = preferences.getString("GROUP", "unknown");
        int number = preferences.getInt("NUMBER", 0);
        String film = preferences.getString("FILM", "unknown");

        editTextGroup = findViewById(R.id.editTextGroup);
        editTextGroup.setText(group);

        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber.setText(String.valueOf(number));

        editTextFilm = findViewById(R.id.editTextFilm);
        editTextFilm.setText(film);
    }

    public void onClicked(View view){
        group = binding.editTextGroup.getText().toString();
        number = Integer.parseInt(binding.editTextNumber.getText().toString());
        film = binding.editTextFilm.getText().toString();
        SharedPreferences sharedPref = getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
        SharedPreferences.Editor editor	= sharedPref.edit();
        editor.putString("GROUP", group);
        editor.putInt("NUMBER", number);
        editor.putString("FILM", film);
        editor.apply();

        editTextGroup.setText(group);
        editTextNumber.setText(String.valueOf(number));
        editTextFilm.setText(film);

        Toast.makeText(this, "Saved settings", Toast.LENGTH_SHORT).show();
    }
}