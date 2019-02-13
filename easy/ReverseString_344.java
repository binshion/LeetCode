import java.sql.Array;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。
 * e.g.
 * 输入: "hello"
 * 输出: "olleh"
 */
public class ReverseString_344 {
    public String reverseString(String s) {
        if(s == null || s.length() < 1) {
            return "";
        }
        else if(s.length() == 1) {
            return s;
        }
        else {
            char[] array = s.toCharArray();
            int length = array.length;
            for(int i = 0; i < length / 2; i++) {
                char temp = array[i];
                array[i] = array[length - 1 - i];
                array[length - 1 - i] = temp;
            }

            return new String(array);
        }
    }

    public static void main(String[] args) {
        ReverseString_344 s = new ReverseString_344();
        String ss = s.reverseString("hello");
        System.out.println(ss);
    }
}
