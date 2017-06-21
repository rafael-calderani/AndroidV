package br.com.calderani.androidv.api;

import br.com.calderani.androidv.model.AndroidResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by logonrm on 21/06/2017.
 * JSONSCHEMA2POJO = cria classes a partir do retorno JSON
 */

public interface AndroidAPI {
    @GET("/v2/58af1fb21000001e1cc94547")
    Call<AndroidResponse> getVersoes();

}
