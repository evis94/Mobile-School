package mobileschool.tables;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by esaidoff on 16/09/2017.
 */

public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.ViewHolder> {

    private List<String> results;

    public SearchResultsAdapter(List<String> results) {
        this.results = results;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.bind(position);
    }

    @Override
    public int getItemCount() {

        return results.size();
    }

    public void setResults(List<String> results) {
        this.results = results;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvResult;

        public ViewHolder(View itemView) {

            super(itemView);
            tvResult = itemView.findViewById(R.id.tvSearchResult);
            itemView.setOnClickListener(v ->
                    Toast.makeText(v.getContext(),
                            "RecyclerView item clicked pos " + getAdapterPosition(),
                            Toast.LENGTH_SHORT).show());
        }

        public void bind(int position) {

            String result = results.get(position);
            tvResult.setText(result + " " + position);
        }
    }
}
