package mobileschool.tables;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

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
    @BindView(R.id.rv)
    RecyclerView recyclerView;

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
            showResultsInRecyclerView(results);
        });
    }

    private void showResultsInRecyclerView(List<String> results) {

        if (adapter == null) {
            adapter = new SearchResultsAdapter(results);
            recyclerView.setAdapter(adapter);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(layoutManager);
        } else {
            adapter.setResults(results);
            adapter.notifyDataSetChanged();
        }
    }
}
