Feature: SearchBook

  Background: The System has a repository of books with their specifications
    (title-author-isbn-Signature)

    Given these books are contained in the system
      | Adventure of sherlock holmes_Arthur Conan doyle_0192123181_doyle1993 |
      | Crime and Punishment_Fyodor Dostoevsky_0486415872_dostoevsky1866     |
      | The Idiot_Fyodor Dostoevsky_014044792X_dostoevsky1869                |
      | The Child Book of the Seasons_Arthur Ransome_0192123182_Ransome2012  |

  Scenario Outline: Search book for a substring of the title
    When user searches about book by title <title>
    Then A book or list of books with this title should be returned and printed on the console

    Examples: 
      | title                  |
      | "adventure"            |
      | "book"                 |
      | "anything"             |
      | "Crime and Punishment" |

  Scenario Outline: Searching for a substring of the author
    When user searches for a book by author <author>
    Then A book or list of books for this author should be returned and printed on the console

    Examples: 
      | author              |
      | "Fyodor Dostoevsky" |
      | "Arthur"            |
      | "nour"              |
      | "Dostoevsky"        |

  Scenario: Searching for a substring of the ISBN
    When user searches for a book by isbn "0486415872"
    Then A book with this isbn should be returned and printed on the console



  Scenario: search for a book when the administrator is logged in
    When admin with username "admin" and logging status is "true" searches for a book with signature "dostoevsky1866"
    Then A book with this signature will be printed
