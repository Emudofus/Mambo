package org.mambo.core.cipher;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Blackrush
 */
public class DigestCipherTest {
    private final String input = "hello world",
                         salt  = "mysecuresalt";

    @Test
    public void md5() {
        CipherInterface cipher = DigestCipher.md5();
        String expected = "5eb63bbbe01eeed093cb22bb8f5acdc3";

        assertThat(cipher.hexcipher(input), is(expected));
    }

    @Test
    public void md5WithSalt() {
        DigestCipher cipher = DigestCipher.md5();
        String expected = "fab7bdd351576e37ea7212cbee86ca4c";

        assertThat(cipher.hexcipher(input, salt), is(expected));
    }

    @Test
    public void sha1() {
        CipherInterface cipher = DigestCipher.sha1();
        String expected = "2aae6c35c94fcfb415dbe95f408b9ce91ee846ed";

        assertThat(cipher.hexcipher(input), is(expected));
    }

    @Test
    public void sha1WithSalt() {
        DigestCipher cipher = DigestCipher.sha1();
        String expected = "5439a2d2b7dd2d509dfdf1f1dea8b4338fcbeaad";

        assertThat(cipher.hexcipher(input, salt), is(expected));
    }

    @Test
    public void sha256() {
        CipherInterface cipher = DigestCipher.sha256();
        String expected = "b94d27b9934d3e08a52e52d7da7dabfac484efe37a5380ee9088f7ace2efcde9";

        assertThat(cipher.hexcipher(input), is(expected));
    }

    @Test
    public void sha256WithSalt() {
        DigestCipher cipher = DigestCipher.sha256();
        String expected = "a0591032d697e2942a2798e0a49aec5874307fbe86d949f5cb176c464cf0bbd4";

        assertThat(cipher.hexcipher(input, salt), is(expected));
    }

    @Test
    public void sha512() {
        CipherInterface cipher = DigestCipher.sha512();
        String expected = "309ecc489c12d6eb4cc40f50c902f2b4d0ed77ee511a7c7a9bcd3ca86d4cd86f989dd35bc5ff499670da34255b45b0cfd830e81f605dcf7dc5542e93ae9cd76f";

        assertThat(cipher.hexcipher(input), is(expected));
    }

    @Test
    public void sha512WithSalt() {
        DigestCipher cipher = DigestCipher.sha512();
        String expected = "3d543a648e6f2b8560696e0a9eaf0063be1fe3cc802c95fa0d39ecb77ce4a1515af8dc428cdf1397baf29622957d1c1f8299ccbee5540ad2edbc501990cf5132";

        assertThat(cipher.hexcipher(input, salt), is(expected));
    }
}
