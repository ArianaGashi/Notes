package com.android.roomwords;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class WordViewmodel extends AndroidViewModel {
    public WordRepository mRepository;
    public LiveData<List<Word>> mAllWords;

    public WordViewmodel(@NonNull Application application) {
        super(application);
        mRepository= new WordRepository(application);
        mAllWords=mRepository.getAllWords();
    }
    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }
    public void insert(Word word) {
        mRepository.insert(word);
    }
}
