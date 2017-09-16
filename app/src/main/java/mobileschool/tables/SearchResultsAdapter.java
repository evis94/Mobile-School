package mobileschool.tables;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by esaidoff on 16/09/2017.
 */

public class SearchResultsAdapter extends BaseAdapter {

    List<String> results;
    LayoutInflater layoutInflater;

    public SearchResultsAdapter(Context context, List<String> results) {

        this.results = results;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int pos) {
        return results.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {

        View rowView = layoutInflater.inflate(R.layout.row_item, viewGroup, false);
        TextView tvResult = rowView.findViewById(R.id.tvSearchResult);
        String searchResult = results.get(pos);
        tvResult.setText(searchResult + " " + pos);
        return rowView;
    }

    public void setSearchResults(List<String> searchResults) {
        results = searchResults;
    }
}
