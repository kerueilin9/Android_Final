package com.example.data_pt1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    WordDatabase wordDatabase;
    WordDao wordDao;
    Button buttonA, buttonU, buttonD, buttonC;
    TextView textView;
    LiveData<List<Word>> allWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wordDatabase = Room.databaseBuilder(this, WordDatabase.class, "Word_database")
                .build();
        wordDao = wordDatabase.getWordDao();

        allWord = wordDao.getAllW_live();
        textView = findViewById(R.id.textView);
        buttonA = findViewById(R.id.button);
        buttonD = findViewById(R.id.button2);
        buttonC = findViewById(R.id.button3);
        buttonU = findViewById(R.id.button4);

        allWord.observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuilder text = new StringBuilder();
                for (int i = 0; i<words.size(); i++){
                    Word word = words.get(i);
                    text.append(word.getId()).append(":").append(word.getWord()).append("=").append(word.getMean()).append("\n");

                }
                textView.setText(text.toString());
            }
        });

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word1 = new Word("hello", "你好");
                Word word2 = new Word("hello", "你好");

                new insert(wordDao).execute(word1, word2);

            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("I", "我");
                word.setId(73);
                new delete(wordDao).execute(word);

            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new deleteAll(wordDao).execute();

            }
        });

        buttonU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("I", "我");
                word.setId(74);
                new update(wordDao).execute(word);

            }
        });

    }
    static class insert extends AsyncTask<Word, Void, Void>{
        private WordDao wordDao;

        public insert(WordDao wordDao){
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertW(words);
            return null;
        }
    }

    static class delete extends AsyncTask<Word, Void, Void>{
        private WordDao wordDao;

        public delete(WordDao wordDao){
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.deleteW(words);
            return null;
        }
    }

    static class update extends AsyncTask<Word, Void, Void>{
        private WordDao wordDao;

        public update(WordDao wordDao){
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            wordDao.updateW(words);
            return null;
        }
    }

    static class deleteAll extends AsyncTask<Void, Void, Void>{
        private WordDao wordDao;

        public deleteAll(WordDao wordDao){
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAllW();
            return null;
        }
    }
}