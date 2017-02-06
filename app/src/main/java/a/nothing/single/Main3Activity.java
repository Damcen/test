package a.nothing.single;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import a.nothing.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class Main3Activity extends AppCompatActivity
{
    @BindView(R.id.auto)
    AutoCompleteTextView auto;
    @BindView(R.id.sp)
    Spinner sp;
    @BindView(R.id.btn_spinner)
    Button btnSpinner;
    @BindView(R.id.btn_DatePicker)
    Button btnTimePicker;
    @BindView(R.id.tv_seek1)
    TextView tvSeek1;
    @BindView(R.id.tv_seek2)
    TextView tvSeek2;
    @BindView(R.id.seek)
    SeekBar seek;
    @BindView(R.id.datePicker)
    DatePicker datePicker;
    @BindView(R.id.TimePicker)
    android.widget.TimePicker timePicker;

    private int flag = 1;
    private int year;
    private int month;
    private int day;

    private List<String> autos;
    private ArrayAdapter<String> adapter;

    private List<String> spinners;
    private ArrayAdapter<String> adapter_spinner;
    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bind = ButterKnife.bind(this);

        autos = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, initList(autos));
        auto.setAdapter(adapter);

        spinners = new ArrayList<>();
        adapter_spinner = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, initList(spinners));
        adapter_spinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter_spinner);

//        datePicker
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener()
        {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2)
            {
                Main3Activity.this.year = i;
                Main3Activity.this.month = i1;
                Main3Activity.this.day = i2;
            }
        });

        //TimePicker
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minute = Calendar.getInstance().get(Calendar.MINUTE);
        timePicker.setCurrentHour(hour);
        timePicker.setCurrentMinute(minute);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener()
        {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute)
            {
                Toast.makeText(Main3Activity.this, "时间:" + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
            }
        });

        //SeekBar
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tvSeek1.setText("拖动中");
                tvSeek2.setText("进度:" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {
                tvSeek1.setText("准备拖动");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {
                tvSeek1.setText("拖动完成");
            }
        });

    }

    @OnClick({R.id.btn_spinner, R.id.btn_DatePicker})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btn_spinner:
                loadMore(spinners);
                adapter_spinner.notifyDataSetChanged();
                break;

            case R.id.btn_DatePicker:
                setDatePicker();
                break;
        }
    }

    private void setDatePicker()
    {
        TextView textView = (TextView) findViewById(R.id.tv_DatePicker);
        String str = "当前的日期是:" + year + "年" + month + "月" + day + "日";
        textView.setText(str);
    }

    public List<String> initList(List<String> list)
    {
        for (int i = 0; i < 10; i++)
        {
            list.add("blabla" + i);
        }
        return list;
    }

    public List<String> loadMore(List<String> list)
    {
        for (int i = 0; i < 5; i++)
        {
            list.add(flag + "新数据" + i);
        }
        flag++;
        return list;
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        bind.unbind();
    }
}
