#Feature: DELETEPosts
#  Verify different DELETE operations using REST-assured

#  Scenario: Verify DELETE operation after POST
#    Given I ensure to perform POST operation for "/posts" with body as
#      |id|title      |author        |
#      |6 |Api Testing|Gilberto Mares|
#    And I perform DELETE operation for "/posts/{postsid}/"
#      |postsid|
#      |6     |
#    And I perform GET operation with path parameters for "/post/{postsid}"
#      |postsid|
#      |6     |
#    Then I should not see the body with title "Api Testing"