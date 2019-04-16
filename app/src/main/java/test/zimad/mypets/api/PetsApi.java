package test.zimad.mypets.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import test.zimad.mypets.data.PetsData;

public interface PetsApi {

    @GET("xim/api.php")
    Call<PetsData> getPets(@Query("query") String query);
}
