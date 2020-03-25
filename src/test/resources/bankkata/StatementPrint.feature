Feature: Statement Print
  When I print my statement after a few
  deposits and withdrawals it should reflect the current status

  Scenario: New account deposit
    Given I deposit 1000
    And I deposit 2000
    And I withdraw 500
    When I print the statement
    Then I should see
    """
  date       || credit   || debit    || balance
  14/01/2012 ||          || 500.00   || 2500.00
  13/01/2012 || 2000.00  ||          || 3000.00
  10/01/2012 || 1000.00  ||          || 1000.0
    """