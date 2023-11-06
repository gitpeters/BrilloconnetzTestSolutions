import com.peters.user_validation.UserValidationSolution;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserValidationAndJWTTest {
    private String secretKey;

    @BeforeEach
    void setUp() {
        // Initialize the secret key (should match the one in your application)
        secretKey ="secretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecretsecret";
    }

    @Test
    void testGenerateAndVerifyJWT() {
        String username = "peters";

        // Generate a JWT
        String jwt = UserValidationSolution.generateJWT(username);

        // Verify the JWT
        Jws<Claims> claimsJws = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(jwt);

        // Extract and verify the subject (username) from the JWT
        String verifiedUsername = claimsJws.getBody().getSubject();

        // Verify the JWT expiration
        Date expirationDate = claimsJws.getBody().getExpiration();
        Date now = new Date();
        assertNotNull(expirationDate);
        assert expirationDate.after(now);

        // Perform the actual verification
        assertEquals(username, verifiedUsername);
    }
}
