package com.example.weiqiliu.materialdesign;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.MaskFilterSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weiqiliu.materialdesign.activity.AsymchronousActivty;
import com.example.weiqiliu.materialdesign.activity.ListviewActivity;
import com.example.weiqiliu.materialdesign.interf.Icallback;
import com.example.weiqiliu.materialdesign.scan.CaptureActivity;
import com.example.weiqiliu.materialdesign.util.BitMapUtil;
import com.example.weiqiliu.materialdesign.view.MultiLineRadioGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject String hello;
    private RecyclerView mRecyclerView;
    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private ImageView img;
    private ImageView img2;
    private TextView herf;
    private TextView appearanceSpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showDialog1();
//        initVIew();
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initView(){
        Toast.makeText(MainActivity.this,hello,Toast.LENGTH_LONG).show();
        iterator();
        button=(Button) findViewById(R.id.btn1);
        button2=(Button) findViewById(R.id.btn2);
        button3=(Button) findViewById(R.id.btn3);
        button4=(Button) findViewById(R.id.btn4);
        button5=(Button) findViewById(R.id.btn5);
        img=(ImageView) findViewById(R.id.img);
        img2=(ImageView) findViewById(R.id.img2);
        herf=(TextView) findViewById(R.id.herf);
        appearanceSpan=(TextView) findViewById(R.id.appearance_span);
        setText();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerviewActivity.class));
            }
        });
        button2.setOnClickListener(v -> startActivity
                (new Intent(MainActivity.this, AnimationActivity.class)));
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AsymchronousActivty.class));
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CaptureActivity.class));
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListviewActivity.class));
            }
        });
        button5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        MultiLineRadioGroup multiLineRadioGroup=(MultiLineRadioGroup) findViewById(R.id.content);
        for(int i=0;i<25;i++){
            multiLineRadioGroup.insert(i, "insert"+i);
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.ic_subsribe_part,options);
        int imageHeight = options.outHeight;
        Log.e("size1",String.valueOf(imageHeight));
//        int imageWidth = options.outWidth;
//        String imageType = options.outMimeType;
        img2.setImageResource(R.drawable.ic_subsribe_part);
        img.setImageBitmap(BitMapUtil.decodeSampledBitmapFromResource(getResources(), R.drawable.ic_subsribe_part, 50, 50));
        Log.e("size2", String.valueOf(BitMapUtil.getSize(getResources(), R.drawable.ic_subsribe_part, 50, 50)));
    }

    protected ArrayList<String> initData()
    {
        ArrayList<String> mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }

        return mDatas;
    }


    class NormalRecyclerViewAdapter extends  RecyclerView.Adapter<NormalRecyclerViewAdapter.MyViewHolder>{
        private ArrayList<String> mDatas;
        public NormalRecyclerViewAdapter(Context context,ArrayList<String> strings) {
            mDatas=strings;
        }

        @Override
        public NormalRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    MainActivity.this).inflate(R.layout.item_home, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(NormalRecyclerViewAdapter.MyViewHolder myViewHolder, int i) {
            myViewHolder.tv.setText(mDatas.get(i));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.id_num);
            }
        }
    }

    private void showDialog1() {
        android.support.v7.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("让我们一起飞，我带着你，你带着钱，来一场说走就走的旅行")
                .setTitle("Material Design Dialog");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "xxxxx", Toast.LENGTH_LONG).show();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "queding", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }

    private void iterator(){
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

        for (String player : players) {
            System.out.print(player + "; ");
        }
    }

    private void setText(){
//        SpannableString spanText = new SpannableString("URLSpan -- 萝卜白菜的博客");
//        spanText.setSpan(new URLSpan("http://baidu.com"), 10, spanText.length(),
//                Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
//        herf.append("\n");
//        herf.append(spanText);
//        herf.setMovementMethod(new LinkMovementMethod());

//        SpannableString spanText = new SpannableString("TextAppearanceSpan -- 萝卜白菜的博客");
//        spanText.setSpan(new TextAppearanceSpan(this, android.R.style.TextAppearance_Medium),
//                6, 7, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
//        appearanceSpan.append("\n");
//        appearanceSpan.append(spanText);
        SpannableString spanText = new SpannableString("MaskFilterSpan -- http://orgcent.com");
        int length = spanText.length();
        MaskFilterSpan maskFilterSpan = new MaskFilterSpan(new BlurMaskFilter(3, BlurMaskFilter.Blur.OUTER));
        spanText.setSpan(maskFilterSpan, 0, length - 10, Spannable.
                SPAN_INCLUSIVE_EXCLUSIVE);
        appearanceSpan.append("\n");
        appearanceSpan.append(spanText);
    }
}
