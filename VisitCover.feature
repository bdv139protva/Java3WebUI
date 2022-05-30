Feature: Посещение сраницы в разделе спецпроекта

  Background:
    Given user on main page

    @hooks
      @close
  Scenario Outline:
    When close cookie block
    And search '<searchText>' in search block
    And select entity '<entity>'
    Then check correct cover in page
    Examples:
      | searchText | entity           |
      | Пушкин     | Здесь был Пушкин |



