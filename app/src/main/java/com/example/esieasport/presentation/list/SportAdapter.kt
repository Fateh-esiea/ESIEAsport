import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.esieasport.R
import com.example.esieasport.presentation.list.Sport
import kotlin.reflect.KFunction1

class SportAdapter(private var dataSet: List<Sport>, var listener: ((Sport) -> Unit)? = null) : RecyclerView.Adapter<SportAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.sport_name)

        }
    }
    fun updateList(list: List<Sport>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.sport_item, viewGroup,false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val sport = dataSet[position]
        viewHolder.textView.text = sport.name
        viewHolder.itemView.setOnClickListener{
        listener?.invoke(sport)

        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
