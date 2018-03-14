package net.shutingg.leetCode;

public class ReadCharactersFromFileMultipleCalls {
    char[] buf4 = new char[4];
    int head = 0;
    int tail = 0;

    /**
     * @param buf destination buffer
     * @param n maximum number of characters to read
     * @return the number of characters read
     */
    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            while (head < tail && i < n) {
                buf[i] = buf4[head];
                head++;
                i++;
            }
            if (i == n) {
                break;
            }
            head = 0;
            tail = 0;
            tail = read4(buf4);
            if (tail == 0) {
                break;
            }
        }
        return i;
    }

    /**
     * dummy method
     *
     * @param buf
     * @return
     */
    public int read4(char[] buf) {
        return 0;
    }
}
