package second_level;

import first_level.exercise3.Classroom;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;


class JTest implements WithAssertions{


    @Test
    public void exercise1Tests(){
        // Exercici 1:
        assertThat(2).isEqualTo(2);

        // Exercici 2
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array3 = new ArrayList<>(Arrays.asList(3, 4, 5, 5));
        assertThat(array1).isSameAs(array1);
        assertThat(array1).isNotSameAs(array2);

        // Exercici 3:
        assertThat(array2).isNotEqualTo(array3);


        // Exercici 4: Crea un arrayList contenidor de diversos tipus d'objectes (crea'ls també).
        var container = new ArrayList<>();
        container.add(1);
        container.add(array3);
        container.add("Hi");
        // Escriu una asserció per a verificar l'ordre dels objectes en l'ArrayList segons han estat inserits.
        assertThat(container).containsExactly(1, array3, "Hi");
        // Ara verifica que la llista anterior conté els objectes en qualsevol ordre.
        assertThat(container).contains("Hi", 1, array3);
        // Verifica que, en la llista anterior, un dels objectes s'ha afegit només una vegada. Deixa un dels elements sense afegir, i verifica que la llista no conté aquest últim.
        assertThat(container).containsOnlyOnce(1);
        container.remove(2);
        assertThat(container).doesNotContain( "Hi");




        // Exercici 5: Crea un map i verifica que conté una de les key que li afegeix.
        HashMap<Integer, ArrayList<Integer>> testMap = new HashMap<Integer, ArrayList<Integer>>();
        testMap.put(1, array1);
        testMap.put(2, array2);
        assertThat(testMap).containsKey(2);
        assertThat(testMap).doesNotContainKey(3);

        // Exercici 6: Provoca una ArrayIndexOutOfBoundsException en una classe qualsevol. Crea una asserció que validi que l'excepció és llançada quan correspon.
        Classroom ceramics = new Classroom("Ceramics", "John Doe");
        assertThatThrownBy(() -> {ceramics.addInPosition(2, "Larua");}).isInstanceOf(IndexOutOfBoundsException.class);

        // Exercici 7: Crea un objecte Optional buit. Escriu l'asserció correcta per a verificar que efectivament està buit.
        Optional<String> optionalObject = Optional.empty();
        assertThat(optionalObject).isEmpty();
    }

}