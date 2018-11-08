package App.Model;

import java.util.Vector;

public class PatienceSorter
{
    private long time = 0;
    public long getTime() {
        return time;
    }

    private long exchanges = 0;
    public long getExchanges() {
        return exchanges;
    }

    private long comparison = 0;
    public long getComparison() {
        return comparison;
    }

    public PatienceSorter() { }

    public void sort(int[] n) {
        time = 0;
        exchanges = 0;
        comparison = 0;

        long startTime = System.currentTimeMillis();

        Vector piles = new Vector(0, 1);
        Vector first = new Vector(0, 1);
        //Создаём первоначальную стопку
        //Ставим на её вершину наш первый элемент
        first.add(new Integer(n[0]));
        exchanges++;
        piles.add(first);
//Сортировка в стопках
        for (int a = 1; a < n.length; a++) {
            boolean notFound = true;
            for (int i = 0; i < piles.size() && notFound; i++) {
                Vector pile = (Vector) (piles.get(i));
                //Если новый элемент меньше элемента на вершине стопки
                int top = ((Integer) pile.get(pile.size() - 1)).intValue();
                comparison++;
                if (top >= n[a])
                {
                    //Добавляем этот элемент в стопку
                    pile.add(new Integer(n[a]));
                    exchanges++;
                    notFound = false;
                }
            }
            //Иначе создаём новую стопку справа
            //И делаем этот элемент её вершиной
            if (notFound) {
                Vector newPile = new Vector(0, 1);
                newPile.add(new Integer(n[a]));
                exchanges++;
                piles.add(newPile);
            }
        }
        //Ищем минимальный элемент в стопках
        int c = 0;
        while (c < n.length) {
            int small = 0;
            for (int a = 1; a < piles.size(); a++) {
                Vector pile1 = (Vector) piles.get(a);
                Vector pile2 = (Vector) piles.get(small);
                int n1 = ((Integer) pile1.get(pile1.size() - 1)).intValue();
                int n2 = ((Integer) pile2.get(pile2.size() - 1)).intValue();
                comparison++;
                if (n1 < n2) {
                    small = a;
                }
            }
            //Заносим в массив минимальный элемент
            Vector smallPile = (Vector) piles.get(small);
            n[c] = ((Integer) smallPile.get(smallPile.size() - 1)).intValue();
            exchanges++;
            smallPile.remove(smallPile.size() - 1);
            if (((Vector) piles.get(small)).size() == 0) {
                piles.remove(small);
            }
            c++;
        }

        long stopTime = System.currentTimeMillis();
        time = stopTime - startTime;
    }
}

