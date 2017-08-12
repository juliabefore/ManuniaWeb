package com.miskevich.manuniaweb.utils.zip;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzipper {

    private static final String FILE_LOCATION = "src/main/webapp" + File.separator;
    private static final int BUFFER_SIZE = 1024;
    private File DESTINATION_DIRECTORY;
    private String zipFileName;

    public Unzipper(String zipFileName) {
        String extension = zipFileName.substring(zipFileName.lastIndexOf('.'));

        File destinationDirectory = new File(FILE_LOCATION + zipFileName.substring(0, zipFileName.length() - extension.length()));
        this.DESTINATION_DIRECTORY = new File(destinationDirectory + File.separator + "WEB-INF");
        this.zipFileName = zipFileName;
    }

    public void unzip() {
        if(!DESTINATION_DIRECTORY.mkdir()){
            throw new RuntimeException("Dir wasn't created");
        }

        try (ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(new FileInputStream(FILE_LOCATION + zipFileName)))) {
            ZipEntry entry = zipInputStream.getNextEntry();
            while (entry != null) {
                String destinationFilePath = DESTINATION_DIRECTORY + File.separator + entry.getName();
                if (!entry.isDirectory()) {
                    extractFile(zipInputStream, destinationFilePath);
                } else {
                    File directory = new File(destinationFilePath);
                    if(!directory.mkdir()){
                        throw new RuntimeException("Dir wasn't created");
                    }
                }
                zipInputStream.closeEntry();
                entry = zipInputStream.getNextEntry();
            }
            System.out.println("File " + zipFileName + " was unzipped");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void extractFile(ZipInputStream zipInputStream, String destinationFilePath) {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destinationFilePath))) {
            byte[] buffer = new byte[BUFFER_SIZE];
            int read;
            while ((read = zipInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void findWebXml() {
        //File dir = new File(DESTINATION_DIRECTORY);
        FilenameFilter filter = (dir1, name) -> name.equals("web.xml");

        String[] files = DESTINATION_DIRECTORY.list(filter);
        if (null != files && files.length != 1) {
            throw new RuntimeException("web.xml doesn't exist!");
        }

        System.out.println(files[0]);
    }
}
