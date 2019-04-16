package test.zimad.mypets.ui.list;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import test.zimad.mypets.api.ApiFactory;
import test.zimad.mypets.data.PetsData;

public class PetsPresenter implements PetsContract.IPetsPresenter {
    private PetsContract.IPetsView view;

    public PetsPresenter(PetsContract.IPetsView view) {
        this.view = view;
    }

    @Override
    public void readPets(String type) {
        Call<PetsData> call = ApiFactory.getJsonApi().getPets(type);
        call.enqueue(new Callback<PetsData>() {
            @Override
            public void onResponse(Call<PetsData> call, Response<PetsData> response) {
                if (response.body() != null)  {
                    view.showPets(response.body().getData());
                }
            }

            @Override
            public void onFailure(Call<PetsData> call, Throwable t) {
                view.showError(t.getLocalizedMessage());
            }
        });

    }
}
