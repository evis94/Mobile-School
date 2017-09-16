package mobileschool.tables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private final int MAX_RESULTS = 70;

    @BindView(R.id.etSearch)
    EditText etSearch;
    @BindView(R.id.btnSearch)
    Button btnSearch;
    @BindView(R.id.lvSearchResults)
    ListView listViewResults;

    SearchResultsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bindUI();
    }

    private void bindUI() {


        btnSearch.setOnClickListener(view -> {
            String text = etSearch.getText().toString();
            List<String> results = Collections.nCopies(MAX_RESULTS, text);
            showResultsInListView(results);
        });
    }

    private void showResultsInListView(List<String> results) {

        if (adapter == null) {
            adapter = new SearchResultsAdapter(this, results);
            listViewResults.setAdapter(adapter);
        } else {
            adapter.setSearchResults(results);
            adapter.notifyDataSetChanged();
        }

        listViewResults.setOnItemClickListener((adapterView, itemView, pos, id) -> {
            Toast.makeText(this, "List Item Clicked in pos: " + pos, Toast.LENGTH_SHORT).show();
        });
    }
}
