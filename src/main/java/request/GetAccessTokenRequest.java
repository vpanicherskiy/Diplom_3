package request;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetAccessTokenRequest {
    private String email;
    private String password;
}
