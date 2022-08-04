package dao;

import exception.TextNotFoundException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StrimDao {

    static RandomAccessFile randomAccessFile;

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
        StringBuilder builder = new StringBuilder( );
        channel.read(byteBuffer);
        // переключаем буфер с режима записи на режим чтения
        byteBuffer.flip( );
        String result = new String(byteBuffer.array( ), StandardCharsets.UTF_8);
       if (result.length()<1)  throw  new TextNotFoundException("файл пустой, поместите текст в файл");
        return result;

    }


    public static void outputFiles(String text) throws IOException {
        randomAccessFile.seek(0);
        // создаем буфер конкретно под нашу строку — строку переводим в массив и берем его длину
//        ByteBuffer byteBuffer2 = ByteBuffer.allocate(text.getBytes( ).length);
        ByteBuffer byteBuffer2 = Charset.forName("UTF-8").encode(text);
        // записываем нашу строку в буфер
        byteBuffer2.put(text.getBytes( ));
        // чтобы канал смог прочитать из буфера и записать нашу строку в файл
        byteBuffer2.flip( );
        // канал читает информацию из буфера и записывает ее в наш файл
        channel.write(byteBuffer2);
    }


}



