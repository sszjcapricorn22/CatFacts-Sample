package sszj.s.catsfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import okhttp3.internal.Internal
import okhttp3.internal.Internal.instance
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import sszj.s.catsfacts.api.RetrofitHelper
import sszj.s.catsfacts.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein by kodein()
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val retrofitHelper: RetrofitHelper by instance()
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        navController.navigate(R.id.homeFragment)


    }


}

