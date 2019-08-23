package org.freelesson.databindingsample.data;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class SimpleViewModel extends ViewModel {
    private MutableLiveData<String> _name = new MutableLiveData<>("Ada");
    private MutableLiveData<String> _lastName = new MutableLiveData<>("Lovelace");
    private MutableLiveData<Integer> _likes = new MutableLiveData<>(0);


    public LiveData<String> name = _name;
    public LiveData<String> lastName = _lastName;
    public LiveData<Integer> likes = _likes;

    public  void onLike() {
        _likes.postValue((_likes.getValue()!=null ? _likes.getValue() : 0)+ 1);
    }

    public LiveData<Popularity> popularity = Transformations.map(_likes, (input)-> input > 9? Popularity.STAR : input > 4? Popularity.POPULAR : Popularity.NORMAL);

}

