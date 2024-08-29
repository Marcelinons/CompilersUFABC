# CompilersUFABC
## Repository for the final project of the Compilers course at UFABC, 2024.

#### Project Description:


Asterisco *: significa zero ou muitas ocorrências do que vem antes.
Mais +: significa uma ou muitas ocorrências do que vem antes.  


declare -> começa com aceite de um “Id”, pode continuar com “,” e “Id” infinitas vezes, finaliza declare com “.” 
A palavra declare é um caráter reservado.
Declara -> declare Id (, Id)*.
 

Id -> inicia com “a…z” ou “A…Z”. Mas pode continuar e terminar infinitamente em “a..z”, “A…Z” ou “0…9”
Id -> (a…z | A…Z) (a…z | A…Z | 0…9)*


Num -> contém de 0…9 uma ou muitas ocorrências.
Num -> (0…9)+


Texto -> contém “0…9”, “a…z”, “A…Z”, ‘’, , uma ou muitas ocorrências.
Texto -> “(0…9 | a…z | A…Z | ‘ ’ | )”


Fator -> pode ser Num, Id ou ( Expr )
Fator -> Num | Id | ( Expr )


Termo -> pode ser Termo * Fator, Termo / Fator ou Fator
Termo -> Termo * Fator | Termo / Fator | Fator


Expr -> pode ser Expr + Termo, Expr - Termo ou Termo  
Expr -> Expr + Termo | Expr - Termo | Termo


Derivação da expressão
Expr -> Expr + Termo | Expr - Termo | Termo
Expr -> Expr + Termo | Expr - Termo | Termo * Fator | Termo / Fator | Fator
Expr -> Expr + Termo | Expr - Termo | Termo * Fator | Termo / Fator | Num | Id
Obs: Expr recebe Termo e Fator 


![REQUISITOS PROJETO](https://github.com/user-attachments/assets/66716014-2741-49f8-9e64-94aaff88fbff)
