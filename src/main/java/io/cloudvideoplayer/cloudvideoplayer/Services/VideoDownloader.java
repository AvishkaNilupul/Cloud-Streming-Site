package io.cloudvideoplayer.cloudvideoplayer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class VideoDownloader {
    public void VideoDownload() throws IOException {

        String destPath = "Videos"+ File.separator+ "test.mp4" ;
        String directoryPath = destPath.substring(0, destPath.lastIndexOf(File.separator));
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created: " + directoryPath);
            } else {
                System.err.println("Failed to create directory: " + directoryPath);
            }
        }

        URL url = new URL("");
        try (InputStream inputStream = url.openStream();
             FileOutputStream fileOutputStream = new FileOutputStream(destPath)) {

            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1) {
                fileOutputStream.write(bytes, 0, len);
            }
        }
        System.out.println("Download Done!");

    }

}
