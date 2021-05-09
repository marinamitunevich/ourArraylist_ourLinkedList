package relran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AutoTest {
    OurArrayList<Auto> autoList = new OurArrayList<>();
    Comparator<Auto> comparatorByPrice;
    Auto a1 = new Auto("Audi","blue",30000);
    Auto a2 = new Auto("BMW","red",40000);
    Auto a3 = new Auto("Skoda","blue",28000);
    Auto a4 = new Auto("Mazda","white",23000);
    Auto a5 = new Auto("Audi","black",10000);
    Auto [] autos;

    @BeforeEach
    void setUp() {
        autos = new Auto[]{a1, a2, a3, a4, a5};
        comparatorByPrice = new ComparatorsByPrice();
        for(int i = 0; i<autos.length;i++){
            autoList.add(autos[i]);
        }
    }
    @Test
    public void test_minByPrice(){
        long minPrice = 10000;
        assertEquals(minPrice,(autoList.min(comparatorByPrice)).getPrice());
    }
    @Test
    public void test_maxByPrice(){
        long maxPrice = 40000;
        assertEquals(maxPrice,(autoList.max(comparatorByPrice)).getPrice());
    }
    @Test
    public void test_sortOfAutos(){
        Auto [] autosSorted = {a5,a4,a3,a1,a2};
        autoList.sort(comparatorByPrice);

        int i = 0;
        for(Auto a : autoList){
            assertTrue(autosSorted[i].equals(autoList.get(i)));
            i++;
        }

    }
}