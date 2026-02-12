package first_level.exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
Aprendràs a:

Escriure una funció testejable basada en una fórmula matemàtica.
Aplicar @ParameterizedTest per comprovar múltiples casos de forma elegant.
Analitzar els resultats i detectar possibles errors en cas que alguna dada no coincideixi amb l’esperat.
Enunciat
Crea una classe anomenada CalculoDni que contingui un mètode públic per calcular la lletra corresponent d’un DNI, donat el número (sense lletra).

Crea una classe de test amb JUnit 5 que parametritzi una sèrie de proves per validar el comportament correcte del càlcul.

El test ha de comprovar com a mínim 10 casos de números de DNI diferents amb la seva lletra corresponent, validant que el resultat del mètode coincideix amb el valor esperat.

També s'ha de validar valors invàlids, com números negatius o massa grans, per comprovar que el mètode gestiona correctament aquestes situacions (per exemple, llençant una excepció).
 */

class IdCalculationTest {

    @Test
    void calculateY(){
        IdCalculation id1 = new IdCalculation(48095145);
        IdCalculation id2 = new IdCalculation(46218815);

        Assertions.assertEquals('y', id1.calculateIdLetter());
        Assertions.assertEquals('q', id2.calculateIdLetter());

    }

}