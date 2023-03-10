Feature: MyStore Add new Address

  Scenario Outline: Adding a new address to your account on the website MyStore

    When the user logs in to his account by entering <email> and <password>
    And  the user adds a new address by completing the required fields: <alias>, <address>, <city>, <postalCode>, <country>, <phone>
    And  the user checks whether the address has been added correctly, then removes it by checking whether it has been removed correctly

    Examples:
    | email            | password  | alias | address      | city  |postalCode | country        |phone    |
    | Janmat@gmail.com | 1234qwer  | Work  | 18 Benson St | Leeds | LS7       | United Kingdom |070088099|
