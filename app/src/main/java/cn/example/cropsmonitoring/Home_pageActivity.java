package cn.example.cropsmonitoring;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home_pageActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Fragment homeFragment = new HomeFragment();
    private Fragment shibieFragment = new ShibieFragment();
    private Fragment jianceFragment = new JianceFragment();
    private Fragment activeFragment = homeFragment; // 默认显示的Fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this); // 使用this引用当前实例

        // 初始化Fragment并添加到容器中
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, homeFragment, "home").hide(homeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, shibieFragment, "shibie").hide(shibieFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, jianceFragment, "jiance").hide(jianceFragment).commit();
        // 默认显示homeFragment
        getSupportFragmentManager().beginTransaction().show(homeFragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                getSupportFragmentManager().beginTransaction().hide(activeFragment).show(homeFragment).commit();
                activeFragment = homeFragment;
                break;
            case R.id.navigation_shibie:
                getSupportFragmentManager().beginTransaction().hide(activeFragment).show(shibieFragment).commit();
                activeFragment = shibieFragment;
                break;
            case R.id.navigation_jiance:
                getSupportFragmentManager().beginTransaction().hide(activeFragment).show(jianceFragment).commit();
                activeFragment = jianceFragment;
                break;
        }
        return true;
    }
}


