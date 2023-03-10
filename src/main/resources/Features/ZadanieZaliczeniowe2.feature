Feature: MyStore New Order

  Scenario Outline: Adding a new order and completing the order

    When the user logs in to his account by entering <email> and <password>
    And the user selects the product, parameterizes it with <size> and <quantity> goes through the entire product purchase process

    Examples:
    | email            | password   |size | quantity |
    | Janmat@gmail.com | 1234qwer   |M    |5         |