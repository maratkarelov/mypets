package test.zimad.mypets.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {
    private static PetsApi jsonApi;

    public static PetsApi getJsonApi() {
        if(jsonApi == null) {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            String PETS_ENDPOINT = "http://kot3.com/";
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(PETS_ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();

            jsonApi = retrofit.create(PetsApi.class);
        }

        return jsonApi;
    }
}
