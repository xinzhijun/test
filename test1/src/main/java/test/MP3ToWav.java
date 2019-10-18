package test;

import java.io.*;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;



/**
        * <Description>
        *
        * @author wangqi
        * @version 1.0
        * @see test
        * @since 2019/10/12 16:20
        */
public class MP3ToWav {
    /**
     * mp3的字节数组生成wav文件
     */
    public static void main(String[] args) throws Exception {
        parse("E://wa//4.mp3", "E://wa//11.wav");
    }

    public static void parse(String source, String target) throws Exception {
        float sampleRate = 16000;
        int sampleSizeInBits = 16;
        int channels = 1;
        boolean signed = true;
        boolean bigEndian = false;
        AudioFormat af = new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
        File sourceFile = new File(source);
        FileOutputStream out = new FileOutputStream(new File(target));
        AudioInputStream audioInputStream = new AudioInputStream(new FileInputStream(sourceFile), af, sourceFile.length());
        AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, out);
        audioInputStream.close();
        out.flush();
        out.close();
    }

}