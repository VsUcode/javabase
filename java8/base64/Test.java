package com.vsu.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/** Base64
 * Created by vsu on 2017/11/23.
 *
 * 在Java 8中，Base64编码已经成为Java类库的标准
 * Base64类同时还提供了对URL、MIME友好的编码器与解码器（Base64.getUrlEncoder() / Base64.getUrlDecoder(), Base64.getMimeEncoder() / Base64.getMimeDecoder()）。
 */
public class Test {
    public static void main(String[] args) {
        final String text = "Base64 finally in Java 8!";

        final String encoded = Base64
                .getEncoder()
                .encodeToString( text.getBytes( StandardCharsets.UTF_8 ) );
        System.out.println( encoded );//QmFzZTY0IGZpbmFsbHkgaW4gSmF2YSA4IQ==

        final String decoded = new String(
                Base64.getDecoder().decode( encoded ),
                StandardCharsets.UTF_8 );
        System.out.println( decoded );//Base64 finally in Java 8!

    }
}
