Feature: Login to DummyJSOn Login

	Scenario Outline: Login with Multiple Users
		Given user prepare login payload with "<username>" and "<password>"
		When user send POST request to "https://dummyjson.com/auth/login"
		Then response status code should be <statusCode>
		
		Examples:
| username | password    | statusCode |
| emilys   | emilyspass  | 200        |
| emilys   | wrongpass   | 400        |
|          | emilyspass  | 400        |
| emilys   |             | 400        |
