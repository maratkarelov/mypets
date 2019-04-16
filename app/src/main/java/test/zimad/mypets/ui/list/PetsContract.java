package test.zimad.mypets.ui.list;

import java.util.ArrayList;

import test.zimad.mypets.data.PetInfo;

public interface PetsContract {
    interface IPetsView{
        void showPets(ArrayList<PetInfo> pets);
        void showError(String error);
    }
    interface IPetsPresenter{
        void readPets(String type);
    }
}
