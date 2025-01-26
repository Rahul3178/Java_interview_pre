package com.interview.java.Threading;
import java.io.*;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * In this example we implemented multithreading
 */


public class FileDownloader {
    public static void main(String[] args) {
        String[] urls = {
            "https://example.com/file1.txt",
            "https://example.com/file2.txt",
            "https://example.com/file3.txt"
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String url : urls) {
            executor.submit(new DownloadTask(url));
        }

        executor.shutdown();
    }
}

class DownloadTask implements Runnable {
    private final String url;

    public DownloadTask(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        try {
            downloadFile(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void downloadFile(String urlString) throws IOException {
        URL url = new URL(urlString);
        InputStream in = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String fileName = urlString.substring(urlString.lastIndexOf('/') + 1);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        String line;
        while ((line = reader.readLine()) != null) {
            writer.write(processData(line));
            writer.newLine();
        }

        reader.close();
        writer.close();
        System.out.println("Downloaded and processed: " + fileName);
    }

    private String processData(String data) {
        // Dummy processing: convert to uppercase
        return data.toUpperCase();
    }
}
