package com.utils.libUpdater;

import com.utils.Downloader;

import java.io.IOException;
import java.net.URL;
public class LibUpdater {
    public static final int JADT = 1;
    public static final int AUDIO = 2;
    public static final int VIDEO = 3;
    public static boolean checkForUpdates(byte LibSoftware) throws IOException {
        boolean isUpdateAvailable = false;
        if( LibSoftware == LibUpdater.JADT){
            Downloader.downloadFile(new URL(""), "JADT_Ver.txt");
        }
        if( LibSoftware == LibUpdater.AUDIO){
            Downloader.downloadFile(new URL(""), "AudioVer.txt");
        }
        if( LibSoftware == LibUpdater.VIDEO){
            Downloader.downloadFile(new URL(""), "VideoVer.txt");
        }
        return isUpdateAvailable;
    }
    public void downloadUpdatedSoftware(byte LibSoftware) throws IOException {
        boolean isUpdateAvailable = checkForUpdates(LibSoftware);
        if( isUpdateAvailable && LibSoftware == LibUpdater.JADT) {
            Downloader.downloadFile(new URL(""),"JADT.jar");
        }
        if( isUpdateAvailable && LibSoftware == LibUpdater.VIDEO) {
            Downloader.downloadFile(new URL(""),"Video.jar");
        }
        if (isUpdateAvailable && LibSoftware == LibUpdater.VIDEO) {
            Downloader.downloadFile(new URL(""),"Video.jar");
        }
        else if (!isUpdateAvailable){
            System.out.println("No Update available");
        }
    }
}
