java_change color：
	mShowCount.setTextColor(0xFF777777);
	mShowCount.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
	mShowCount.setTextColor(getResources().getColor(this, R.color.colorPrimary));
	mShowCount.setBackgroundColor(Color.rgb(255,255,255));
--------------------------------------------------------------------------------------------------------------------------------------------------
螢幕旋轉資料保存：
https://www.youtube.com/watch?v=f08AfUd99zo&list=PLPh5-KovAYtFyX5elSTT9wEMt0HxMhR7L&index=10&t=1200s&ab_channel=longway777
--------------------------------------------------------------------------------------------------------------------------------------------------
作業header：
import android.support.v7.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity{}
--------------------------------------------------------------------------------------------------------------------------------------------------
ViewModel相關套件：

    implementation 'androidx.lifecycle:lifecycle-extensions:2.1.0' //Main
--------------------------
    dataBinding{
        enabled true
    }
--------------------------------------------------------------------------------------------------------------------------------------------------
Replace onActivityCreated：

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        
    }
--------------------------------------------------------------------------------------------------------------------------------------------------
find Navgation controller：

	NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController controller = navHostFragment.getNavController();
--------------------------------------------------------------------------------------------------------------------------------------------------
fragment basic databinding：

	ViewModel1 viewModel1;
        viewModel1 = ViewModelProviders.of(getActivity()).get(ViewModel1.class);
        FragmentHomeBinding binding;
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        binding.setData(viewModel1);
        binding.setLifecycleOwner(getActivity());
        binding.button123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel1.getNum().setValue(Integer.parseInt(binding.editTextNumber.getText().toString()));

                NavController controller = Navigation.findNavController(view);
                controller.navigate(R.id.action_homeFragment_to_page1Fragment);
            }
        });
        return binding.getRoot();
--------------------------------------------------------------------------------------------------------------------------------------------------
Determine if the EditText is empty：

	boolean x = edt.getText().toString().matches("");
--------------------------------------------------------------------------------------------------------------------------------------------------


















期末專題：
	1. 交友軟體
	2. 記帳 記事結合
	3. 發票兌獎
	4. 北科餐廳 + 吃甚麼APP 
	5. 北科綜合(校園簡介等)APP
