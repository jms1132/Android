package com.example.hp.mycalendarproject;

import android.content.Context;
import android.graphics.Color;
import android.media.Image;
import android.provider.ContactsContract;
import android.text.format.Time;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.jar.Attributes;

// 무슨 의미인지?
// selectedPosition = -1;

public class MonthAdapter extends BaseAdapter {

    public Context monthContext;
    public MonthItemData[] items; //ArrayList<MonthItemData> <= 42개
    //ArrayList 에 하지 않고 배열에 넣은 이유는 '위치'가 중요하기 때문이다.
    //마치 스트링 배열처럼 해당된 데이타 객체를 42개를 만들어서 참조변수로 만들어서 넘겨줘야한다.
    public LayoutInflater layoutInflater;
    public int countColumn = 7;

    public Calendar monthCalendar;
    public int firstDay;//예를 들자면 : 11월 1일(금요일>5를 저장한다.)
    public int monthStartDay;//Calendar.SUNDAY 현재 달력 시작위치 요일(우리나라는 일요일부터 시작하는 것을 보여줌)
    public int startDay; //Time.SUNDAY
    public int currentYear;//현재 달력 연도
    public int currentMonth;//현재 달력 월
    public int lastDay; //현재 월의 마지막 날짜
    public int selectedPosition = -1;

    public MonthAdapter() {
    }

    public MonthAdapter(Context monthContext) {
        this.monthContext = monthContext;

        //달력을 계산할 내용으로 셋팅을 진행한다.
        init();

    }

    public MonthAdapter(Context context, Attributes attributes) {
        this.monthContext = monthContext;
        init();
    }

    private void init() {
        items = new MonthItemData[42];

        //현재 년도, 달, 날짜, 시간까지 값을 가져오는 명령어 = Calendar.getInstance()
        monthCalendar = Calendar.getInstance();

        //만약 11월을 선택했을 경우, 1일~30일, 1일 => 무슨 요일인지? : 금요일
        //이 달력의 시작점? : 우리나라 달력은 한주가 일요일부터 시작하지만 다른 나라의 달력은 다른 요일로 시작한다.

        //연도, 월, 마지막 일(윤년), 1일이 위치한 요일과 달력위치(월,일,토 선택)
        recalculate();

        //MonthItem 객체 배열에 넣어줘야 한다.
        //11월에 뿌려질 객체자료를 배열화 시켜서 monthItemData 객체배열에 넣어줌
        resetDayNumber();
    }


    private void resetDayNumber() {
        for (int i = 0; i < 42; i++) {
            int dayNumber = (i + 1) - firstDay;
            if (dayNumber < 1 || dayNumber > lastDay) {
                dayNumber = 0;
            }
            android.util.Log.i("Service", dayNumber + "");
            items[i] = new MonthItemData(dayNumber);
        }
    }

    private void recalculate() {
        //현재 월과 날짜를 기준으로 반영해서 1일로 셋팅한다. = 현재 11월 27일 기준으로 해서 11월 1일로 셋팅한다.
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1); // = 이 monthCalendar가 1일 0시 00분으로 셋팅이 된것

        //11월 1일이 무슨 요일인지? : 금요일 - > 일요일이 0이라면 5값을 준다. 고로 금요일은 5이다.
        int dayOfWeek = monthCalendar.get(Calendar.DAY_OF_WEEK); //나에게 날짜를 준다.
        //어느 지점부터 찍어야 되는지 정해주는 변수이다.
        firstDay = getFirstDay(dayOfWeek);
        // 현재 시스템에 달력의 첫날이 무슨 요일로 시작하는지?
        //예) 일요일로 시작, 토요일로 시작, 월요일로 시작되는 달력
        //Time.SUNDAY
        monthStartDay = monthCalendar.getFirstDayOfWeek();

        //현재 년도
        currentYear = monthCalendar.get(Calendar.YEAR);

        //현재 월
        currentMonth = monthCalendar.get(Calendar.MONTH);

        //현재 월의 마지막 날짜 = 11월 : 30일
        lastDay = getMonthLastDay(currentYear, currentMonth);

        //monthCalendar.getFirstDayOfWeek()을 우리가 계산하는 방식으로!
        startDay = getFirstDayOfWeek();
        resetDayNumber();
    }

    @Override
    public int getCount() {
        return 42;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            layoutInflater = (LayoutInflater) monthContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.calendar_layout, null);

        }
        TextView tvDay, tvEvent;
        ImageView ivMarking;


        tvDay = convertView.findViewById(R.id.tvDay);
        tvEvent = convertView.findViewById(R.id.tvEvent);
        ivMarking = convertView.findViewById(R.id.ivMarking);

        int selectedDay = items[position].getDayValue();
        if (selectedDay != 0) {
            tvDay.setText(String.valueOf(selectedDay));
        }
        // calculate row and column
        int columnIndex = position % countColumn;
        if (columnIndex == 0) {
            tvDay.setTextColor(Color.RED);
        } else {
            tvDay.setTextColor(Color.BLACK);
        }


        if(items[position].isEventExist()){
            ivMarking.setImageResource(R.drawable.heart);
            tvEvent.setText(items[position].getEventThing());
        }
        return convertView;
    }

    //각자 나라에 맞게 요일을 숫자로 표현하는 함수이다.
    private int getFirstDay(int dayOfWeek) {
        int result = 0;
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                result = 0;
                break;
            case Calendar.MONDAY:
                result = 1;
                break;
            case Calendar.TUESDAY:
                result = 2;
                break;
            case Calendar.WEDNESDAY:
                result = 3;
                break;
            case Calendar.THURSDAY:
                result = 4;
                break;
            case Calendar.FRIDAY:
                result = 5;
                break;
            case Calendar.SATURDAY:
                result = 6;
                break;
        }
        return result;
    }

    private int getMonthLastDay(int currentYear, int currentMonth) {

        switch (currentMonth + 1) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;

            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                if ((currentYear % 4 == 0) && (currentYear % 100 != 0) || (currentYear % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
        }
    }

    private int getFirstDayOfWeek() {
        startDay = Calendar.getInstance().getFirstDayOfWeek();
        switch (startDay) {
            case Calendar.SATURDAY:
                return Time.SATURDAY;
            case Calendar.MONDAY:
                return Time.MONDAY;
            case Calendar.SUNDAY:
                return Time.SUNDAY;
        }
        return 0;
    }

    public void setPreviousMonth() {
        //현재가 11월 달이라면, 10월달로 가게된다.
        monthCalendar.add(Calendar.MONTH, -1);
        recalculate();
        resetDayNumber();

        // 무슨 의미인지?
        selectedPosition = -1;
    }

    public void setNextMonth() {
        //현재가 11월 달이라면, 12월달로 가게된다.
        monthCalendar.add(Calendar.MONTH, +1);
        recalculate();
        resetDayNumber();

        // 무슨 의미인지?
        selectedPosition = -1;
    }
}
