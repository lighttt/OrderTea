package np.com.manishtuladhar.ordertea;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import np.com.manishtuladhar.ordertea.model.Tea;

public class MenuActivity extends AppCompatActivity {

    public static final String EXTRA_TEA_NAME  = "np.com.manishtuladhar.ordertea.EXTRA_TEA_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar menuToolbar = findViewById(R.id.menu_toolbar);
        setSupportActionBar(menuToolbar);
        getSupportActionBar().setTitle(getString(R.string.menu_title));

        // Create an ArrayList of teas
        final ArrayList<Tea> teas = new ArrayList<>();
        teas.add(new Tea(getString(R.string.black_tea_name), R.drawable.black_tea));
        teas.add(new Tea(getString(R.string.green_tea_name), R.drawable.green_tea));
        teas.add(new Tea(getString(R.string.white_tea_name), R.drawable.white_tea));
        teas.add(new Tea(getString(R.string.oolong_tea_name), R.drawable.oolong_tea));
        teas.add(new Tea(getString(R.string.honey_lemon_tea_name), R.drawable.honey_lemon_tea));
        teas.add(new Tea(getString(R.string.chamomile_tea_name), R.drawable.chamomile_tea));

        //populate using gridview
        GridView gridView = findViewById(R.id.tea_grid_view);
        TeaMenuAdapter adapter = new TeaMenuAdapter(this,R.layout.grid_item_layout,teas);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Tea item = (Tea) adapterView.getItemAtPosition(position);
                //intent to order activity
                Intent mTeaIntent = new Intent(MenuActivity.this,OrderActivity.class);
                String teaName = item.getTeaName();
                mTeaIntent.putExtra(EXTRA_TEA_NAME,teaName);
                startActivity(mTeaIntent);
            }
        });

    }
}