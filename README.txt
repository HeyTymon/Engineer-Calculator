Kalkulator pozwalający na przeliczanie liczb dziesiętnych na liczby w kodach InQk

Autor: Tymon Jastrzębski 

Budowa programu:

1) Panel logowania
   - W celu zalogowania się do kalkulatora należy podać login oraz hasło użytkownika, które znajdują się w pliku data.txt.
     Dane ustawione są w kolejności login, a następnie hasło (następnie dane kolejnych użytkowników).
   - Program porównuję podane dane logowania, jeśli są nieprawidłowi zwrócić błąd. W przypadku podania poprawnych danych
     użytkownik zostanie przeniesiony do następnego panelu.

2) Kalkulator
   - Panel kalkulatora zawiera kilka pól informacyjnych, w których użytkownik ustawia kod na jakim chciałby pracować:
     a) Qn Field - wartość Q, czyli ile bitów (max 15) chce przeznaczyć na część ułamkową.
     b) U2 CheckBox - wybrany wskazuje na możliwość obsługi liczb w kodzie U2.
     c) HEX - użytkownik ustawia czy chce dokonać przeliczenia z liczby dziesiętnej na liczbę w kodzie InQk czy na odwrót.
   - Poniżej znajdują się trzy przyciski:
     a) Calculate Button - dokonuje przeliczenia.
     b) Save Button - umożliwia zapis obliczonej wartości do pliku values.txt.
     c) Create new user Button - umożliwia dodanie nowego użytkownika jeśli użytkownik jest zalogowany jako administrator (admin, admin1).

3) Panel dodawania nowego użytkownika
   - Jeśli użytkownik jest zalogowany jako administrator, panel ten umożliwia dodanie nowego użytkownika. Login oraz hasło są zapisywane
     do pliku data.txt.

Warunki poprawnego działania programu:
   - Części ułamkowe w liczbach dziesiętnych należy zapisywać zgodnie z amerykańską notacją "." jako separator.

Możliwości rozszerzenia programu:
   - Stworzenie warunków tworzenia hasła (wymagana 1 mała, 1 duża litera itp.).

Bibliografia:
   - Instrukcja z labaoratorium Procesorów Sygnałowych (zawarte są w niej zasady przeliczania oraz kilka przykładów to przetestowania poprawności
     działania programu).
