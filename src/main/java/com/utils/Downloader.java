package com.utils;

import com.jadt_designer.Main;

import java.io.*;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Downloader {
    public static void downloadFile(URL url, String outputFileName) throws IOException {
        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(outputFileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }
    }

    /*public static void downloadFileWithTotalDownloadedData(String Url, String DirectoryOutputFileName) throws MalformedURLException {
        URL url = new URL(Url);
        try (InputStream in = url.openStream();
             ReadableByteChannel rbc = Channels.newChannel(in);
             FileOutputStream fos = new FileOutputStream(DirectoryOutputFileName)) {
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            float size = FileOperations.getFileSizeInMegabytes(DirectoryOutputFileName), downloadedData = 0.0F;
            while (downloadedData <= size) {
                Main.getStatusLabel().setText("Downloaded " + FileOperations.getFileSizeInMegabytes(DirectoryOutputFileName) + "MB out of " + size + "MB");
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
     */
}
class FileOperations {
    public static File getRunning_JAR_FilePath() throws URISyntaxException {
        return new File(Main.class.getProtectionDomain().getCodeSource().getLocation()
                .toURI());
    }

    public static int getFileSize(URL url) {
        URLConnection conn = null;
        try {
            conn = url.openConnection();
            if (conn instanceof HttpURLConnection) {
                ((HttpURLConnection) conn).setRequestMethod("HEAD");
            }
            conn.getInputStream();
            return conn.getContentLength();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn instanceof HttpURLConnection) {
                ((HttpURLConnection) conn).disconnect();
            }
        }
    }

    public static long getFileSizeInBits(String Directory) {
        return new File(Directory).length() * 8;
    }

    public static long getFileSizeInBytes(String Directory) {
        return new File(Directory).length();
    }

    public static long getFileSizeinKilobytes(String Directory) {
        return new File(Directory).length() / 1024;
    }

    public static long getFileSizeInMegabytes(String Directory) {
        return (long) (new File(Directory).length() / Math.pow(1024, 2));
    }

    public static long getFileSizeinGigabytes(String Directory) {
        return (long) (new File(Directory).length() / Math.pow(1024, 3));
    }
    /*
    public static long convertToBits(long value, String inputValueUnit) {
        long size = 0;
        if (inputValueUnit.equals("Bytes")) {
            size = value * 8;
        } else if (inputValueUnit.equals("Kilobytes")) {
            size = value * 1024 * 8;
        } else if (inputValueUnit.equals("Megabytes")) {
            size = value * 1024 * 1024 * 8;
        } else if (inputValueUnit.equals("Gigabytes")) {
            size = value * 1024 * 1024 * 1024 * 8;
        }
        return size;
    }

    public static long convertToBytes(long value, String inputValueUnit) {
        long size = 0;
        if (inputValueUnit.equals("Bits")) {
            size = value / 8;
        } else if (inputValueUnit.equals("Kilobytes")) {
            size = value * 1024;
        } else if (inputValueUnit.equals("Megabytes")) {
            size = value * 1024 * 1024;
        } else if (inputValueUnit.equals("Gigabytes")) {
            size = value * 1024 * 1024 * 1024;
        }
        return size;
    }

    public static long convertToKilobytes(long value, String inputValueUnit) {
        long size = 0;
        if (inputValueUnit.equals("Bits")) {
            size = value / 8 / 1024;
        } else if (inputValueUnit.equals("Bytes")) {
            size = value / 1024;
        } else if (inputValueUnit.equals("Megabytes")) {
            size = value * 1024;
        } else if (inputValueUnit.equals("Gigabytes")) {
            size = value * 1024 * 1024;
        }
        return size;
    }
    */


    public static long convertToMegabytes(long value, String inputValueUnit) {
        long size = 0;
        if (inputValueUnit.equals("Bits")) {
            size = value / 8 / 1024 / 1024;
        } else if (inputValueUnit.equals("Bytes")) {
            size = value / 1024 / 1024;
        } else if (inputValueUnit.equals("Kilobytes")) {
            size = value / 1024;
        } else if (inputValueUnit.equals("Gigabytes")) {
            size = value * 1024;
        }
        return size;
    }

    public static long convertToGigabytes(long value, String inputValueUnit) {
        long size = 0;
        if (inputValueUnit.equals("Bits")) {
            size = value / 8 / 1024 / 1024 / 1024;
        } else if (inputValueUnit.equals("Bytes")) {
            size = value / 1024 / 1024 / 1024;
        } else if (inputValueUnit.equals("Kilobytes")) {
            size = value / 1024 / 1024;
        } else if (inputValueUnit.equals("Megabytes")) {
            size = value / 1024;
        }
        return size;
    }


}