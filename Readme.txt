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

    implementation 'androidx.lifecycle:lifecycle-extensions:2.1.0'
    def room_version = "2.4.2"
    implementation "androidx.room:room-runtime:$room_version"
    annotationProcessor "androidx.room:room-compiler:$room_version"

    // optional - Test helpers
    testImplementation "androidx.room:room-testing:$room_version"

    // optional - Paging 3 Integration
    implementation "androidx.room:room-paging:2.5.0-alpha01"
--------------------------------------
    dataBinding{
       	enabled true
    }
--------------------------------------
    buildFeatures {
        viewBinding true
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
Create menu at Fragment：

	public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater){
        	inflater.inflate(R.menu.my_menu, menu);
       		super.onCreateOptionsMenu(menu, inflater);
  	  }
--------------------------------------------------------------------------------------------------------------------------------------------------
NoActionBar：

    <style name="Theme.HW7_2.NoActionBar">
        <item name="windowActionBar">false</item>
        <item name="windowNoTitle">true</item>
    </style>

    <style name="AppTheme.AppBarOverlay" parent="ThemeOverlay.AppCompat.Dark.ActionBar" />

    <style name="AppTheme.PopupOverlay" parent="ThemeOverlay.AppCompat.Light" />
--------------------------------------------------------------------------------------------------------------------------------------------------
MainActivity：

	private ActivityMainBinding binding;

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
--------------------------------------------------------------------------------------------------------------------------------------------------
Navigation：

	DrawerLayout：
    		android:fitsSystemWindows="true"
    		tools:openDrawer="start"

	NavigationView：
        	android:layout_gravity="start"
        	android:fitsSystemWindows="true"
		app:headerLayout=""
		app:menu=""














期末專題：
	1. 交友軟體
	2. 記帳 記事結合
	3. 發票兌獎
	4. 北科餐廳 + 吃甚麼APP 
	5. 北科綜合(校園簡介等)APP
