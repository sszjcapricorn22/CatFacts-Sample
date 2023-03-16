package sszj.s.catsfacts.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import sszj.s.catsfacts.adapter.CatFactsAdapter
import sszj.s.catsfacts.databinding.FragmentHomeBinding
import sszj.s.catsfacts.model.CatFact

class HomeFragment : Fragment(), CatFactsAdapter.Listener, KodeinAware {

    override val kodein: Kodein by kodein()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CatFactsViewModel
    private val factory: CatFactsViewModelFactory by instance()
    var catFactsAdapter: CatFactsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(CatFactsViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel.loadCatFacts()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = catFactsAdapter
        //facts
        catFactsAdapter = CatFactsAdapter((this))
        binding.recyclerView.adapter = catFactsAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        viewModel.catFacts.observe(viewLifecycleOwner, Observer { facts ->
            try {
                if (facts.isNotEmpty()) {
                    catFactsAdapter?.updateList(facts as ArrayList<CatFact>)
                    Log.d("test123", "Facts received: ${facts.size}")
                } else {
                    Log.d("test123", "Facts list is empty")
                }
            } catch (e: Exception) {
                Log.e("test123", "Error updating adapter: ${e.message}")
            }
        })
    }

    override fun Item(item: CatFact) {
        Toast.makeText(context, item._id, Toast.LENGTH_SHORT).show()
    }
}