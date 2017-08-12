package com.miskevich.manuniaweb.utils.zip

import org.testng.annotations.Test


class UnzipperTest {

    @Test
    void testUnzip() {
        Unzipper unzipper = new Unzipper()
        unzipper.unzip('tomcat-example-0.0.1.war')

        Unzipper unzipper2 = new Unzipper()
        unzipper2.unzip('example.war')

        Unzipper unzipper3 = new Unzipper()
        unzipper3.unzip('example-0.0.1.war')
    }
}
