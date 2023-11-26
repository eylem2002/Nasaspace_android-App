package com.example.google_map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitAPICall {
    @GET("api/area/csv/{MAP_KEY}/{SOURCE}/{AREA_COORDINATES}/{DAY_RANGE}")
    Call<String> getData(
            @Path("MAP_KEY") String mapKey,
            @Path("SOURCE") String source,
            @Path("AREA_COORDINATES") String areaCoordinates,
            @Path("DAY_RANGE") String dayRange
    );
}
