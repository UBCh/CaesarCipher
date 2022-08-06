package dao;

import exception.TextNotFoundException;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class StrimDao {

    static RandomAccessFile randomAccessFile;
    static StringBuilder builder = new StringBuilder( );
    static {
        try {
            randomAccessFile = new RandomAccessFile("out/text.txt", "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace( );
        }
    }

    static FileChannel channel = randomAccessFile.getChannel( );

    public static String inputFiles() throws IOException, TextNotFoundException {
// создаем буфер необходимого размера на основании размера нашего канала
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size( ));
           channel.read(byteBuffer);
        // переключаем буфер с режима записи на режим чтения
        byteBuffer.flip( );

           String result = new String(byteBuffer.array(),StandardCharsets.UTF_8);
        if (result.length( ) < 1) throw new TextNotFoundException("файл пустой, поместите текст в файл");
        return result;

    }


    public static void outputFiles(String text) throws IOException {
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("out/text.txt"), "UTF-8"));
        out.append(text);
        out.close( );
    }
}



