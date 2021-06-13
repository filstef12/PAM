package pl.adamowski.beerhub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.text.SimpleDateFormat;
import java.util.List;

import pl.adamowski.beerhub.BeerApplication;
import pl.adamowski.beerhub.BeerDataBase;
import pl.adamowski.beerhub.R;
import pl.adamowski.beerhub.models.Beer;
import pl.adamowski.beerhub.models.Review;
import pl.adamowski.beerhub.repository.ReviewDao;

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ViewHolder>{

    private  List<Review> reviews;

    public ReviewListAdapter(List<Review> reviewss) {
        this.reviews = reviewss;
    }

    @NonNull
    @Override
    public ReviewListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.review_list_element, parent, false);

        // Return a new holder instance
        ReviewListAdapter.ViewHolder viewHolder = new ReviewListAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewListAdapter.ViewHolder holder, int position) {

        Review review = reviews.get(position);

        TextView textViewId = holder.textView_id;
        textViewId.setText(""+review.getId());

        TextView textViewName = holder.textView_name;
        textViewName.setText(review.getName());

        TextView textViewBrewery = holder.textView_brewery;
        textViewBrewery.setText(review.getBrewery());

        TextView textViewStyle= holder.textView_style;
        textViewStyle.setText(review.getStyle());

        TextView textViewComment= holder.textView_comment;
        textViewComment.setText(review.getComment());

    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    //metoda pomocnicza do zwracania pozycji z viewHoldera
    public Review getReview(int number) {

        return (reviews != null) ? reviews.get(number) :  null;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView_id;
        public TextView textView_name;
        public TextView textView_brewery;
        public TextView textView_style;
        public TextView textView_comment;
        public LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_id = (TextView) itemView.findViewById(R.id.review_view_id);
            textView_name = (TextView) itemView.findViewById(R.id.review_view_name);
            textView_brewery = (TextView) itemView.findViewById(R.id.review_view_brewery);
            textView_style = (TextView) itemView.findViewById(R.id.review_view_style);
            textView_comment = (TextView) itemView.findViewById(R.id.review_view_comment);
            layout = (LinearLayout) itemView.findViewById(R.id.review_element_layout);

        }
    }
}
