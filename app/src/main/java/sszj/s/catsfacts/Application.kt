package sszj.s.catsfacts

import android.app.Application
import okhttp3.internal.Internal
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import sszj.s.catsfacts.api.CatFactsApi
import sszj.s.catsfacts.api.RetrofitHelper
import sszj.s.catsfacts.repository.CatFactsRepository
import sszj.s.catsfacts.ui.CatFactsViewModelFactory

class Application : Application(), KodeinAware {

    override val kodein = Kodein.lazy {

        import(androidXModule(this@Application))
        bind() from provider { CatFactsRepository(instance()) }
        bind() from provider { CatFactsViewModelFactory(instance()) }
        bind() from provider { RetrofitHelper().createApiService() as CatFactsApi }
        bind<String>("BaseUrl") with provider { "https://cat-fact.herokuapp.com/" }


    }
}