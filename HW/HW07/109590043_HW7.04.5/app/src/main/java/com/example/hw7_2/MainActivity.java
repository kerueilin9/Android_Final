package com.example.hw7_2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw7_2.databinding.ActivityMainBinding;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<String> mRecipesList = new LinkedList<>();
    private LinkedList<String> mRecipesList1 = new LinkedList<>();
    private LinkedList<Integer> mRecipesImage = new LinkedList<Integer>();

    private RecyclerView recyclerView;
    private RecipesRecycle recipesRecycle;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        mRecipesList.addLast("椰香小球");
        mRecipesList.addLast("法式吐司");
        mRecipesList.addLast("草莓奶酪");
        mRecipesList.addLast("鮮蝦飯糰");
        mRecipesList.addLast("牛奶棒餅乾");
        mRecipesList.addLast("雙拼牛軋糖");

        mRecipesList1.addLast("鼓搗的時光總是很美妙 出爐那一刻💟滿滿都是感動 自學玩烘焙有兩年的時間 用最簡單的工具和方法 做出驚艷的作品💙堅持低糖健康的食譜");
        mRecipesList1.addLast("只要有心天天都是情人節\n" +
                "法式吐司香軟好吃，材料取得也方便\n" +
                "掌握鮮奶蛋汁比例，雙油混搭美美煎\n" +
                "加上莓果質感升級，簡單網美點心餐。");
        mRecipesList1.addLast("甜甜的草莓香配上濃郁的奶酪真是絕配，做法簡單完全零廚藝不會失敗唷！");
        mRecipesList1.addLast("適合露營野餐的時節\n" +
                "自己捏飯糰有趣營養衛生\n" +
                "搭配莓果精力飲營養滿點。");
        mRecipesList1.addLast("充滿奶香又硬梆梆的牛奶棒，最適合給正在長牙的小姪子磨牙了，所以趁著空檔，做了好多牛奶棒，然後陪著侄子一邊看電視一邊啃，非常放鬆ＸＤ");
        mRecipesList1.addLast("奶油切塊下鍋開小\n" +
                "奶油融化後下棉花糖\n" +
                "快速攪拌至一團\n" +
                "再下花生和葵花子繼續攪拌至融為一體");

        mRecipesImage.addLast(R.drawable.picture1);
        mRecipesImage.addLast(R.drawable.picture3);
        mRecipesImage.addLast(R.drawable.picture4);
        mRecipesImage.addLast(R.drawable.picture5);
        mRecipesImage.addLast(R.drawable.picture2);
        mRecipesImage.addLast(R.drawable.picture6);

        recyclerView = findViewById(R.id.recyclerview);
        recipesRecycle = new RecipesRecycle(this, mRecipesList, mRecipesList1, mRecipesImage);
        recyclerView.setAdapter(recipesRecycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}