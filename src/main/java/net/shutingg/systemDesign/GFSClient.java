package net.shutingg.systemDesign;

import java.util.HashMap;
import java.util.Map;

class BaseGFSClient {
    private Map<String, String> chunk_list;

    public BaseGFSClient() {
    }

    public String readChunk(String filename, int chunkIndex) {
        // Read a chunk from GFS
        return null;
    }

    public void writeChunk(String filename, int chunkIndex,
                           String content) {
        // Write a chunk to GFS
    }
}

public class GFSClient extends BaseGFSClient {
    private int chunkSize;
    private Map<String, Integer> metadata;

    /*
    * @param chunkSize: An integer
    */
    public GFSClient(int chunkSize) {
        this.chunkSize = chunkSize;
        metadata = new HashMap<>();
    }

    /*
     * @param filename: a file name
     * @return: conetent of the file given from GFS
     */
    public String read(String filename) {
        if (!metadata.containsKey(filename)) {
            return null;
        }
        int index = 0;
        StringBuilder sb = new StringBuilder();
        int fileSize = metadata.get(filename);
        while (index < fileSize) {
            String chunk = readChunk(filename, index);
            if (index + chunkSize > fileSize) {
                chunk = chunk.substring(0, fileSize - index);
            }
            sb.append(chunk);
            index += chunkSize;
        }

        return sb.toString();
    }

    /*
     * @param filename: a file name
     * @param content: a string
     * @return: nothing
     */
    public void write(String filename, String content) {
        if (content == null || filename == null) {
            return;
        }
        int index = 0;
        metadata.put(filename, content.length());
        while (index < content.length()) {
            int end = index + chunkSize > content.length() ? content.length() : index + chunkSize;
            String chunk = content.substring(index, end);
            writeChunk(filename, index, chunk);
            index = end;
        }
    }
}
