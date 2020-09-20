package com.android.roomwords;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class WordRepository {

    private Dao wordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application){
     WordRoomDatabase db= WordRoomDatabase.getDatabase(application);
     wordDao=db.wordDao();
     mAllWords=wordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }
    public  void insert(Word word){
       new insertAsyncTask(wordDao).execute(word);
    }
    public static class insertAsyncTask extends AsyncTask<Word, Void,Void>{
        private Dao mAsyncTaskDao;

        insertAsyncTask(Dao dao){
            mAsyncTaskDao=dao;
        }
        protected Void doInBackground(final Word... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
    }
