
import org.springframework.cloud.contract.spec.Contract


[
        Contract.make {
            name("regular user signup - email field missing")
            description("""
Given:
    Field in requestBody is missing
When:
    Signup request is executed with requestBody
Then:
    ErrorResponse is returned
""")
            request {
                method POST()
                url "/sso/v1/users/signup"
                body(
                        email: null,
                        password: anyNonEmptyString()
                )
                headers {
                    contentType applicationJson()
                }

            }

            response {
                status(BAD_REQUEST())
                headers {
                    contentType applicationJson()
                }
                body(
                        errorCode: 400,
                        errorMessage: "Bad Request",
                )
            }
        },

        Contract.make {
            name("regular user signup - password field missing")
            description("""
Given:
    Field in requestBody is missing
When:
    Signup request is executed with requestBody
Then:
    ErrorResponse is returned
""")
            request {
                method POST()
                url "/sso/v1/users/signup"
                body(
                        email: anyEmail(),
                        password: null
                )
                headers {
                    contentType applicationJson()
                }

            }

            response {
                status(BAD_REQUEST())
                headers {
                    contentType applicationJson()
                }
                body(
                        errorCode: 400,
                        errorMessage: "Bad Request",
                )
            }
        },
        Contract.make {
            name("service signup - email field missing")
            description("""
Given:
    Field in requestBody is missing
When:
    Signup request is executed with requestBody
Then:
    ErrorResponse is returned
""")
            request {
                method POST()
                url "/sso/v1/int/users/signup"
                body(
                        email: null,
                        password: anyNonEmptyString()
                )
                headers {
                    contentType applicationJson()
                }

            }

            response {
                status(BAD_REQUEST())
                headers {
                    contentType applicationJson()
                }
                body(
                        errorCode: 400,
                        errorMessage: "Bad Request",
                )
            }
        },

        Contract.make {
            name("service user signup - password field missing")
            description("""
Given:
    Field in requestBody is missing
When:
    Signup request is executed with requestBody
Then:
    ErrorResponse is returned
""")
            request {
                method POST()
                url "/sso/v1/int/users/signup"
                body(
                        email: anyEmail(),
                        password: null
                )
                headers {
                    contentType applicationJson()
                }

            }

            response {
                status(BAD_REQUEST())
                headers {
                    contentType applicationJson()
                }
                body(
                        errorCode: 400,
                        errorMessage: "Bad Request",
                )
            }
        }
]