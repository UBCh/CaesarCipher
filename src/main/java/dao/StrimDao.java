package dao;

import exception.TextNotFoundException;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class StrimDao {



    public static String inputFiles() throws IOException, TextNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("text.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel( );

// создаем буфер необходимого размера на основании размера нашего канала
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size( ));
        channel.read(byteBuffer);
        // переключаем буфер с режима записи на режим чтения
        byteBuffer.flip( );

        String result = new String(byteBuffer.array( ), StandardCharsets.UTF_8);
        if (result.length( ) < 1) throw new TextNotFoundException("файл пустой, поместите текст в файл");
        return result.toUpperCase(Locale.ROOT);

    }


    public static void outputFiles(String text) throws IOException {
        BufferedWriter out = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("text.txt"), StandardCharsets.UTF_8));
        out.append(text);
        out.close( );
    }
}
