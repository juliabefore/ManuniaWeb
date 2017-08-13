package com.miskevich.manuniaweb;

import com.miskevich.manuniaweb.utils.DirectoryScanner;
import com.miskevich.manuniaweb.utils.zip.Unzipper;

public class ManuniaWebServer {

    public static void main(String[] args) {
        while (true) {
            DirectoryScanner directoryScanner = new DirectoryScanner();
            String warFileName = directoryScanner.scanDirectoryForNewWars();
            Unzipper unzipper = new Unzipper(warFileName);
            unzipper.unzip();
            unzipper.findWebXml();
        }
    }
}
