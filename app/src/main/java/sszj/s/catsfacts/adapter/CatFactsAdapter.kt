package sszj.s.catsfacts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sszj.s.catsfacts.R
import sszj.s.catsfacts.model.CatFact
import sszj.s.catsfacts.ui.HomeFragment

class CatFactsAdapter(private val listener: Listener) :
    RecyclerView.Adapter<CatFactsAdapter.ViewHolder>() {
    private var itemsList: ArrayList<CatFact> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }

    fun updateList(newItemsList: ArrayList<CatFact>) {
        itemsList = newItemsList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemsList[position]
        holder.tvFact.text = item.text
        holder.tvUpvotes.text = item.createdAt
        holder.tvType.text = item.updatedAt


        holder.itemView.setOnClickListener {
            listener.Item(item)
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvFact: TextView = view.findViewById(R.id.textViewFact)
        val tvType: TextView = view.findViewById(R.id.textViewSource)
        val tvUpvotes: TextView = view.findViewById(R.id.textViewDate)
    }

    interface Listener {
        fun Item(item: CatFact)

    }

}