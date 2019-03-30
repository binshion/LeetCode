import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCalendarI_729 {
    public static void main(String[] args){
        MyCalendar calendar = new MyCalendar();
        System.out.println(calendar.book(37, 50));
        System.out.println(calendar.book(33, 50));
        System.out.println(calendar.book(4, 17));
        System.out.println(calendar.book(35, 48));
        System.out.println(calendar.book(8, 25));
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
class MyCalendar {
    List<List<Integer>> lists;
    public MyCalendar() {
        lists = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (lists.size() < 1) {
            lists.add(Arrays.asList(start, end));
            return true;
        }

        if (end <= lists.get(0).get(0)) {  //小于第一个期间，直接加载第一个位置
            lists.add(0, Arrays.asList(start, end));
            return true;
        } else if (start >= lists.get(lists.size() - 1).get(1)) {  //大于最后一个，加在最后
            lists.add(Arrays.asList(start, end));
            return true;
        } else {
            int last = 0;
            for (int i = 0; i < lists.size(); i++) {
                if (start == lists.get(i).get(0)) {
                    return false;
                } else if (start < lists.get(i).get(0)){
                    last = i - 1;
                    break;
                }
            }

            if ((last < 0 || (last >= 0 && start >= lists.get(last).get(1))) && end <= lists.get(last + 1).get(0)) {
                lists.add(last + 1, Arrays.asList(start, end));
                return true;
            }
        }

        return false;
    }
}

