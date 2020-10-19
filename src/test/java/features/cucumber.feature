@ApiTest
  Feature: Api Test

    Scenario: Api Test
      When I am on the BasePage "nesine.com"
      And I set LoginPage : username "username" and password "password"
      And Click : LoginPage : LoginButton
      And Click : HomePage : PopularBetsButton
      Then Verify : PopularBetsPage : url "https://www.nesine.com/iddaa/populer-bahisler"
      And Click : PopularBetsPage : FootballButton
      Then Verify : Api
      And Click : HomePage : MyAccountButton
      And Click : HomePage : LogoutButton
