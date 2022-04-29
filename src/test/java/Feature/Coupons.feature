@Regression
Feature: Title of your feature
Background:verify login functionallity
Given user navigate to login page
When user enter username as "admin" and password as "Admin@123"
And click on login
Then user should able to login
    
 Scenario: User is on the login page
 When user navigate to coupons
 When user create new coupon
 And verify the coupon is created
 When user edit the coupon list
 And Verify the edited coupon is in the list
 When user delete coupon
 Then user verify coupon successfully deleted from list
