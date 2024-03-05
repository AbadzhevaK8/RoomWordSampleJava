package com.abadzheva.roomwordsamplejava.repository;


import android.app.Application;

import androidx.lifecycle.LiveData;

import com.abadzheva.roomwordsamplejava.model.Word;
import com.abadzheva.roomwordsamplejava.model.WordDao;
import com.abadzheva.roomwordsamplejava.model.WordRoomDatabase;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        WordRoomDatabase.databaseWriteExecutor.execute(() -> mWordDao.insert(word));
    }
}
