
public class KMP {
    void getNext(String pattern, int[] next) {
        int j = 0;
        int k = -1;
        int len = pattern.length();
        next[0] = -1;

        while (j < len - 1) {
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
                j++;
                k++;
                next[j] = k;
            } else {
                //�Ƚϵ���k���ַ���˵��p[0����k-1]�ַ�����p[j-k����j-1]�ַ�����ȣ���next[k]��ʾ
                //p[0����k-1]��ǰ׺�ͺ�׺������г��ȣ�������������ֱ�ӱȽ�p[next[k]]��p[j]
                k = next[k];

            }
        }
    }

    int kmp (String s, String pattern) {
        int i = 0;
        int j = 0;
        int slen = s.length();
        int plen = pattern.length();

        int[] next = new int[plen];
        getNext(pattern, next);
        while (i < slen && j < plen) {
            if (s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (next[j] == -1) {
                    i++;
                    j = 0;
                } else {
                    j = next[j];
                }
            }

            if (j == plen) {
                return i - j;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println("Hello world");
    }
}