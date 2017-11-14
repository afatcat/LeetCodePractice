package net.shutingg.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<StringBuffer> buffers = new ArrayList<>();
        if(n==0){
            return buffers.stream().map(StringBuffer::toString).collect(Collectors.toList());
        }
        StringBuffer sb = new StringBuffer();
        buffers.add(sb);
        generator(buffers, 0, n, sb);
        List<String> result = buffers.stream().map(StringBuffer::toString).collect(Collectors.toList());
        return result;
    }

    private void generator(List<StringBuffer> buffers, int leftCount, int rightCount, StringBuffer sb){
        if(rightCount > 0){
            if(leftCount > 0){
                StringBuffer sb2 = new StringBuffer();
                sb2.append(sb.toString());
                sb2.append(")");
                buffers.add(sb2);
                generator(buffers, leftCount-1, rightCount, sb2);
            }
            sb.append("(");
            generator(buffers, leftCount+1, rightCount-1, sb);
        }else if(leftCount >0){
            sb.append(")");
            generator(buffers, leftCount-1, rightCount, sb);
        }else{
            return;
        }
    }
}
