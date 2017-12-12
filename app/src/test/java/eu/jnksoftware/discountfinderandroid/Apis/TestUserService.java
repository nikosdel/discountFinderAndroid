package eu.jnksoftware.discountfinderandroid.Apis;

import junit.framework.TestCase;

import org.junit.Test;

import java.io.IOException;

import eu.jnksoftware.discountfinderandroid.Apis.ApiUtils;
import eu.jnksoftware.discountfinderandroid.models.UserTokenRequest;
import eu.jnksoftware.discountfinderandroid.models.UserTokenResponse;
import eu.jnksoftware.discountfinderandroid.services.IuserService;

/**
 * Created by nikos on 1/12/2017.
 */

public class TestUserService extends TestCase {
    @Test
    public void testTokenType() throws IOException

    {
        IuserService s = ApiUtils.getUserService();
        UserTokenRequest userTokenRequest = new UserTokenRequest();
        userTokenRequest.setUsername("n@gmail.com");
        userTokenRequest.setPassword("123455");

        UserTokenResponse userTokenResponse = s.getTokenAcess(userTokenRequest).execute().body();
        assertEquals("Bearer", userTokenResponse.getTokenType().toString());
    }
    public void testAccesType() throws IOException{
        IuserService s = ApiUtils.getMockUserService();
        UserTokenRequest userTokenRequest = new UserTokenRequest();
        userTokenRequest.setUsername("n@gmail.com");
        userTokenRequest.setPassword("123455");

        UserTokenResponse userTokenResponse = s.getTokenAcess(userTokenRequest).execute().body();
        assertEquals("mock_access", userTokenResponse.getAccessToken().toString());
    }
    public void testExpiresIn() throws IOException{
        IuserService s = ApiUtils.getMockUserService();
        UserTokenRequest userTokenRequest = new UserTokenRequest();
        userTokenRequest.setUsername("n@gmail.com");
        userTokenRequest.setPassword("123455");

        UserTokenResponse userTokenResponse = s.getTokenAcess(userTokenRequest).execute().body();
        assertEquals("7199", userTokenResponse.getExpiresIn().toString());
    }
    public void testRefreshToken() throws IOException{
        IuserService s = ApiUtils.getMockUserService();
        UserTokenRequest userTokenRequest = new UserTokenRequest();
        userTokenRequest.setUsername("n@gmail.com");
        userTokenRequest.setPassword("123455");

        UserTokenResponse userTokenResponse = s.getTokenAcess(userTokenRequest).execute().body();
        assertEquals("mock_refresh", userTokenResponse.getRefreshToken().toString());
    }
}