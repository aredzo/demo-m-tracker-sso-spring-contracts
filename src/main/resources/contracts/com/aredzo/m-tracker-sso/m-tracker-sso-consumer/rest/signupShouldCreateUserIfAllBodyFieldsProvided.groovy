
import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            name("regular user signup")
            description("""
Given:
    All required fields are set in requestBody
When:
    Signup request is executed with requestBody
Then:
    UserTokenResponse is returned
""")
            request {
                method POST()
                url "/sso/v1/users/signup"
                body(
                        email: anyEmail(),
                        password: anyNonEmptyString()
                )
                headers {
                    contentType applicationJson()
                }

            }

            response {
                status(OK())
                headers {
                    contentType applicationJson()
                }
                body(
                        userId: anyPositiveInt(),
                        email: anyEmail(),
                        token: anyUuid()
                )
            }
        },
        Contract.make {
            name("service user signup")
            description("""
Given:
    All required fields are set in requestBody
When:
    Signup request is executed with requestBody
Then:
    UserTokenResponse is returned
""")
            request {
                method POST()
                url "/sso/v1/int/users/signup"
                body(
                        email: anyEmail(),
                        password: anyNonEmptyString()
                )
                headers {
                    contentType applicationJson()
                }

            }

            response {
                status(OK())
                headers {
                    contentType applicationJson()
                }
                body(
                        userId: anyPositiveInt(),
                        email: anyEmail(),
                        token: anyUuid()
                )
            }
        }
]
