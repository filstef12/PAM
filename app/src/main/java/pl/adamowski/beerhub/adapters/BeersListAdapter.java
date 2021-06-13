
package pl.adamowski.beerhub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.text.SimpleDateFormat;
import java.util.List;

import pl.adamowski.beerhub.R;
import pl.adamowski.beerhub.models.Beer;

public class BeersListAdapter extends RecyclerView.Adapter<BeersListAdapter.ViewHolder> {

    private List<Beer> beers;
    //konstruktor

    public BeersListAdapter(List<Beer> beers){
        this.beers= beers;
    }


    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.beers_list_element, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder holder, int position) {

        Beer beer = beers.get(position);

        TextView textViewTitle = holder.textView_Name;
        textViewTitle.setText(beer.getBrewery());

        TextView textViewAuthor = holder.textView_Brewery;
        textViewAuthor.setText(beer.getName());

        TextView textViewDate = holder.textView_Style;
        textViewDate.setText(beer.getStyle());
    }

    @Override
    public int getItemCount() {
        return beers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView_Name;
        public TextView textView_Brewery;
        public TextView textView_Style;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_Name = (TextView) itemView.findViewById(R.id.Name);
            textView_Brewery = (TextView) itemView.findViewById(R.id.Brewery);
            textView_Style = (TextView) itemView.findViewById(R.id.Style);
        }
    }
}