package sszj.s.catsfacts.repository

import sszj.s.catsfacts.api.CatFactsApi
import sszj.s.catsfacts.api.RetrofitHelper
import sszj.s.catsfacts.model.CatFact

class CatFactsRepository(private val catFactsApi: CatFactsApi) {

    private val apiService: CatFactsApi = RetrofitHelper().createApiService()

    suspend fun getCatFacts(): List<CatFact> {
        return apiService.getCatFacts()
    }
}