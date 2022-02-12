package com.example.retrofit.models.viewmodels;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.retrofit.models.VolumesResponse;
import com.example.retrofit.models.repositories.BookRepository;




public class BookSearchViewModel extends AndroidViewModel {
    private BookRepository bookRepository;
    private LiveData<VolumesResponse> volumesResponseLiveData;

    public BookSearchViewModel(@NonNull Application application) {
        super(application);
    }

    public void init() {
        bookRepository = new BookRepository();
        volumesResponseLiveData = bookRepository.getVolumesResponseLiveData();
    }

    public void searchVolumes(String keyword, String author) {
        //Dotenv dotenv = Dotenv.configure().directory("/androidApp").filename("env").load();
        //bookRepository.searchVolumes(keyword, author, dotenv.get("GOOGLE_API_KEY"));
        // NO NEED TO ADD THIS. Not worth it(just gives us api key)
        bookRepository.searchVolumes(keyword, author,
                "Please Add Your Api key");
    }//had to add my api key
     // had to enable the api on my account too

    public LiveData<VolumesResponse> getVolumesResponseLiveData() {
        return volumesResponseLiveData;
    }
}
