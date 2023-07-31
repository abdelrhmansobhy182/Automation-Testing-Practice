Feature: user should be able to enter information data
  Background: User register in website
    Given  Navigate to Website




  Scenario Outline: User enter data in field using Examples
    And Enter data"<Name>""<Email>""<Phone>""<Address>""<Gender>"
    And User select the day : "<Days>"
    And User select the country : "<Country>"
    And User select the color: "<Colors>"
    And User select the Date : "<Date>"
    Examples:
      | Name | Email | Phone | Address | Gender  |Days|Country|Colors|Date|
      |Abdelrahman Sobhy|abdo@gmail.com |01124542365 |Cairo | Male  |sunday|Canada |Blue|18022023|
      |Salma Ramy       |Salma@gmail.com |01123456785 |Cairo |Female |monday|Germany|Green|02052022|


  Scenario Outline: User enter data in field using Excel Sheet
    And Enter information data of user in Test Case : "<TestCase>"
    Examples:
      | TestCase |
      |1|
      |2|