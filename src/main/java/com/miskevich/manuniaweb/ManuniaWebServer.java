package com.miskevich.manuniaweb;

import com.miskevich.manuniaweb.utils.DirectoryScanner;
import com.miskevich.manuniaweb.utils.zip.Unzipper;

public class ManuniaWebServer {

    public static void main(String[] args) {
        DirectoryScanner directoryScanner = new DirectoryScanner();
        while (true) {
            String warFileName = directoryScanner.scanDirectoryForNewWars();
            Unzipper unzipper = new Unzipper(warFileName);
            unzipper.unzip();
            unzipper.findWebXml();
        }
    }
}
