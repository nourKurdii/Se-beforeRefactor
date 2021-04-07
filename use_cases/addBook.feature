Feature: add book
  Add a book to the library, the administrator has to be logged in.

  Scenario Outline: Add a book when the administrator is logged in
    Given admin with username "admin" and logging status is "true"
    When admin wanna add a book with <title> and <author> and <isbn> and <signature>
    Then addition status will be "true"

    Examples: 
      | title                          | author              | isbn         | signature        |
      | "Adventure of sherlock holmes" | "Conan doyle"       | "0192123181" | "doyle1993"      |
      | "Crime and Punishment"         | "Fyodor Dostoevsky" | "0486415872" | "dostoevsky1866" |
      | "The Idiot"                    | "Fyodor Dostoevsky" | "014044792X" | "dostoevsky1869" |
      | "nn"                           | "nnn"               | "000"        | "nnn"            |

  Scenario: Add a book when the administrator is not logged in
    Given admin with username "admin" and logging status is "false"
    When admin wanna add a book with title "Adventure of sherlock holmes" and author "Conan doyle" and isbn "0192123181" and sign "doyle1993"
    Then addition status will not be "true"