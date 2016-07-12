package com.epicodus.sharedchores;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;

        import com.epicodus.sharedchores.services.YelpService;

        import java.io.IOException;

        import okhttp3.Call;
        import okhttp3.Callback;
        import okhttp3.Response;

public class CleaningServicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaning_services);
    }

    private void getCleaningServices(String location) {
        final YelpService yelpService = new YelpService();
        yelpService.findCleaningServices(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v("TAG", jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
