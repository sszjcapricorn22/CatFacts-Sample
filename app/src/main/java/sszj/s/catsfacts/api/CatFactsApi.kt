package sszj.s.catsfacts.api

import retrofit2.http.GET
import sszj.s.catsfacts.model.CatFact

interface CatFactsApi {
    @GET("/facts")
    suspend fun getCatFacts(): List<CatFact>
}
