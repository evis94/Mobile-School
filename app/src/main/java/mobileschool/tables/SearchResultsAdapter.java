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
    public View getView(int pos, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.row_item, viewGroup, false);
            convertView.setTag(holder);
            holder.tvResult = convertView.findViewById(R.id.tvSearchResult);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String result = results.get(pos);
        holder.tvResult.setText(result + " " + pos);

        return convertView;
    }

    public void setSearchResults(List<String> searchResults) {
        results = searchResults;
    }

    public class ViewHolder {

        TextView tvResult;
    }
}
