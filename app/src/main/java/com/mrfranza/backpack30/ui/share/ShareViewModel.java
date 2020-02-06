package com.mrfranza.backpack30.ui.share;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ShareViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("DEVELOPER: Alberto Franzin 5BIA\nISTITUTO: J.F.Kennedy Pordenone 2020\n\n1.L'applicazione è gratuita ed avente codice sorgente aperto al pubblico (open source). Si prega di non usare il codice sorgente a scopo di lucro.\n2.Se l'applicazione  vi è stata utile fate un favore allo sviluppatore e condividetela!");
    }

    public LiveData<String> getText() {
        return mText;
    }
}