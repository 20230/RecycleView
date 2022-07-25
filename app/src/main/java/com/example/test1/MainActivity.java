package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<HashMap<String, Object>> list;
    int[] imgs={R.drawable.t1,R.drawable.t2,R.drawable.t3,R.drawable.t4,R.drawable.t5,
            R.drawable.t6,R.drawable.t7,R.drawable.t8,R.drawable.t9,R.drawable.t10};
    String[] titles={"天后","下一站","雾里看花","爱拼","最后一首歌","刘德华",
            "刘德华","刘德华","刘德华","刘德华"};
    String[] infos={"王菲","张学友","金瑾","刘德华","刘德华","刘德华",
            "刘德华","刘德华","刘德华","刘德华"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        initData();

        /*LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);*//*这个是水平滑动，没有定义图片的大小*/

        /*GridLayoutManager girdLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(girdLayoutManager);*//*GridLayoutManager会固定每一层的高度*/
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);/*瀑布方式不会固定每一层的高度，想对来说会更紧凑*/

        RecyclerViewAdapter adapter =   new RecyclerViewAdapter(this,list);
        recyclerView.setAdapter(adapter);


       /* recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));*/
    }

    private void initData() {
        list = new ArrayList<>();

        for (int i = 0; i < imgs.length; i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("img", imgs[i] );
            map.put("title", titles[i]);
            map.put("info", infos[i]);
            list.add(map);
        }

    }
}