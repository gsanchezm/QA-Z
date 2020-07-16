Feature: PUTPost
  Verify put post operation

  @smoke
  Scenario: Verify PUT operation after POST
    Given I ensure to perform POST operation for "/posts" with body as
      |id|title      |author        |
      |6 |Api Testing|Gilberto Mares|
    And  I perform PUT operation for "/posts/{postid}/"
      |id|title      |author        |
      |6 |Api Testing|Gilberto Mares|
   And I perform GET operation with path parameter for "/posts/{postid}"
      | postid |
      | 6      |
    Then I "should" not see the body with title "Api Testing"